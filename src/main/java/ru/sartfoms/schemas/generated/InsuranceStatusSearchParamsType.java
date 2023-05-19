//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.7 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.19 at 08:57:00 AM GMT+04:00 
//


package ru.sartfoms.schemas.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for InsuranceStatusSearchParamsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InsuranceStatusSearchParamsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="personSearchInfo" type="{http://ffoms.ru/types/mpiPersonInfoSchema}PersonCommonSearchParamsType"/&gt;
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
@XmlType(name = "InsuranceStatusSearchParamsType", propOrder = {
    "personSearchInfo",
    "dt"
})
public class InsuranceStatusSearchParamsType {

    @XmlElement(required = true)
    protected PersonCommonSearchParamsType personSearchInfo;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dt;

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
