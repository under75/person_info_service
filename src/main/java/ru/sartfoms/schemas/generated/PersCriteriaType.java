//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.7 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.07.03 at 04:04:36 PM GMT+04:00 
//


package ru.sartfoms.schemas.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PersCriteriaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersCriteriaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="pagination" type="{http://ffoms.ru/types/commonTypes}PaginationRequestType" minOccurs="0"/&gt;
 *         &lt;element name="terrOkato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fio" type="{http://ffoms.ru/types/mpiPersonInfoSchema}FioData" minOccurs="0"/&gt;
 *         &lt;element name="birthDayFrom" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="birthDayTo" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="deathDateFrom" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="deathDateTo" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="personSearchInfo" type="{http://ffoms.ru/types/mpiPersonInfoSchema}PersonCommonSearchParamsType" minOccurs="0"/&gt;
 *         &lt;element name="ern" type="{http://ffoms.ru/types/commonTypes}ernType" minOccurs="0"/&gt;
 *         &lt;element name="dt" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersCriteriaType", propOrder = {
    "pagination",
    "terrOkato",
    "fio",
    "birthDayFrom",
    "birthDayTo",
    "deathDateFrom",
    "deathDateTo",
    "personSearchInfo",
    "ern",
    "dt"
})
public class PersCriteriaType {

    protected PaginationRequestType pagination;
    protected String terrOkato;
    protected FioData fio;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar birthDayFrom;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar birthDayTo;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar deathDateFrom;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar deathDateTo;
    protected PersonCommonSearchParamsType personSearchInfo;
    protected String ern;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dt;

    /**
     * Gets the value of the pagination property.
     * 
     * @return
     *     possible object is
     *     {@link PaginationRequestType }
     *     
     */
    public PaginationRequestType getPagination() {
        return pagination;
    }

    /**
     * Sets the value of the pagination property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaginationRequestType }
     *     
     */
    public void setPagination(PaginationRequestType value) {
        this.pagination = value;
    }

    /**
     * Gets the value of the terrOkato property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerrOkato() {
        return terrOkato;
    }

    /**
     * Sets the value of the terrOkato property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerrOkato(String value) {
        this.terrOkato = value;
    }

    /**
     * Gets the value of the fio property.
     * 
     * @return
     *     possible object is
     *     {@link FioData }
     *     
     */
    public FioData getFio() {
        return fio;
    }

    /**
     * Sets the value of the fio property.
     * 
     * @param value
     *     allowed object is
     *     {@link FioData }
     *     
     */
    public void setFio(FioData value) {
        this.fio = value;
    }

    /**
     * Gets the value of the birthDayFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthDayFrom() {
        return birthDayFrom;
    }

    /**
     * Sets the value of the birthDayFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthDayFrom(XMLGregorianCalendar value) {
        this.birthDayFrom = value;
    }

    /**
     * Gets the value of the birthDayTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthDayTo() {
        return birthDayTo;
    }

    /**
     * Sets the value of the birthDayTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthDayTo(XMLGregorianCalendar value) {
        this.birthDayTo = value;
    }

    /**
     * Gets the value of the deathDateFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeathDateFrom() {
        return deathDateFrom;
    }

    /**
     * Sets the value of the deathDateFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeathDateFrom(XMLGregorianCalendar value) {
        this.deathDateFrom = value;
    }

    /**
     * Gets the value of the deathDateTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeathDateTo() {
        return deathDateTo;
    }

    /**
     * Sets the value of the deathDateTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeathDateTo(XMLGregorianCalendar value) {
        this.deathDateTo = value;
    }

    /**
     * Gets the value of the personSearchInfo property.
     * 
     * @return
     *     possible object is
     *     {@link PersonCommonSearchParamsType }
     *     
     */
    public PersonCommonSearchParamsType getPersonSearchInfo() {
        return personSearchInfo;
    }

    /**
     * Sets the value of the personSearchInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonCommonSearchParamsType }
     *     
     */
    public void setPersonSearchInfo(PersonCommonSearchParamsType value) {
        this.personSearchInfo = value;
    }

    /**
     * Gets the value of the ern property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErn() {
        return ern;
    }

    /**
     * Sets the value of the ern property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErn(String value) {
        this.ern = value;
    }

    /**
     * Gets the value of the dt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDt() {
        return dt;
    }

    /**
     * Sets the value of the dt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDt(XMLGregorianCalendar value) {
        this.dt = value;
    }

}
