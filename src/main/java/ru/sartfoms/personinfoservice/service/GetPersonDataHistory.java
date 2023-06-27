package ru.sartfoms.personinfoservice.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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

import ru.sartfoms.personinfoservice.entity.Dudl;
import ru.sartfoms.personinfoservice.entity.Ern;
import ru.sartfoms.personinfoservice.entity.MPIError;
import ru.sartfoms.personinfoservice.entity.MPIReq;
import ru.sartfoms.personinfoservice.entity.PersonData;
import ru.sartfoms.personinfoservice.entity.Policy;
import ru.sartfoms.personinfoservice.entity.Snils;
import ru.sartfoms.personinfoservice.entity.SocialStatus;
import ru.sartfoms.personinfoservice.repository.AddressRepository;
import ru.sartfoms.personinfoservice.repository.AttachRepository;
import ru.sartfoms.personinfoservice.repository.ContactRepository;
import ru.sartfoms.personinfoservice.repository.DudlRepository;
import ru.sartfoms.personinfoservice.repository.ErnRepository;
import ru.sartfoms.personinfoservice.repository.MPIErrorRepository;
import ru.sartfoms.personinfoservice.repository.MPIReqRepository;
import ru.sartfoms.personinfoservice.repository.PersonDataRepository;
import ru.sartfoms.personinfoservice.repository.PersonRepository;
import ru.sartfoms.personinfoservice.repository.PolicyRepository;
import ru.sartfoms.personinfoservice.repository.SnilsRepository;
import ru.sartfoms.personinfoservice.repository.SocialStatusRepository;
import ru.sartfoms.schemas.generated.Address;
import ru.sartfoms.schemas.generated.Attach;
import ru.sartfoms.schemas.generated.Contact;
import ru.sartfoms.schemas.generated.ErnData;
import ru.sartfoms.schemas.generated.GetPersonDataHistoryRequest;
import ru.sartfoms.schemas.generated.GetPersonDataResponse;
import ru.sartfoms.schemas.generated.OmsPolicy;
import ru.sartfoms.schemas.generated.PcyData;
import ru.sartfoms.schemas.generated.Person;
import ru.sartfoms.schemas.generated.PersonCommonSearchParamsType;
import ru.sartfoms.schemas.generated.PersonDataHistorySearchParamsType;
import ru.sartfoms.schemas.generated.PersonDocIdent;
import ru.sartfoms.schemas.generated.PersonDocIdentSerNum;
import ru.sartfoms.schemas.generated.ResponseErrorData;
import ru.sartfoms.schemas.generated.SnilsData;
import ru.sartfoms.schemas.generated.SnilsDrData;
import ru.sartfoms.schemas.generated.SocialStatusData;

@Service
public class GetPersonDataHistory extends PersonInfoService {
	private final WebServiceTemplate template;
	private final MPIReqRepository mpiReqRepository;
	private final MPIErrorRepository mpiErrorRepository;
	private final PersonDataRepository personDataRepository;
	private final AddressRepository addressRepository;
	private final AttachRepository attachRepository;
	private final ContactRepository contactRepository;
	private final DudlRepository dudlRepository;
	private final ErnRepository ernRepository;
	private final PersonRepository personRepository;
	private final PolicyRepository policyRepository;
	private final SnilsRepository snilsRepository;
	private final SocialStatusRepository statusRepository;

	public GetPersonDataHistory(WebServiceTemplate template, MPIReqRepository mpiReqRepository,
			MPIErrorRepository mpiErrorRepository, PersonDataRepository personDataRepository,
			AddressRepository addressRepository, AttachRepository attachRepository, ContactRepository contactRepository,
			DudlRepository dudlRepository, ErnRepository ernRepository, PersonRepository personRepository,
			PolicyRepository policyRepository, SnilsRepository snilsRepository,
			SocialStatusRepository statusRepository) {
		this.template = template;
		this.mpiReqRepository = mpiReqRepository;
		this.mpiErrorRepository = mpiErrorRepository;
		this.personDataRepository = personDataRepository;
		this.addressRepository = addressRepository;
		this.attachRepository = attachRepository;
		this.contactRepository = contactRepository;
		this.dudlRepository = dudlRepository;
		this.ernRepository = ernRepository;
		this.personRepository = personRepository;
		this.policyRepository = policyRepository;
		this.snilsRepository = snilsRepository;
		this.statusRepository = statusRepository;
	}

	@Override
	@Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
	public void process() {
		Collection<PersonData> entities = personDataRepository.findByDtReqIsNullAndHistorical(true);
		entities.forEach(entity -> {
			String extRid = UUID.randomUUID().toString();
			try {
				GetPersonDataResponse response = template.sendAndReceive(new WebServiceMessageCallback() {

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

					private GetPersonDataHistoryRequest getRequest() {
						GetPersonDataHistoryRequest request = new GetPersonDataHistoryRequest();
						request.setExternalRequestId(extRid);
						PersonDataHistorySearchParamsType paramsType = new PersonDataHistorySearchParamsType();
						try {
							paramsType.setDtFrom(DatatypeFactory.newInstance()
									.newXMLGregorianCalendar(entity.getDtFrom().toString()));
						} catch (Exception e) {
						}
						try {
							paramsType.setDtTo(
									DatatypeFactory.newInstance().newXMLGregorianCalendar(entity.getDtTo().toString()));
						} catch (Exception e) {
						}
						if (entity.getShow() != null)
							paramsType.getShow().addAll(Arrays.asList(entity.getShow().split(" ")));
						paramsType.setSurname(entity.getLastName());
						paramsType.setFirstName(entity.getFirstName());
						paramsType.setPatronymic(entity.getPatronymic());
						PersonCommonSearchParamsType searchInfo = new PersonCommonSearchParamsType();
						if (entity.getDudlNum() != null) {
							PersonDocIdentSerNum dudl = new PersonDocIdentSerNum();
							dudl.setDudlType(
									entity.getDudlType() != null ? String.valueOf(entity.getDudlType()) : null);
							dudl.setDudlSer(entity.getDudlSer());
							dudl.setDudlNum(entity.getDudlNum());
							try {
								dudl.setDudlDateB(DatatypeFactory.newInstance()
										.newXMLGregorianCalendar(entity.getDudlEffDate().toString()));
							} catch (DatatypeConfigurationException e) {
							}
							searchInfo.setDudl(dudl);
						}
						searchInfo.setOip(entity.getOip());
						PcyData pcyData = new PcyData();
						pcyData.setPcySer(entity.getPcySer());
						pcyData.setPcyType(entity.getPcyType());
						if (entity.getPcyType() != null && POLICY_TYPE.valueOf(entity.getPcyType()) == POLICY_TYPE.С) {
							pcyData.setPcyNum(entity.getPcyNum());
						} else if (entity.getPcyType() != null
								&& (POLICY_TYPE.valueOf(entity.getPcyType()) == POLICY_TYPE.В
										|| POLICY_TYPE.valueOf(entity.getPcyType()) == POLICY_TYPE.Е)) {
							pcyData.setTmpcertNum(entity.getPcyNum());
						} else if (entity.getPcyNum() != null) {
							pcyData.setEnp(entity.getPcyNum());
						} else {
							pcyData = null;
						}
						searchInfo.setPcy(pcyData);
						if (entity.getSnils() != null || entity.getBirthDay() != null) {
							SnilsDrData snilsDrData = new SnilsDrData();
							try {
								snilsDrData.setBirthDay(DatatypeFactory.newInstance()
										.newXMLGregorianCalendar(entity.getBirthDay().toString()));
							} catch (Exception e) {
							}
							snilsDrData.setSnils(entity.getSnils());
							searchInfo.setSnilsDr(snilsDrData);
						}
						paramsType.setPersonSearchInfo(searchInfo);

						request.setPersonDataHistorySearchParams(paramsType);

						return request;
					}

				}, new WebServiceMessageExtractor<GetPersonDataResponse>() {

					@Override
					public GetPersonDataResponse extractData(WebServiceMessage message)
							throws IOException, TransformerException {
						ByteArrayOutputStream out = new ByteArrayOutputStream();
						message.writeTo(out);
						MPIReq mpiReq = mpiReqRepository.getByExtrid(extRid);
						mpiReq.setResp(out.toByteArray());

						mpiReqRepository.save(mpiReq);

						return (GetPersonDataResponse) MarshallingUtils.unmarshal(template.getUnmarshaller(), message);
					}
				});

				save(entity, response, extRid);

			} catch (SoapFaultClientException e) {
				entity.setDtReq(LocalDateTime.now());
				entity.setHasError(true);

				personDataRepository.save(entity);

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

	private void save(PersonData entity, GetPersonDataResponse response, String extRid) {
		if (response.getErrors() != null && response.getErrors().getErrorItem().size() == 1 && response.getErrors()
				.getErrorItem().stream().findAny().get().getCode().trim().equals(INTERNAL_SERVICE_ERROR)) {
			// do nothing
		} else {
			entity.setDtReq(LocalDateTime.now());
			entity.setHasError(response.getErrors() != null ? true : false);

			personDataRepository.save(entity);
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
			entity.setOipRes(response.getPd().getOip());

			personDataRepository.save(entity);

			Collection<Address> addresses = response.getPd().getAddress() != null
					? response.getPd().getAddress().getAddressItems()
					: new ArrayList<>();
			Collection<Attach> attachs = response.getPd().getAttach() != null
					? response.getPd().getAttach().getAttachItems()
					: new ArrayList<>();
			Collection<Contact> contacts = response.getPd().getContact() != null
					? response.getPd().getContact().getContactItems()
					: new ArrayList<>();
			Collection<PersonDocIdent> dudls = response.getPd().getDudl() != null
					? response.getPd().getDudl().getDudlItems()
					: new ArrayList<>();
			Collection<ErnData> ernDatas = response.getPd().getErn() != null ? response.getPd().getErn().getErnItems()
					: new ArrayList<>();
			Collection<Person> persons = response.getPd().getPerson() != null
					? response.getPd().getPerson().getPersonItems()
					: new ArrayList<>();
			Collection<OmsPolicy> policies = response.getPd().getPolicy() != null
					? response.getPd().getPolicy().getPolicyItems()
					: new ArrayList<>();
			Collection<SnilsData> snilsDatas = response.getPd().getSnils() != null
					? response.getPd().getSnils().getSnilsItems()
					: new ArrayList<>();
			Collection<SocialStatusData> socialStatusDatas = response.getPd().getSocialStatus() != null
					? response.getPd().getSocialStatus().getSocialStatusItems()
					: new ArrayList<>();

			int nr = 0;
			for (Address address : addresses) {
				ru.sartfoms.personinfoservice.entity.Address addressEntity = new ru.sartfoms.personinfoservice.entity.Address();
				if (address.getAddressDateB() != null)
					addressEntity.setAddressDateB(
							address.getAddressDateB().toGregorianCalendar().toZonedDateTime().toLocalDate());
				if (address.getAddressDateE() != null)
					addressEntity.setAddressDateE(
							address.getAddressDateE().toGregorianCalendar().toZonedDateTime().toLocalDate());
				addressEntity.setAddressText(address.getAddressText());
				addressEntity.setAddressType(address.getAddressType());
				addressEntity.setAoguid(address.getAoguid());
				addressEntity.setAppNum(address.getAppNum());
				addressEntity.setDsource(address.getDsource());
				addressEntity.setDsourceType(address.getDsourceType());
				addressEntity.setHsguid(address.getHsguid());
				addressEntity.setMailIndex(address.getMailIndex());
				addressEntity.setNr(++nr);
				addressEntity.setOkato(address.getOkato());
				addressEntity.setOksm(address.getOksm());
				addressEntity.setRid(entity.getRid());
				addressEntity.setStatus(address.getAddressStatus());

				addressRepository.save(addressEntity);
			}

			nr = 0;
			for (Attach attach : attachs) {
				ru.sartfoms.personinfoservice.entity.Attach attachEntity = new ru.sartfoms.personinfoservice.entity.Attach();
				attachEntity.setAreaId(attach.getAreaId());
				attachEntity.setAreaType(attach.getAreaType() != null ? Integer.valueOf(attach.getAreaType()) : null);
				attachEntity.setAttachMethod(
						attach.getAttachMethod() != null ? Integer.valueOf(attach.getAttachMethod()) : null);
				attachEntity.setAttachStatus(attach.getAttachStatus());
				if (attach.getDateAttachB() != null)
					attachEntity.setDateAttachB(
							attach.getDateAttachB().toGregorianCalendar().toZonedDateTime().toLocalDate());
				if (attach.getDateAttachE() != null)
					attachEntity.setDateAttachE(
							attach.getDateAttachE().toGregorianCalendar().toZonedDateTime().toLocalDate());
				attachEntity.setDescr(attach.getDescr());
				attachEntity.setDoctorId(attach.getDoctorId());
				if (attach.getDoctorSince() != null)
					attachEntity.setDoctorSince(
							attach.getDoctorSince().toGregorianCalendar().toZonedDateTime().toLocalDate());
				attachEntity.setDsource(attach.getDsource());
				attachEntity.setDsourceType(attach.getDsourceType());
				attachEntity.setMocode(attach.getMoCode());
				attachEntity.setMoFId(attach.getMoFId());
				attachEntity.setMoId(attach.getMoId());
				attachEntity.setMoOkato(attach.getMoOkato());
				attachEntity.setNr(++nr);
				attachEntity.setRid(entity.getRid());
				attachEntity.setSnilsDoctor(attach.getSnilsDoctor());

				attachRepository.save(attachEntity);
			}

			nr = 0;
			for (Contact contact : contacts) {
				ru.sartfoms.personinfoservice.entity.Contact contactEntity = new ru.sartfoms.personinfoservice.entity.Contact();
				contactEntity.setContactText(contact.getContactText());
				contactEntity.setContactType(contact.getContactType());
				contactEntity.setDescr(contact.getDescr());
				contactEntity.setDsource(contact.getDsource());
				contactEntity.setDsourceType(contact.getDsourceType());
				contactEntity.setNr(++nr);
				contactEntity.setRid(entity.getRid());
				contactEntity.setStatus(contact.getContactStatus());

				contactRepository.save(contactEntity);
			}

			nr = 0;
			for (PersonDocIdent dudl : dudls) {
				Dudl dudlEntity = new Dudl();
				if (dudl.getBirthDay() != null)
					dudlEntity.setBirthDay(dudl.getBirthDay().toGregorianCalendar().toZonedDateTime().toLocalDate());
				dudlEntity.setBirthOksm(dudl.getBirthOksm());
				dudlEntity.setBirthPlace(dudl.getBirthplace());
				dudlEntity.setCtznOksm(dudl.getCtznOksm());
				dudlEntity.setDescr(dudl.getDescr());
				dudlEntity.setDost(dudl.getDost());
				dudlEntity.setDsource(dudl.getDsource());
				dudlEntity.setDsourceType(dudl.getDsourceType());
				if (dudl.getDudlDateB() != null)
					dudlEntity.setDudlDateB(dudl.getDudlDateB().toGregorianCalendar().toZonedDateTime().toLocalDate());
				if (dudl.getDudlDateE() != null)
					dudlEntity.setDudlDateE(dudl.getDudlDateE().toGregorianCalendar().toZonedDateTime().toLocalDate());
				dudlEntity.setDudlNum(dudl.getDudlNum());
				dudlEntity.setDudlSer(dudl.getDudlSer());
				dudlEntity.setDudlStatus(dudl.getDudlStatus());
				dudlEntity.setDudlType(dudl.getDudlType());
				dudlEntity.setFirstName(dudl.getFirstName());
				dudlEntity.setGender(dudl.getGender());
				dudlEntity.setIssuer(dudl.getIssuer());
				dudlEntity.setIssuerOksm(dudl.getIssuerOksm());
				dudlEntity.setLastName(dudl.getSurname());
				dudlEntity.setNoCitizenship(dudl.isNoCitizenship());
				dudlEntity.setNr(++nr);
				dudlEntity.setPatronymic(dudl.getPatronymic());
				dudlEntity.setRid(entity.getRid());

				dudlRepository.save(dudlEntity);
			}

			nr = 0;
			for (ErnData ernData : ernDatas) {
				Ern ernEntity = new Ern();
				ernEntity.setDsource(ernData.getDsource());
				ernEntity.setDsourceType(ernData.getDsourceType());
				ernEntity.setErn(ernData.getErn());
				ernEntity.setErnstatus(ernData.getErnStatus());
				ernEntity.setNr(++nr);
				ernEntity.setRid(entity.getRid());

				ernRepository.save(ernEntity);
			}

			nr = 0;
			for (Person person : persons) {
				ru.sartfoms.personinfoservice.entity.Person personEntity = new ru.sartfoms.personinfoservice.entity.Person();
				if (person.getBirthDay() != null)
					personEntity
							.setBirthDay(person.getBirthDay().toGregorianCalendar().toZonedDateTime().toLocalDate());
				personEntity.setBirthOksm(person.getBirthOksm());
				if (person.getDateEdit() != null)
					personEntity.setDateEdit(
							person.getDateEdit().toGregorianCalendar().toZonedDateTime().toLocalDateTime());
				if (person.getDeathDate() != null)
					personEntity
							.setDeathDate(person.getDeathDate().toGregorianCalendar().toZonedDateTime().toLocalDate());
				personEntity.setFirstName(person.getFirstName());
				personEntity.setGender(person.getGender());
				personEntity.setLastName(person.getSurname());
				personEntity.setNr(++nr);
				personEntity.setPatronymic(person.getPatronymic());
				personEntity.setRid(entity.getRid());
				personEntity.setStatus(person.getStatus());
				if (person.getWhenMerged() != null)
					personEntity.setWhenMerged(
							person.getWhenMerged().toGregorianCalendar().toZonedDateTime().toLocalDateTime());

				personRepository.save(personEntity);
			}

			nr = 0;
			for (OmsPolicy policy : policies) {
				Policy policyEntity = new Policy();
				if (policy.getBirthDay() != null)
					policyEntity
							.setBirthDay(policy.getBirthDay().toGregorianCalendar().toZonedDateTime().toLocalDate());
				policyEntity.setBlankNum(policy.getBlankNum());
				policyEntity.setDescr(policy.getDescr());
				policyEntity.setDsource(policy.getDsource());
				policyEntity.setDsourceType(policy.getDsourceType());
				policyEntity.setEnp(policy.getEnp());
				policyEntity.setEnpCalc(policy.getEnpCalc());
				policyEntity.setFirstName(policy.getFirstName());
				policyEntity.setGender(policy.getGender());
				policyEntity.setInsurCode(policy.getInsurCode());
				policyEntity.setInsurfCode(policy.getInsurfCode());
				if (policy.getInsurfDate() != null)
					policyEntity.setInsurfDate(
							policy.getInsurfDate().toGregorianCalendar().toZonedDateTime().toLocalDate());
				policyEntity.setInsurfName(policy.getInsurfName());
				policyEntity.setInsurfOgrn(policy.getInsurfOgrn());
				policyEntity.setInsurName(policy.getInsurName());
				policyEntity.setInsurOgrn(policy.getOkato());
				policyEntity.setLastName(policy.getSurname());
				policyEntity.setNr(++nr);
				policyEntity.setOkato(policy.getOkato());
				policyEntity.setPatronymic(policy.getPatronymic());
				policyEntity.setPcyCategory(policy.getPcyCategory());
				if (policy.getPcyDateB() != null)
					policyEntity
							.setPcyDateB(policy.getPcyDateB().toGregorianCalendar().toZonedDateTime().toLocalDate());
				if (policy.getPcyDateE() != null)
					policyEntity
							.setPcyDateE(policy.getPcyDateE().toGregorianCalendar().toZonedDateTime().toLocalDate());
				if (policy.getPcyDateEnpCalc() != null)
					policyEntity.setPcyDateEnpCalc(
							policy.getPcyDateEnpCalc().toGregorianCalendar().toZonedDateTime().toLocalDate());
				if (policy.getPcyDateH() != null)
					policyEntity
							.setPcyDateH(policy.getPcyDateH().toGregorianCalendar().toZonedDateTime().toLocalDate());
				if (policy.getPcyDatePr() != null)
					policyEntity
							.setPcyDatePr(policy.getPcyDatePr().toGregorianCalendar().toZonedDateTime().toLocalDate());
				if (policy.getPcyDateT() != null)
					policyEntity
							.setPcyDateT(policy.getPcyDateT().toGregorianCalendar().toZonedDateTime().toLocalDate());
				policyEntity.setPcyNum(policy.getPcyNum());
				policyEntity.setPcySer(policy.getPcySer());
				policyEntity.setPcyStatus(policy.getPcyStatus());
				policyEntity.setPcyType(policy.getPcyType());
				policyEntity.setRid(entity.getRid());
				if (policy.getTmpcertDateB() != null)
					policyEntity.setTmpcertDateB(
							policy.getTmpcertDateB().toGregorianCalendar().toZonedDateTime().toLocalDate());
				if (policy.getTmpcertDateE() != null)
					policyEntity.setTmpcertDateE(
							policy.getTmpcertDateE().toGregorianCalendar().toZonedDateTime().toLocalDate());
				policyEntity.setTmpcertNum(policy.getTmpcertNum());
				policyEntity.setUekNum(policy.getUekNum());

				policyRepository.save(policyEntity);
			}

			nr = 0;
			for (SnilsData snilsData : snilsDatas) {
				Snils snilsEntity = new Snils();
				snilsEntity.setDescr(snilsData.getDescr());
				snilsEntity.setDsource(snilsData.getDsource());
				snilsEntity.setDsourceType(snilsData.getDsourceType());
				snilsEntity.setNr(++nr);
				snilsEntity.setRid(entity.getRid());
				snilsEntity.setSnils(snilsData.getSnils());
				snilsEntity.setStatus(snilsData.getStatusSnils());

				snilsRepository.save(snilsEntity);
			}

			nr = 0;
			for (SocialStatusData socialStatusData : socialStatusDatas) {
				SocialStatus statusEntity = new SocialStatus();
				statusEntity.setDescr(socialStatusData.getDescr());
				statusEntity.setDsource(socialStatusData.getDsource());
				statusEntity.setDsourceType(socialStatusData.getDsourceType());
				statusEntity.setNr(++nr);
				if (socialStatusData.getRegDate() != null)
					statusEntity.setRegDate(
							socialStatusData.getRegDate().toGregorianCalendar().toZonedDateTime().toLocalDate());
				statusEntity.setRid(entity.getRid());
				if (socialStatusData.getSocialStatus() != null)
					statusEntity.setSocialStatus(Integer.valueOf(socialStatusData.getSocialStatus().trim()));

				statusRepository.save(statusEntity);
			}
		}
	}
}
