package ru.sartfoms.personinfoservice.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "mpi_dudl", schema = "ASY23")
@IdClass(CompositeKey.class)
public class Dudl {
	@Id
	@Column(name = "rid")
	private Long rid;

	@Id
	@Column(name = "nr")
	private Integer nr;

	@Column(name = "dudlser")
	private String dudlSer;

	@Column(name = "dudlnum")
	private String dudlNum;

	@Column(name = "dudldateb")
	private LocalDate dudlDateB;

	@Column(name = "dudldatee")
	private LocalDate dudlDateE;

	@Column(name = "dudltype")
	private String dudlType;

	@Column(name = "issuer")
	private String issuer;

	@Column(name = "issueroksm")
	private String issuerOksm;

	@Column(name = "ctznoksm")
	private String ctznOksm;

	@Column(name = "nocitizenship")
	private Boolean noCitizenship;

	@JoinColumn(name = "dsource")
	private String dsource;

	@Column(name = "descr")
	private String descr;

	@Column(name = "fam")
	private String lastName;

	@Column(name = "ot")
	private String patronymic;

	@Column(name = "im")
	private String firstName;

	@Column(name = "dr")
	private LocalDate birthDay;

	@Column(name = "birthplace")
	private String birthPlace;

	@Column(name = "sex")
	private Integer gender;

	@Column(name = "dsourcetype")
	private String dsourceType;

	@Column(name = "birthoksm")
	private String birthOksm;

	@Column(name = "dudlstatus")
	private String dudlStatus;

	@Column(name = "dost")
	private String dost;

	public Dudl() {
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Integer getNr() {
		return nr;
	}

	public void setNr(Integer nr) {
		this.nr = nr;
	}

	public String getDudlSer() {
		return dudlSer;
	}

	public void setDudlSer(String dudlSer) {
		this.dudlSer = dudlSer;
	}

	public String getDudlNum() {
		return dudlNum;
	}

	public void setDudlNum(String dudlNum) {
		this.dudlNum = dudlNum;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public Boolean getNoCitizenship() {
		return noCitizenship;
	}

	public void setNoCitizenship(Boolean noCitizenship) {
		this.noCitizenship = noCitizenship;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LocalDate getDudlDateB() {
		return dudlDateB;
	}

	public LocalDate getDudlDateE() {
		return dudlDateE;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setDudlDateB(LocalDate dudlDateB) {
		this.dudlDateB = dudlDateB;
	}

	public void setDudlDateE(LocalDate dudlDateE) {
		this.dudlDateE = dudlDateE;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getDsourceType() {
		return dsourceType;
	}

	public void setDsourceType(String dsourceType) {
		this.dsourceType = dsourceType;
	}

	public String getDudlStatus() {
		return dudlStatus;
	}

	public void setDudlStatus(String dudlStatus) {
		this.dudlStatus = dudlStatus;
	}

	public String getDost() {
		return dost;
	}

	public void setDost(String dost) {
		this.dost = dost;
	}

	public String getDudlType() {
		return dudlType;
	}

	public String getIssuerOksm() {
		return issuerOksm;
	}

	public String getCtznOksm() {
		return ctznOksm;
	}

	public String getDsource() {
		return dsource;
	}

	public String getBirthOksm() {
		return birthOksm;
	}

	public void setDudlType(String dudlType) {
		this.dudlType = dudlType;
	}

	public void setIssuerOksm(String issuerOksm) {
		this.issuerOksm = issuerOksm;
	}

	public void setCtznOksm(String ctznOksm) {
		this.ctznOksm = ctznOksm;
	}

	public void setDsource(String dsource) {
		this.dsource = dsource;
	}

	public void setBirthOksm(String birthOksm) {
		this.birthOksm = birthOksm;
	}

}
