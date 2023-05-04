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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ffoms.ru/types/commonTypes}CommonRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="personDataHistorySearchParams" type="{http://ffoms.ru/types/mpiPersonInfoSchema}PersonDataHistorySearchParamsType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "personDataHistorySearchParams"
})
@XmlRootElement(name = "getPersonDataHistoryRequest")
public class GetPersonDataHistoryRequest
    extends CommonRequestType
{

    @XmlElement(required = true)
    protected PersonDataHistorySearchParamsType personDataHistorySearchParams;

    /**
     * Gets the value of the personDataHistorySearchParams property.
     * 
     * @return
     *     possible object is
     *     {@link PersonDataHistorySearchParamsType }
     *     
     */
    public PersonDataHistorySearchParamsType getPersonDataHistorySearchParams() {
        return personDataHistorySearchParams;
    }

    /**
     * Sets the value of the personDataHistorySearchParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonDataHistorySearchParamsType }
     *     
     */
    public void setPersonDataHistorySearchParams(PersonDataHistorySearchParamsType value) {
        this.personDataHistorySearchParams = value;
    }

}