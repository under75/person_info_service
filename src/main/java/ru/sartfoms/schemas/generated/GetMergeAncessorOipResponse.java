//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.7 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.04 at 09:56:50 AM GMT+04:00 
//


package ru.sartfoms.schemas.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *     &lt;extension base="{http://ffoms.ru/types/commonTypes}CommonResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="mergeAncessorOip" type="{http://ffoms.ru/types/mpiPersonInfoSchema}MergeAncessorOip" minOccurs="0"/&gt;
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
    "mergeAncessorOip"
})
@XmlRootElement(name = "getMergeAncessorOipResponse")
public class GetMergeAncessorOipResponse
    extends CommonResponseType
{

    protected MergeAncessorOip mergeAncessorOip;

    /**
     * Gets the value of the mergeAncessorOip property.
     * 
     * @return
     *     possible object is
     *     {@link MergeAncessorOip }
     *     
     */
    public MergeAncessorOip getMergeAncessorOip() {
        return mergeAncessorOip;
    }

    /**
     * Sets the value of the mergeAncessorOip property.
     * 
     * @param value
     *     allowed object is
     *     {@link MergeAncessorOip }
     *     
     */
    public void setMergeAncessorOip(MergeAncessorOip value) {
        this.mergeAncessorOip = value;
    }

}