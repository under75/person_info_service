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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SnilsData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SnilsData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="snils" type="{http://ffoms.ru/types/commonTypes}SnilsType"/&gt;
 *         &lt;element name="dsource" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="dsourceType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="statusSnils" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SnilsData", propOrder = {
    "snils",
    "dsource",
    "dsourceType",
    "descr",
    "statusSnils"
})
public class SnilsData {

    @XmlElement(required = true)
    protected String snils;
    @XmlElement(required = true)
    protected String dsource;
    @XmlElement(required = true)
    protected String dsourceType;
    protected String descr;
    @XmlElement(required = true)
    protected String statusSnils;

    /**
     * Gets the value of the snils property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSnils() {
        return snils;
    }

    /**
     * Sets the value of the snils property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSnils(String value) {
        this.snils = value;
    }

    /**
     * Gets the value of the dsource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsource() {
        return dsource;
    }

    /**
     * Sets the value of the dsource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsource(String value) {
        this.dsource = value;
    }

    /**
     * Gets the value of the dsourceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsourceType() {
        return dsourceType;
    }

    /**
     * Sets the value of the dsourceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsourceType(String value) {
        this.dsourceType = value;
    }

    /**
     * Gets the value of the descr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescr() {
        return descr;
    }

    /**
     * Sets the value of the descr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescr(String value) {
        this.descr = value;
    }

    /**
     * Gets the value of the statusSnils property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusSnils() {
        return statusSnils;
    }

    /**
     * Sets the value of the statusSnils property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusSnils(String value) {
        this.statusSnils = value;
    }

}
