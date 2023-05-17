package ru.sartfoms.personinfoservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "mpi_ern", schema = "OMCOWNER")
@IdClass(CompositeKey.class)
public class Ern {
	@Id
	@Column(name = "rid")
	private Long rid;

	@Id
	@Column(name = "nr")
	private Integer nr;

	@Column(name = "ern")
	private String ern;

	@Column(name = "dsource")
	private String dsource;

	@Column(name = "dsourcetype")
	private String dsourceType;

	@Column(name = "ernstatus")
	private String ernstatus;

	public Long getRid() {
		return rid;
	}

	public Integer getNr() {
		return nr;
	}

	public String getErn() {
		return ern;
	}

	public String getDsource() {
		return dsource;
	}

	public String getDsourceType() {
		return dsourceType;
	}

	public String getErnstatus() {
		return ernstatus;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public void setNr(Integer nr) {
		this.nr = nr;
	}

	public void setErn(String ern) {
		this.ern = ern;
	}

	public void setDsource(String dsourceStr) {
		this.dsource = dsourceStr;
	}

	public void setDsourceType(String dsourceType) {
		this.dsourceType = dsourceType;
	}

	public void setErnstatus(String ernstatus) {
		this.ernstatus = ernstatus;
	}

}
