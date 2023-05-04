package ru.sartfoms.personinfoservice.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

import javax.xml.transform.TransformerException;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceMessageExtractor;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.SoapFaultClientException;
import org.springframework.ws.support.MarshallingUtils;

import ru.sartfoms.personinfoservice.entity.MPIError;
import ru.sartfoms.personinfoservice.entity.MPIReq;
import ru.sartfoms.personinfoservice.entity.MergeAncessorOip;
import ru.sartfoms.personinfoservice.repository.MPIErrorRepository;
import ru.sartfoms.personinfoservice.repository.MPIReqRepository;
import ru.sartfoms.personinfoservice.repository.MergeAncessorOipRepository;
import ru.sartfoms.schemas.generated.GetMergeAncessorOipRequest;
import ru.sartfoms.schemas.generated.GetMergeAncessorOipResponse;
import ru.sartfoms.schemas.generated.PersonSearchInfo;
import ru.sartfoms.schemas.generated.ResponseErrorData;

@Service
public class GetMergeAncessorOip extends PersonInfoService {
	private final WebServiceTemplate template;
	private final MPIReqRepository mpiReqRepository;
	private final MPIErrorRepository mpiErrorRepository;
	private final MergeAncessorOipRepository mergeAncessorOipRepository;

	public GetMergeAncessorOip(WebServiceTemplate template, MergeAncessorOipRepository mergeAncessorOipRepository,
			MPIReqRepository mpiReqRepository, MPIErrorRepository mpiErrorRepository) {
		this.template = template;
		this.mpiReqRepository = mpiReqRepository;
		this.mpiErrorRepository = mpiErrorRepository;
		this.mergeAncessorOipRepository = mergeAncessorOipRepository;
	}

	@Override
	@Scheduled(cron = "0 0/10 8-23 * * *")
	public void process() {
		Collection<MergeAncessorOip> entities = mergeAncessorOipRepository.findByDtreqIsNull();
		entities.forEach(entity -> {
			String extRid = UUID.randomUUID().toString();
			try {
				GetMergeAncessorOipResponse response = template.sendAndReceive(new WebServiceMessageCallback() {

					@Override
					public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
						MarshallingUtils.marshal(template.getMarshaller(), getRequest(), message);

						ByteArrayOutputStream out = new ByteArrayOutputStream();
						message.writeTo(out);
						MPIReq mpiReq = new MPIReq();
						mpiReq.setRid(entity.getRid());
						mpiReq.setDt(LocalDateTime.now());
						mpiReq.setReq(out.toByteArray());
						mpiReq.setExtrid(extRid);

						mpiReqRepository.save(mpiReq);
					}

					private GetMergeAncessorOipRequest getRequest() {
						GetMergeAncessorOipRequest request = new GetMergeAncessorOipRequest();
						request.setExternalRequestId(extRid);
						request.setPersonSearchInfo(new PersonSearchInfo());
						request.getPersonSearchInfo().setOip(entity.getOip());

						return request;
					}

				}, new WebServiceMessageExtractor<GetMergeAncessorOipResponse>() {

					@Override
					public GetMergeAncessorOipResponse extractData(WebServiceMessage message)
							throws IOException, TransformerException {
						ByteArrayOutputStream out = new ByteArrayOutputStream();
						message.writeTo(out);
						MPIReq mpiReq = mpiReqRepository.getByExtrid(extRid);
						mpiReq.setResp(out.toByteArray());

						mpiReqRepository.save(mpiReq);

						return (GetMergeAncessorOipResponse) MarshallingUtils.unmarshal(template.getUnmarshaller(),
								message);
					}
				});

				save(entity, response, extRid);

			} catch (SoapFaultClientException e) {
				entity.setDtreq(LocalDateTime.now());
				entity.setHasError(true);

				mergeAncessorOipRepository.save(entity);

				MPIError errEntity = new MPIError();
				errEntity.setRid(entity.getRid());
				errEntity.setNr(1);
				errEntity.setCode(e.getClass().getSimpleName());
				errEntity.setMessage(e.getFaultStringOrReason());
				errEntity.setDtIns(LocalDateTime.now());
				errEntity.setExtrid(extRid);
				errEntity.setType(SOAP_ERR);

				mpiErrorRepository.save(errEntity);
			}
		});
	}

	private void save(MergeAncessorOip entity, GetMergeAncessorOipResponse response, String extRid) {
		if (response.getErrors() != null && response.getErrors().getErrorItem().size() == 1 && response.getErrors()
				.getErrorItem().stream().findAny().get().getCode().trim().equals(INTERNAL_SERVICE_ERROR)) {
			// do nothing
		} else {
			entity.setDtreq(LocalDateTime.now());
			entity.setHasError(response.getErrors() != null ? true : false);

			mergeAncessorOipRepository.save(entity);
		}

		if (response.getErrors() != null) {
			Collection<ResponseErrorData> errors = response.getErrors().getErrorItem();
			int nr = 0;
			for (ResponseErrorData err : errors) {
				if (err.getCode().trim().equals(INTERNAL_SERVICE_ERROR))
					continue; // do nothing
				MPIError errEntity = new MPIError();
				errEntity.setRid(entity.getRid());
				errEntity.setNr(++nr);
				errEntity.setCode(err.getCode());
				errEntity.setMessage(err.getMessage());
				errEntity.setTag(err.getTag());
				errEntity.setValue(err.getValue());
				errEntity.setDtIns(LocalDateTime.now());
				errEntity.setExtrid(extRid);
				errEntity.setType(LOGIC_ERR);

				mpiErrorRepository.save(errEntity);
			}
		} else {
			entity.setWhenMerged(response.getMergeAncessorOip().getWhenMerged().toGregorianCalendar().toZonedDateTime()
					.toLocalDateTime());
			entity.setMergeAncessorOip(response.getMergeAncessorOip().getMergeAncessorOip());

			mergeAncessorOipRepository.save(entity);
		}

	}

}
