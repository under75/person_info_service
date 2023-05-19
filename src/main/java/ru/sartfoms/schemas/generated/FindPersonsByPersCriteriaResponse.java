//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.7 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.19 at 08:57:00 AM GMT+04:00 
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
 *         &lt;element name="persons" type="{http://ffoms.ru/types/mpiPersonInfoSchema}ListOfPdShort" minOccurs="0"/&gt;
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
    "persons"
})
@XmlRootElement(name = "findPersonsByPersCriteriaResponse")
public class FindPersonsByPersCriteriaResponse
    extends CommonResponseType
{

    protected ListOfPdShort persons;

    /**
     * Gets the value of the persons property.
     * 
     * @return
     *     possible object is
     *     {@link ListOfPdShort }
     *     
     */
    public ListOfPdShort getPersons() {
        return persons;
    }

    /**
     * Sets the value of the persons property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListOfPdShort }
     *     
     */
    public void setPersons(ListOfPdShort value) {
        this.persons = value;
    }

}
