//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.02.24 at 11:44:08 AM EAT 
//


package com.mycompany.myapp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ValType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ValueLiteral" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ValueID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValType", propOrder = {
    "valueLiteral"
})
public class ValType {

    @XmlElement(name = "ValueLiteral", required = true)
    protected String valueLiteral;
    @XmlAttribute(name = "ValueID")
    protected String valueID;

    /**
     * Gets the value of the valueLiteral property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValueLiteral() {
        return valueLiteral;
    }

    /**
     * Sets the value of the valueLiteral property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValueLiteral(String value) {
        this.valueLiteral = value;
    }

    /**
     * Gets the value of the valueID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValueID() {
        return valueID;
    }

    /**
     * Sets the value of the valueID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValueID(String value) {
        this.valueID = value;
    }

}
