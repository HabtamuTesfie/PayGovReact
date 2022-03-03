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
 * <p>Java class for ExecuteCheckoutOperationsRequestDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExecuteCheckoutOperationsRequestDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Token" type="{urn:ebay:apis:eBLBaseComponents}ExpressCheckoutTokenType" minOccurs="0"/>
 *         &lt;element name="SetDataRequest" type="{urn:ebay:apis:eBLBaseComponents}SetDataRequestType"/>
 *         &lt;element name="AuthorizationRequest" type="{urn:ebay:apis:eBLBaseComponents}AuthorizationRequestType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExecuteCheckoutOperationsRequestDetailsType", propOrder = {
    "token",
    "setDataRequest",
    "authorizationRequest"
})
public class ExecuteCheckoutOperationsRequestDetailsType {

    @XmlElement(name = "Token")
    protected String token;
    @XmlElement(name = "SetDataRequest", required = true)
    protected SetDataRequestType setDataRequest;
    @XmlElement(name = "AuthorizationRequest")
    protected AuthorizationRequestType authorizationRequest;

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Gets the value of the setDataRequest property.
     * 
     * @return
     *     possible object is
     *     {@link SetDataRequestType }
     *     
     */
    public SetDataRequestType getSetDataRequest() {
        return setDataRequest;
    }

    /**
     * Sets the value of the setDataRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link SetDataRequestType }
     *     
     */
    public void setSetDataRequest(SetDataRequestType value) {
        this.setDataRequest = value;
    }

    /**
     * Gets the value of the authorizationRequest property.
     * 
     * @return
     *     possible object is
     *     {@link AuthorizationRequestType }
     *     
     */
    public AuthorizationRequestType getAuthorizationRequest() {
        return authorizationRequest;
    }

    /**
     * Sets the value of the authorizationRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorizationRequestType }
     *     
     */
    public void setAuthorizationRequest(AuthorizationRequestType value) {
        this.authorizationRequest = value;
    }

}
