//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.7 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.29 at 09:42:46 AM GMT+04:00 
//


package ru.sartfoms.schemas.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonSearchInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonSearchInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="oip" type="{http://ffoms.ru/types/commonTypes}Oip"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonSearchInfo", propOrder = {
    "oip"
})
public class PersonSearchInfo {

    @XmlElement(required = true)
    protected String oip;

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

}
