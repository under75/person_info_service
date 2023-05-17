package ru.sartfoms.personinfoservice.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "mpi_attach", schema = "OMCOWNER")
@IdClass(CompositeKey.class)
public class Attach {
	@Id
	@Column(name = "rid")
	private Long rid;

	@Id
	@Column(name = "nr")
	private Integer nr;

	@Column(name = "areatype")
	private Integer areaType;

	@Column(name = "areaid")
	private String areaId;

	@Column(name = "attachmethod")
	private Integer attachMethod;

	@Column(name = "mcapitation")
	private Integer mCapitation;

	@Column(name = "dateattachb")
	private LocalDate dateAttachB;

	@Column(name = "dateattache")
	private LocalDate dateAttachE;

	@Column(name = "moid")
	private String moId;

	@Column(name = "mocode")
	private String mocode;

	@Column(name = "mofid")
	private String moFId;

	@Column(name = "snilsdoctor")
	private String snilsDoctor;

	@Column(name = "doctorid")
	private String doctorId;

	@Column(name = "doctorsince")
	private LocalDate doctorSince;

	@Column(name = "descr")
	private String descr;

	@Column(name = "mookato")
	private String moOkato;

	@Column(name = "attachstatus")
	private String attachStatus;

	@Column(name = "dsource")
	private String dsource;

	@Column(name = "dsourcetype")
	private String dsourceType;

	public Attach() {
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

	public Integer getAreaType() {
		return areaType;
	}

	public void setAreaType(Integer areaType) {
		this.areaType = areaType;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public Integer getAttachMethod() {
		return attachMethod;
	}

	public void setAttachMethod(Integer attachMethod) {
		this.attachMethod = attachMethod;
	}

	public Integer getmCapitation() {
		return mCapitation;
	}

	public void setmCapitation(Integer mCapitation) {
		this.mCapitation = mCapitation;
	}

	public String getMoId() {
		return moId;
	}

	public void setMoId(String moId) {
		this.moId = moId;
	}

	public String getMocode() {
		return mocode;
	}

	public void setMocode(String mocode) {
		this.mocode = mocode;
	}

	public String getMoFId() {
		return moFId;
	}

	public void setMoFId(String moFId) {
		this.moFId = moFId;
	}

	public String getSnilsDoctor() {
		return snilsDoctor;
	}

	public void setSnilsDoctor(String snilsDoctor) {
		this.snilsDoctor = snilsDoctor;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public LocalDate getDoctorSince() {
		return doctorSince;
	}

	public void setDoctorSince(LocalDate doctorSince) {
		this.doctorSince = doctorSince;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getMoOkato() {
		return moOkato;
	}

	public void setMoOkato(String moOkato) {
		this.moOkato = moOkato;
	}

	public String getAttachStatus() {
		return attachStatus;
	}

	public void setAttachStatus(String attachStatus) {
		this.attachStatus = attachStatus;
	}

	public String getDsourceType() {
		return dsourceType;
	}

	public void setDsourceType(String dsourceType) {
		this.dsourceType = dsourceType;
	}

	public LocalDate getDateAttachB() {
		return dateAttachB;
	}

	public LocalDate getDateAttachE() {
		return dateAttachE;
	}

	public String getDsource() {
		return dsource;
	}

	public void setDateAttachB(LocalDate dateAttachB) {
		this.dateAttachB = dateAttachB;
	}

	public void setDateAttachE(LocalDate dateAttachE) {
		this.dateAttachE = dateAttachE;
	}

	public void setDsource(String dsource) {
		this.dsource = dsource;
	}

}
