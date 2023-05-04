//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.7 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.04 at 09:56:50 AM GMT+04:00 
//


package ru.sartfoms.schemas.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListOfSnils complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListOfSnils"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="snilsItems" type="{http://ffoms.ru/types/mpiPersonInfoSchema}SnilsData" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListOfSnils", propOrder = {
    "snilsItems"
})
public class ListOfSnils {

    @XmlElement(nillable = true)
    protected List<SnilsData> snilsItems;

    /**
     * Gets the value of the snilsItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the snilsItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSnilsItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SnilsData }
     * 
     * 
     */
    public List<SnilsData> getSnilsItems() {
        if (snilsItems == null) {
            snilsItems = new ArrayList<SnilsData>();
        }
        return this.snilsItems;
    }

}
