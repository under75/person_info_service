package ru.sartfoms.personinfoservice.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.transform.TransformerException;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceMessageExtractor;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.SoapFaultClientException;
import org.springframework.ws.support.MarshallingUtils;

import ru.sartfoms.personinfoservice.entity.InsuranceStatus;
import ru.sartfoms.personinfoservice.entity.InsuranceStatusResp;
import ru.sartfoms.personinfoservice.entity.MPIError;
import ru.sartfoms.personinfoservice.entity.MPIReq;
import ru.sartfoms.personinfoservice.repository.InsuranceStatusRepository;
import ru.sartfoms.personinfoservice.repository.InsuranceStatusRespRepository;
import ru.sartfoms.personinfoservice.repository.MPIErrorRepository;
import ru.sartfoms.personinfoservice.repository.MPIReqRepository;
import ru.sartfoms.schemas.generated.GetInsuranceStatusRequest;
import ru.sartfoms.schemas.generated.GetInsuranceStatusResponse;
import ru.sartfoms.schemas.generated.InsuranceStatusSearchParamsType;
import ru.sartfoms.schemas.generated.PcyData;
import ru.sartfoms.schemas.generated.PersonCommonSearchParamsType;
import ru.sartfoms.schemas.generated.PersonDocIdentSerNum;
import ru.sartfoms.schemas.generated.ResponseErrorData;
import ru.sartfoms.schemas.generated.SnilsDrData;
import ru.sartfoms.schemas.generated.StatusData;

public class GetInsuranceStatus extends PersonInfoService {
	private final WebServiceTemplate template;
	private final MPIReqRepository mpiReqRepository;
	private final MPIErrorRepository mpiErrorRepository;
	private final InsuranceStatusRepository insuranceStatusRepository;
	private final InsuranceStatusRespRepository insuranceStatusRespRepository;

	public GetInsuranceStatus(MPIReqRepository mpiReqRepository, WebServiceTemplate template,
			MPIErrorRepository mpiErrorRepository, InsuranceStatusRespRepository insuranceStatusRespRepository,
			InsuranceStatusRepository insuranceStatusRepository) {
		this.template = template;
		this.mpiReqRepository = mpiReqRepository;
		this.mpiErrorRepository = mpiErrorRepository;
		this.insuranceStatusRepository = insuranceStatusRepository;
		this.insuranceStatusRespRepository = insuranceStatusRespRepository;
	}

	@Override
	@Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
	protected void process() {
		Collection<InsuranceStatus> starts = insuranceStatusRepository.findByDtReqIsNull();
		starts.forEach(start -> {
			String extRid = UUID.randomUUID().toString();
			try {
				GetInsuranceStatusResponse response = template.sendAndReceive(new WebServiceMessageCallback() {

					@Override
					public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
						MarshallingUtils.marshal(template.getMarshaller(), getRequest(), message);

						ByteArrayOutputStream out = new ByteArrayOutputStream();
						message.writeTo(out);
						MPIReq mpiReq = new MPIReq();
						mpiReq.setRid(start.getRid());
						mpiReq.setDt(LocalDateTime.now());
						mpiReq.setReq(out.toByteArray());
						mpiReq.setExtrid(extRid);

						mpiReqRepository.save(mpiReq);
					}

					private GetInsuranceStatusRequest getRequest() {
						GetInsuranceStatusRequest request = new GetInsuranceStatusRequest();
						request.setExternalRequestId(extRid);
						InsuranceStatusSearchParamsType searchParams = new InsuranceStatusSearchParamsType();
						try {
							searchParams.setDt(
									DatatypeFactory.newInstance().newXMLGregorianCalendar(start.getDt().toString()));
						} catch (Exception e) {
						}
						PersonCommonSearchParamsType searchInfo = new PersonCommonSearchParamsType();
						if (start.getDudlNum() != null) {
							PersonDocIdentSerNum dudl = new PersonDocIdentSerNum();
							dudl.setDudlType(start.getDudlType() != null ? String.valueOf(start.getDudlType()) : null);
							dudl.setDudlSer(start.getDudlSer());
							dudl.setDudlNum(start.getDudlNum());
							try {
								dudl.setDudlDateB(DatatypeFactory.newInstance()
										.newXMLGregorianCalendar(start.getDudlEffDate().toString()));
							} catch (DatatypeConfigurationException e) {
							}
							searchInfo.setDudl(dudl);
						}
						searchInfo.setOip(start.getOip());
						PcyData pcyData = new PcyData();
						pcyData.setPcySer(start.getPcySer());
						pcyData.setPcyType(start.getPcyType());
						if (start.getPcyType() != null && POLICY_TYPE.valueOf(start.getPcyType()) == POLICY_TYPE.С) {
							pcyData.setPcyNum(start.getPcyNum());
						} else if (start.getPcyType() != null
								&& (POLICY_TYPE.valueOf(start.getPcyType()) == POLICY_TYPE.В
										|| POLICY_TYPE.valueOf(start.getPcyType()) == POLICY_TYPE.Е)) {
							pcyData.setTmpcertNum(start.getPcyNum());
						} else if (start.getPcyNum() != null) {
							pcyData.setEnp(start.getPcyNum());
						} else {
							pcyData = null;
						}
						searchInfo.setPcy(pcyData);
						if (start.getSnils() != null || start.getBirthDay() != null) {
							SnilsDrData snilsDrData = new SnilsDrData();
							try {
								snilsDrData.setBirthDay(DatatypeFactory.newInstance()
										.newXMLGregorianCalendar(start.getBirthDay().toString()));
							} catch (Exception e) {
							}
							snilsDrData.setSnils(start.getSnils());
							searchInfo.setSnilsDr(snilsDrData);
						}
						searchParams.setPersonSearchInfo(searchInfo);
						request.setInsuranceStatusSearchParams(searchParams);

						return request;
					}

				}, new WebServiceMessageExtractor<GetInsuranceStatusResponse>() {

					@Override
					public GetInsuranceStatusResponse extractData(WebServiceMessage message)
							throws IOException, TransformerException {
						ByteArrayOutputStream out = new ByteArrayOutputStream();
						message.writeTo(out);
						MPIReq mpiReq = mpiReqRepository.getByExtrid(extRid);
						mpiReq.setResp(out.toByteArray());

						mpiReqRepository.save(mpiReq);

						return (GetInsuranceStatusResponse) MarshallingUtils.unmarshal(template.getUnmarshaller(),
								message);
					}
				});

				save(start, response, extRid);

			} catch (SoapFaultClientException e) {
				start.setDtReq(LocalDateTime.now());
				start.setHasError(true);

				insuranceStatusRepository.save(start);

				MPIError errEntity = new MPIError();
				errEntity.setRid(start.getRid());
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

	private void save(InsuranceStatus start, GetInsuranceStatusResponse response, String extRid) {
		if (response.getErrors() != null && response.getErrors().getErrorItem().size() == 1 && response.getErrors()
				.getErrorItem().stream().findAny().get().getCode().trim().equals(INTERNAL_SERVICE_ERROR)) {
			// do nothing
		} else {
			start.setDtReq(LocalDateTime.now());
			start.setHasError(response.getErrors() != null ? true : false);

			insuranceStatusRepository.save(start);
		}
		if (response.getErrors() != null) {
			List<ResponseErrorData> errors = response.getErrors().getErrorItem();
			for (ResponseErrorData err : errors) {
				if (err.getCode().trim().equals(INTERNAL_SERVICE_ERROR))
					continue; // do nothing
				MPIError errEntity = new MPIError();
				errEntity.setRid(start.getRid());
				errEntity.setNr(errors.indexOf(err));
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
			InsuranceStatusResp res = new InsuranceStatusResp();
			res.setRid(start.getRid());
			StatusData data = response.getStatus();
			res.setOip(data.getOip());
			res.setFio(data.getFio());
			res.setBirthDay(data.getBirthDay().toGregorianCalendar().toZonedDateTime().toLocalDate());
			res.setGender(data.getGender());
			res.setPcyType(data.getPolicyType());
			res.setPcySer(data.getPolicySer());
			res.setPcyNum(data.getPolicyNumEnp());
			res.setPcyStatus(data.getPolicyStatus());
			try {
				res.setSmoCode(Integer.valueOf(data.getSmo()));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			res.setOkatoCode(data.getTerr());
			res.setPolicyValidFrom(data.getPolicyValidFrom().toGregorianCalendar().toZonedDateTime().toLocalDate());
			res.setPolicyValidTo(data.getPolicyValidTo().toGregorianCalendar().toZonedDateTime().toLocalDate());

			insuranceStatusRespRepository.save(res);
		}
	}

}
