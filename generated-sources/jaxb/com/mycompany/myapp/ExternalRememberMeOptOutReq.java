//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.02.24 at 11:44:08 AM EAT 
//


package com.mycompany.myapp;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:ebay:api:PayPalAPI}ExternalRememberMeOptOutRequest"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "externalRememberMeOptOutRequest"
})
@XmlRootElement(name = "ExternalRememberMeOptOutReq", namespace = "urn:ebay:api:PayPalAPI")
public class ExternalRememberMeOptOutReq {

    @XmlElement(name = "ExternalRememberMeOptOutRequest", namespace = "urn:ebay:api:PayPalAPI", required = true)
    protected ExternalRememberMeOptOutRequestType externalRememberMeOptOutRequest;

    /**
     * Gets the value of the externalRememberMeOptOutRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalRememberMeOptOutRequestType }
     *     
     */
    public ExternalRememberMeOptOutRequestType getExternalRememberMeOptOutRequest() {
        return externalRememberMeOptOutRequest;
    }

    /**
     * Sets the value of the externalRememberMeOptOutRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalRememberMeOptOutRequestType }
     *     
     */
    public void setExternalRememberMeOptOutRequest(ExternalRememberMeOptOutRequestType value) {
        this.externalRememberMeOptOutRequest = value;
    }

}
