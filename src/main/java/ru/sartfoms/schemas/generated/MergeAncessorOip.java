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
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for MergeAncessorOip complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MergeAncessorOip"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="whenMerged" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="mergeAncessorOip" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MergeAncessorOip", propOrder = {
    "whenMerged",
    "mergeAncessorOip"
})
public class MergeAncessorOip {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar whenMerged;
    @XmlElement(required = true)
    protected String mergeAncessorOip;

    /**
     * Gets the value of the whenMerged property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getWhenMerged() {
        return whenMerged;
    }

    /**
     * Sets the value of the whenMerged property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setWhenMerged(XMLGregorianCalendar value) {
        this.whenMerged = value;
    }

    /**
     * Gets the value of the mergeAncessorOip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMergeAncessorOip() {
        return mergeAncessorOip;
    }

    /**
     * Sets the value of the mergeAncessorOip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMergeAncessorOip(String value) {
        this.mergeAncessorOip = value;
    }

}
