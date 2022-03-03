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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExternalRememberMeOptOutRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExternalRememberMeOptOutRequestType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:ebay:apis:eBLBaseComponents}AbstractRequestType">
 *       &lt;sequence>
 *         &lt;element name="ExternalRememberMeID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ExternalRememberMeOwnerDetails" type="{urn:ebay:apis:eBLBaseComponents}ExternalRememberMeOwnerDetailsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExternalRememberMeOptOutRequestType", namespace = "urn:ebay:api:PayPalAPI", propOrder = {
    "externalRememberMeID",
    "externalRememberMeOwnerDetails"
})
public class ExternalRememberMeOptOutRequestType
    extends AbstractRequestType
{

    @XmlElement(name = "ExternalRememberMeID", required = true)
    protected String externalRememberMeID;
    @XmlElement(name = "ExternalRememberMeOwnerDetails")
    protected ExternalRememberMeOwnerDetailsType externalRememberMeOwnerDetails;

    /**
     * Gets the value of the externalRememberMeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalRememberMeID() {
        return externalRememberMeID;
    }

    /**
     * Sets the value of the externalRememberMeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalRememberMeID(String value) {
        this.externalRememberMeID = value;
    }

    /**
     * Gets the value of the externalRememberMeOwnerDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalRememberMeOwnerDetailsType }
     *     
     */
    public ExternalRememberMeOwnerDetailsType getExternalRememberMeOwnerDetails() {
        return externalRememberMeOwnerDetails;
    }

    /**
     * Sets the value of the externalRememberMeOwnerDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalRememberMeOwnerDetailsType }
     *     
     */
    public void setExternalRememberMeOwnerDetails(ExternalRememberMeOwnerDetailsType value) {
        this.externalRememberMeOwnerDetails = value;
    }

}
