//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.7 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.04 at 09:56:50 AM GMT+04:00 
//


package ru.sartfoms.schemas.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PersonDocIdentShortBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonDocIdentShortBase"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dudlSer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dudlNum" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="dudlDateB" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="dudlType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="surname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="patronymic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonDocIdentShortBase", namespace = "http://ffoms.ru/types/commonTypes", propOrder = {
    "dudlSer",
    "dudlNum",
    "dudlDateB",
    "dudlType",
    "surname",
    "patronymic",
    "firstName"
})
@XmlSeeAlso({
    PersonDocIdentFullBase.class
})
public class PersonDocIdentShortBase {

    protected String dudlSer;
    @XmlElement(required = true)
    protected String dudlNum;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dudlDateB;
    @XmlElement(required = true)
    protected String dudlType;
    protected String surname;
    protected String patronymic;
    protected String firstName;

    /**
     * Gets the value of the dudlSer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDudlSer() {
        return dudlSer;
    }

    /**
     * Sets the value of the dudlSer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDudlSer(String value) {
        this.dudlSer = value;
    }

    /**
     * Gets the value of the dudlNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDudlNum() {
        return dudlNum;
    }

    /**
     * Sets the value of the dudlNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDudlNum(String value) {
        this.dudlNum = value;
    }

    /**
     * Gets the value of the dudlDateB property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDudlDateB() {
        return dudlDateB;
    }

    /**
     * Sets the value of the dudlDateB property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDudlDateB(XMLGregorianCalendar value) {
        this.dudlDateB = value;
    }

    /**
     * Gets the value of the dudlType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDudlType() {
        return dudlType;
    }

    /**
     * Sets the value of the dudlType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDudlType(String value) {
        this.dudlType = value;
    }

    /**
     * Gets the value of the surname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the value of the surname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurname(String value) {
        this.surname = value;
    }

    /**
     * Gets the value of the patronymic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * Sets the value of the patronymic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatronymic(String value) {
        this.patronymic = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

}
