package ru.sartfoms.personinfoservice.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
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
import ru.sartfoms.personinfoservice.entity.PersonsByPersCriteria;
import ru.sartfoms.personinfoservice.entity.PersonsByPersCriteriaResp;
import ru.sartfoms.personinfoservice.repository.MPIErrorRepository;
import ru.sartfoms.personinfoservice.repository.MPIReqRepository;
import ru.sartfoms.personinfoservice.repository.PersonsByPersCriteriaRepository;
import ru.sartfoms.personinfoservice.repository.PersonsByPersCriteriaRespRepository;
import ru.sartfoms.schemas.generated.FindPersonsByPersCriteriaRequest;
import ru.sartfoms.schemas.generated.FindPersonsByPersCriteriaResponse;
import ru.sartfoms.schemas.generated.FioData;
import ru.sartfoms.schemas.generated.PaginationRequestType;
import ru.sartfoms.schemas.generated.PcyData;
import ru.sartfoms.schemas.generated.PersCriteriaType;
import ru.sartfoms.schemas.generated.PersonCommonSearchParamsType;
import ru.sartfoms.schemas.generated.PersonDataShort;
import ru.sartfoms.schemas.generated.PersonDocIdentSerNum;
import ru.sartfoms.schemas.generated.ResponseErrorData;
import ru.sartfoms.schemas.generated.SnilsDrData;

@Service
public class FindPersonsByPersCriteria extends PersonInfoService {
	private final WebServiceTemplate template;
	private final MPIReqRepository mpiReqRepository;
	private final MPIErrorRepository mpiErrorRepository;
	private final PersonsByPersCriteriaRepository persCriteriaRepository;
	private final PersonsByPersCriteriaRespRepository persCriteriaRespRepository;

	public FindPersonsByPersCriteria(MPIErrorRepository mpiErrorRepository, WebServiceTemplate template,
			MPIReqRepository mpiReqRepository, PersonsByPersCriteriaRepository persCriteriaRepository,
			PersonsByPersCriteriaRespRepository persCriteriaRespRepository) {
		this.template = template;
		this.mpiReqRepository = mpiReqRepository;
		this.mpiErrorRepository = mpiErrorRepository;
		this.persCriteriaRepository = persCriteriaRepository;
		this.persCriteriaRespRepository = persCriteriaRespRepository;
	}

	@Override
	@Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
	public void process() {
		Collection<PersonsByPersCriteria> entities = persCriteriaRepository.findByDtReqIsNull();
		entities.forEach(entity -> {
			String extRid = UUID.randomUUID().toString();
			try {
				FindPersonsByPersCriteriaResponse response = template.sendAndReceive(new WebServiceMessageCallback() {

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

					private FindPersonsByPersCriteriaRequest getRequest() {
						FindPersonsByPersCriteriaRequest request = new FindPersonsByPersCriteriaRequest();
						request.setExternalRequestId(extRid);
						PersCriteriaType persCriteriaType = new PersCriteriaType();
						persCriteriaType.setTerrOkato(entity.getTerrOkato());
						FioData fioData = new FioData();
						fioData.setDost(entity.getDost());
						fioData.setFirstName(entity.getFirstName());
						fioData.setNoCitizenship(entity.getNoCitizenship());
						fioData.setOksm(entity.getOksm());
						fioData.setOldsfp(entity.getOldsfp() ? BigInteger.ONE : BigInteger.ZERO);
						fioData.setPatronymic(entity.getPatronymic());
						fioData.setSurname(entity.getLastName());
						persCriteriaType.setFio(fioData);
						try {
							persCriteriaType.setBirthDayFrom(DatatypeFactory.newInstance()
									.newXMLGregorianCalendar(entity.getBirthDayFrom().toString()));
						} catch (Exception e) {
						}
						try {
							persCriteriaType.setBirthDayTo(DatatypeFactory.newInstance()
									.newXMLGregorianCalendar(entity.getBirthDayTo().toString()));
						} catch (Exception e) {
						}
						try {
							persCriteriaType.setDeathDateFrom(DatatypeFactory.newInstance()
									.newXMLGregorianCalendar(entity.getDeathDateFrom().toString()));
						} catch (Exception e) {
						}
						try {
							persCriteriaType.setDeathDateTo(DatatypeFactory.newInstance()
									.newXMLGregorianCalendar(entity.getDeathDateTo().toString()));
						} catch (Exception e) {
						}
						try {
							persCriteriaType.setDt(DatatypeFactory.newInstance()
									.newXMLGregorianCalendar(entity.getDeathDateTo().toString()));
						} catch (Exception e) {
						}
						persCriteriaType.setErn(entity.getErn());
						PersonCommonSearchParamsType commonSearchParamsType = new PersonCommonSearchParamsType();
						PersonDocIdentSerNum docIdentSerNum = new PersonDocIdentSerNum();
						docIdentSerNum.setDudlNum(entity.getDudlNum());
						docIdentSerNum.setDudlSer(entity.getDudlSer());
						docIdentSerNum.setDudlType(String.valueOf(entity.getDudlType()));
						commonSearchParamsType.setDudl(docIdentSerNum);
						commonSearchParamsType.setOip(entity.getOip());
						PcyData pcyData = new PcyData();
						pcyData.setPcySer(entity.getPcySer());
						pcyData.setPcyType(entity.getPcyType());
						if (entity.getPcyType() != null && POLICY_TYPE.valueOf(entity.getPcyType()) == POLICY_TYPE.С) {
							pcyData.setPcyNum(entity.getPcyNum());
						} else if (entity.getPcyType() != null && (POLICY_TYPE.valueOf(entity.getPcyType()) == POLICY_TYPE.В
								|| POLICY_TYPE.valueOf(entity.getPcyType()) == POLICY_TYPE.Е)) {
							pcyData.setTmpcertNum(entity.getPcyNum());
						} else if (entity.getPcyNum() != null) {
							pcyData.setEnp(entity.getPcyNum());
						} else {
							pcyData = null;
						}
						commonSearchParamsType.setPcy(pcyData);
						SnilsDrData snilsDrData = new SnilsDrData();
						try {
							snilsDrData.setBirthDay(DatatypeFactory.newInstance()
									.newXMLGregorianCalendar(entity.getBirthDay().toString()));
						} catch (DatatypeConfigurationException e) {
							e.printStackTrace();
						}
						snilsDrData.setSnils(entity.getSnils());
						commonSearchParamsType.setSnilsDr(snilsDrData);
						persCriteriaType.setPersonSearchInfo(commonSearchParamsType);
						PaginationRequestType paginationRequestType = new PaginationRequestType();
						paginationRequestType.setItemPerPage(entity.getItemPerPage());
						paginationRequestType.setPageNumber(entity.getPageNumber());
						persCriteriaType.setPagination(paginationRequestType);
						request.setPersCriteria(persCriteriaType);

						return request;
					}

				}, new WebServiceMessageExtractor<FindPersonsByPersCriteriaResponse>() {

					@Override
					public FindPersonsByPersCriteriaResponse extractData(WebServiceMessage message)
							throws IOException, TransformerException {
						ByteArrayOutputStream out = new ByteArrayOutputStream();
						message.writeTo(out);
						MPIReq mpiReq = mpiReqRepository.getByExtrid(extRid);
						mpiReq.setResp(out.toByteArray());

						mpiReqRepository.save(mpiReq);

						return (FindPersonsByPersCriteriaResponse) MarshallingUtils
								.unmarshal(template.getUnmarshaller(), message);
					}

				});

				save(entity, response, extRid);

			} catch (SoapFaultClientException e) {
				entity.setDtReq(LocalDateTime.now());
				entity.setHasError(true);

				persCriteriaRepository.save(entity);

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

	private void save(PersonsByPersCriteria entity, FindPersonsByPersCriteriaResponse response, String extRid) {
		if (response.getErrors() != null && response.getErrors().getErrorItem().size() == 1 && response.getErrors()
				.getErrorItem().stream().findAny().get().getCode().trim().equals(INTERNAL_SERVICE_ERROR)) {
			// do nothing
		} else {
			entity.setDtReq(LocalDateTime.now());
			entity.setHasError(response.getErrors() != null ? true : false);

			persCriteriaRepository.save(entity);
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
			entity.setRespPageNumber(response.getPersons().getPagination().getPageNumber());
			entity.setRespItemPerPage(response.getPersons().getPagination().getItemPerPage());
			entity.setPersFoundCnt(response.getPersons().getPersonDataShortItem().size());

			persCriteriaRepository.save(entity);

			Collection<PersonDataShort> personDataShorts = response.getPersons().getPersonDataShortItem();
			int nr = 0;
			for (PersonDataShort personDataShort : personDataShorts) {
				PersonsByPersCriteriaResp result = new PersonsByPersCriteriaResp();
				result.setRid(entity.getRid());
				result.setNr(++nr);
				result.setFio(personDataShort.getFio());
				result.setEnp(personDataShort.getEnp());
				result.setBirthDay(personDataShort.getBirthDay().toGregorianCalendar().toZonedDateTime().toLocalDate());
				result.setGender(personDataShort.getGender());
				result.setOip(personDataShort.getOip());
				
				persCriteriaRespRepository.save(result);
			}
		}
	}
}
