package ru.sartfoms.personinfoservice.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mpi_person_data", schema = "ASY23")
public class PersonData {
	@Id
	@Column(name = "rid")
	private Long rid;

	@Column(name = "hist")
	private Boolean historical;

	@Column(name = "oip")
	private String oip;

	@Column(name = "polis_type")
	private String pcyType;

	@Column(name = "pcyser")
	private String pcySer;

	@Column(name = "polis")
	private String pcyNum;

	@Column(name = "dudlser")
	private String dudlSer;

	@Column(name = "dudlnum")
	private String dudlNum;

	@Column(name = "dudltype")
	private Integer dudlType;
	
	@Column(name = "dudldateb")
	private LocalDate dudlEffDate;

	@Column(name = "snils")
	private String snils;

	@Column(name = "dr")
	private LocalDate birthDay;

	@Column(name = "fam")
	private String lastName;

	@Column(name = "im")
	private String firstName;

	@Column(name = "ot")
	private String patronymic;

	@Column(name = "dt")
	private LocalDate dt;

	@Column(name = "dtfrom")
	private LocalDate dtFrom;

	@Column(name = "dtto")
	private LocalDate dtTo;

	@Column(name = "showx")
	private String show;

	@Column(name = "usr")
	private String user;

	@Column(name = "dt_ins")
	private LocalDateTime dtIns;

	@Column(name = "err")
	private Boolean hasError;

	@Column(name = "oip_resp")
	private String oipRes;

	@Column(name = "dt_req")
	private LocalDateTime dtReq;

	public PersonData() {
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Boolean getHistorical() {
		return historical;
	}

	public void setHistorical(Boolean historical) {
		this.historical = historical;
	}

	public String getOip() {
		return oip;
	}

	public void setOip(String oip) {
		this.oip = oip;
	}

	public String getPcyType() {
		return pcyType;
	}

	public void setPcyType(String pcyType) {
		this.pcyType = pcyType;
	}

	public String getPcySer() {
		return pcySer;
	}

	public void setPcySer(String pcySer) {
		this.pcySer = pcySer;
	}

	public String getPcyNum() {
		return pcyNum;
	}

	public void setPcyNum(String pcy) {
		this.pcyNum = pcy;
	}

	public String getDudlSer() {
		return dudlSer;
	}

	public void setDudlSer(String dudlSer) {
		if (dudlSer.matches("^\\d{4}$")) {
			dudlSer = dudlSer.substring(0, 2) + " " + dudlSer.substring(2);
		}
		this.dudlSer = dudlSer;
	}

	public String getDudlNum() {
		return dudlNum;
	}

	public void setDudlNum(String dudlNum) {
		this.dudlNum = dudlNum;
	}

	public Integer getDudlType() {
		return dudlType;
	}

	public void setDudlType(Integer dudlType) {
		this.dudlType = dudlType;
	}

	public String getSnils() {
		return snils;
	}

	public void setSnils(String snils) {
		this.snils = snils;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Boolean getHasError() {
		return hasError;
	}

	public void setHasError(Boolean hasError) {
		this.hasError = hasError;
	}

	public String getOipRes() {
		return oipRes;
	}

	public void setOipRes(String oipRes) {
		this.oipRes = oipRes;
	}

	public LocalDateTime getDtReq() {
		return dtReq;
	}

	public void setDtReq(LocalDateTime dtReq) {
		this.dtReq = dtReq;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public LocalDate getDt() {
		return dt;
	}

	public LocalDate getDtFrom() {
		return dtFrom;
	}

	public LocalDate getDtTo() {
		return dtTo;
	}

	public LocalDateTime getDtIns() {
		return dtIns;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public void setDt(LocalDate dt) {
		this.dt = dt;
	}

	public void setDtFrom(LocalDate dtFrom) {
		this.dtFrom = dtFrom;
	}

	public void setDtTo(LocalDate dtTo) {
		this.dtTo = dtTo;
	}

	public void setDtIns(LocalDateTime dtIns) {
		this.dtIns = dtIns;
	}

	public LocalDate getDudlEffDate() {
		return dudlEffDate;
	}

	public void setDudlEffDate(LocalDate dudlEffDate) {
		this.dudlEffDate = dudlEffDate;
	}

}
