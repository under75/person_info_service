package ru.sartfoms.personinfoservice.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "mpi_address", schema = "ASY23")
@IdClass(CompositeKey.class)
public class Address {
	@Id
	@Column(name = "rid")
	private Long rid;

	@Id
	@Column(name = "nr")
	private Integer nr;

	@Column(name = "okato")
	private String okato;

	@Column(name = "oksm")
	private String oksm;

	@JoinColumn(name = "aoguid")
	private String aoguid;

	@Column(name = "hsguid")
	private String hsguid;

	@Column(name = "addresstext")
	private String addressText;

	@Column(name = "mailindex")
	private String mailIndex;

	@Column(name = "appnum")
	private String appNum;

	@Column(name = "dsourcetype")
	private String dsourceType;

	@Column(name = "dsource")
	private String dsource;

	@Column(name = "addresstype")
	private String addressType;

	@Column(name = "addressdateb")
	private LocalDate addressDateB;

	@Column(name = "addressdatee")
	private LocalDate addressDateE;
	
	@Column(name = "addressstatus")
	private String status;

	public Address() {
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

	public String getOkato() {
		return okato;
	}

	public String getOksm() {
		return oksm;
	}

	public void setOkato(String okato) {
		this.okato = okato;
	}

	public void setOksm(String oksm) {
		this.oksm = oksm;
	}

	public String getAoguid() {
		return aoguid;
	}

	public void setAoguid(String aoguid) {
		this.aoguid = aoguid;
	}

	public String getHsguid() {
		return hsguid;
	}

	public void setHsguid(String hsguid) {
		this.hsguid = hsguid;
	}

	public String getAddressText() {
		return addressText;
	}

	public void setAddressText(String addressText) {
		this.addressText = addressText;
	}

	public String getMailIndex() {
		return mailIndex;
	}

	public void setMailIndex(String mailIndex) {
		this.mailIndex = mailIndex;
	}

	public String getAppNum() {
		return appNum;
	}

	public void setAppNum(String appNum) {
		this.appNum = appNum;
	}

	public String getDsourceType() {
		return dsourceType;
	}

	public void setDsourceType(String dsourceType) {
		this.dsourceType = dsourceType;
	}

	public String getDsource() {
		return dsource;
	}

	public void setDsource(String dsource) {
		this.dsource = dsource;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public LocalDate getAddressDateB() {
		return addressDateB;
	}

	public LocalDate getAddressDateE() {
		return addressDateE;
	}

	public void setAddressDateB(LocalDate addressDateB) {
		this.addressDateB = addressDateB;
	}

	public void setAddressDateE(LocalDate addressDateE) {
		this.addressDateE = addressDateE;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
