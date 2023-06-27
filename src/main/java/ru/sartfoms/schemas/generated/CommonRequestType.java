//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.7 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.27 at 04:52:43 PM GMT+04:00 
//


package ru.sartfoms.schemas.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommonRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommonRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="externalRequestId" type="{http://ffoms.ru/types/commonTypes}ExternalRequestIdType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommonRequestType", namespace = "http://ffoms.ru/types/commonTypes", propOrder = {
    "externalRequestId"
})
@XmlSeeAlso({
    AsyncPollRequest.class,
    GetMergeAncessorOipRequest.class,
    FindPersonsByPersCriteriaRequest.class,
    GetPersonDataHistoryRequest.class,
    GetPersonDataRequest.class,
    GetInsuranceStatusRequest.class
})
public class CommonRequestType {

    @XmlElement(required = true)
    protected String externalRequestId;

    /**
     * Gets the value of the externalRequestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalRequestId() {
        return externalRequestId;
    }

    /**
     * Sets the value of the externalRequestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalRequestId(String value) {
        this.externalRequestId = value;
    }

}
