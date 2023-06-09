//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.7 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.07.03 at 04:04:36 PM GMT+04:00 
//


package ru.sartfoms.schemas.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Сведения о страховой принадлежности
 * 
 * <p>Java class for StatusData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StatusData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="oip" type="{http://ffoms.ru/types/commonTypes}Oip"/&gt;
 *         &lt;element name="fio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="birthDay" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="gender" type="{http://ffoms.ru/types/commonTypes}GenderType" minOccurs="0"/&gt;
 *         &lt;element name="policyType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="policySer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="policyNumEnp" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="policyStatus" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="smo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="terr" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="policyValidFrom" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="policyValidTo" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatusData", propOrder = {
    "oip",
    "fio",
    "birthDay",
    "gender",
    "policyType",
    "policySer",
    "policyNumEnp",
    "policyStatus",
    "smo",
    "terr",
    "policyValidFrom",
    "policyValidTo"
})
public class StatusData {

    @XmlElement(required = true)
    protected String oip;
    protected String fio;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar birthDay;
    @XmlSchemaType(name = "integer")
    protected Integer gender;
    @XmlElement(required = true)
    protected String policyType;
    protected String policySer;
    @XmlElement(required = true)
    protected String policyNumEnp;
    @XmlElement(required = true)
    protected String policyStatus;
    @XmlElement(required = true)
    protected String smo;
    @XmlElement(required = true)
    protected String terr;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar policyValidFrom;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar policyValidTo;

    /**
     * Gets the value of the oip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOip() {
        return oip;
    }

    /**
     * Sets the value of the oip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOip(String value) {
        this.oip = value;
    }

    /**
     * Gets the value of the fio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFio() {
        return fio;
    }

    /**
     * Sets the value of the fio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFio(String value) {
        this.fio = value;
    }

    /**
     * Gets the value of the birthDay property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthDay() {
        return birthDay;
    }

    /**
     * Sets the value of the birthDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthDay(XMLGregorianCalendar value) {
        this.birthDay = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGender(Integer value) {
        this.gender = value;
    }

    /**
     * Gets the value of the policyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyType() {
        return policyType;
    }

    /**
     * Sets the value of the policyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyType(String value) {
        this.policyType = value;
    }

    /**
     * Gets the value of the policySer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicySer() {
        return policySer;
    }

    /**
     * Sets the value of the policySer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicySer(String value) {
        this.policySer = value;
    }

    /**
     * Gets the value of the policyNumEnp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyNumEnp() {
        return policyNumEnp;
    }

    /**
     * Sets the value of the policyNumEnp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyNumEnp(String value) {
        this.policyNumEnp = value;
    }

    /**
     * Gets the value of the policyStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyStatus() {
        return policyStatus;
    }

    /**
     * Sets the value of the policyStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyStatus(String value) {
        this.policyStatus = value;
    }

    /**
     * Gets the value of the smo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmo() {
        return smo;
    }

    /**
     * Sets the value of the smo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmo(String value) {
        this.smo = value;
    }

    /**
     * Gets the value of the terr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerr() {
        return terr;
    }

    /**
     * Sets the value of the terr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerr(String value) {
        this.terr = value;
    }

    /**
     * Gets the value of the policyValidFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPolicyValidFrom() {
        return policyValidFrom;
    }

    /**
     * Sets the value of the policyValidFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPolicyValidFrom(XMLGregorianCalendar value) {
        this.policyValidFrom = value;
    }

    /**
     * Gets the value of the policyValidTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPolicyValidTo() {
        return policyValidTo;
    }

    /**
     * Sets the value of the policyValidTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPolicyValidTo(XMLGregorianCalendar value) {
        this.policyValidTo = value;
    }

}
