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
 * <p>Java class for DoDirectPaymentResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DoDirectPaymentResponseType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:ebay:apis:eBLBaseComponents}AbstractResponseType">
 *       &lt;sequence>
 *         &lt;element name="Amount" type="{urn:ebay:apis:CoreComponentTypes}BasicAmountType"/>
 *         &lt;element name="AVSCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CVV2Code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TransactionID" type="{urn:ebay:apis:eBLBaseComponents}TransactionId" minOccurs="0"/>
 *         &lt;element name="TransactionPendingReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PendingReason" type="{urn:ebay:apis:eBLBaseComponents}PendingStatusCodeType" minOccurs="0"/>
 *         &lt;element name="PaymentStatus" type="{urn:ebay:apis:eBLBaseComponents}PaymentStatusCodeType" minOccurs="0"/>
 *         &lt;element name="FMFDetails" type="{urn:ebay:apis:eBLBaseComponents}FMFDetailsType" minOccurs="0"/>
 *         &lt;element name="ThreeDSecureResponse" type="{urn:ebay:apis:eBLBaseComponents}ThreeDSecureResponseType" minOccurs="0"/>
 *         &lt;element name="PaymentAdviceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DoDirectPaymentResponseType", namespace = "urn:ebay:api:PayPalAPI", propOrder = {
    "amount",
    "avsCode",
    "cvv2Code",
    "transactionID",
    "transactionPendingReason",
    "pendingReason",
    "paymentStatus",
    "fmfDetails",
    "threeDSecureResponse",
    "paymentAdviceCode"
})
public class DoDirectPaymentResponseType
    extends AbstractResponseType
{

    @XmlElement(name = "Amount", required = true)
    protected BasicAmountType amount;
    @XmlElement(name = "AVSCode", required = true)
    protected String avsCode;
    @XmlElement(name = "CVV2Code", required = true)
    protected String cvv2Code;
    @XmlElement(name = "TransactionID")
    protected String transactionID;
    @XmlElement(name = "TransactionPendingReason")
    protected String transactionPendingReason;
    @XmlElement(name = "PendingReason")
    protected PendingStatusCodeType pendingReason;
    @XmlElement(name = "PaymentStatus")
    protected PaymentStatusCodeType paymentStatus;
    @XmlElement(name = "FMFDetails")
    protected FMFDetailsType fmfDetails;
    @XmlElement(name = "ThreeDSecureResponse")
    protected ThreeDSecureResponseType threeDSecureResponse;
    @XmlElement(name = "PaymentAdviceCode")
    protected String paymentAdviceCode;

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link BasicAmountType }
     *     
     */
    public BasicAmountType getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BasicAmountType }
     *     
     */
    public void setAmount(BasicAmountType value) {
        this.amount = value;
    }

    /**
     * Gets the value of the avsCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAVSCode() {
        return avsCode;
    }

    /**
     * Sets the value of the avsCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAVSCode(String value) {
        this.avsCode = value;
    }

    /**
     * Gets the value of the cvv2Code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCVV2Code() {
        return cvv2Code;
    }

    /**
     * Sets the value of the cvv2Code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCVV2Code(String value) {
        this.cvv2Code = value;
    }

    /**
     * Gets the value of the transactionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionID() {
        return transactionID;
    }

    /**
     * Sets the value of the transactionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionID(String value) {
        this.transactionID = value;
    }

    /**
     * Gets the value of the transactionPendingReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionPendingReason() {
        return transactionPendingReason;
    }

    /**
     * Sets the value of the transactionPendingReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionPendingReason(String value) {
        this.transactionPendingReason = value;
    }

    /**
     * Gets the value of the pendingReason property.
     * 
     * @return
     *     possible object is
     *     {@link PendingStatusCodeType }
     *     
     */
    public PendingStatusCodeType getPendingReason() {
        return pendingReason;
    }

    /**
     * Sets the value of the pendingReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link PendingStatusCodeType }
     *     
     */
    public void setPendingReason(PendingStatusCodeType value) {
        this.pendingReason = value;
    }

    /**
     * Gets the value of the paymentStatus property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentStatusCodeType }
     *     
     */
    public PaymentStatusCodeType getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * Sets the value of the paymentStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentStatusCodeType }
     *     
     */
    public void setPaymentStatus(PaymentStatusCodeType value) {
        this.paymentStatus = value;
    }

    /**
     * Gets the value of the fmfDetails property.
     * 
     * @return
     *     possible object is
     *     {@link FMFDetailsType }
     *     
     */
    public FMFDetailsType getFMFDetails() {
        return fmfDetails;
    }

    /**
     * Sets the value of the fmfDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link FMFDetailsType }
     *     
     */
    public void setFMFDetails(FMFDetailsType value) {
        this.fmfDetails = value;
    }

    /**
     * Gets the value of the threeDSecureResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ThreeDSecureResponseType }
     *     
     */
    public ThreeDSecureResponseType getThreeDSecureResponse() {
        return threeDSecureResponse;
    }

    /**
     * Sets the value of the threeDSecureResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThreeDSecureResponseType }
     *     
     */
    public void setThreeDSecureResponse(ThreeDSecureResponseType value) {
        this.threeDSecureResponse = value;
    }

    /**
     * Gets the value of the paymentAdviceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentAdviceCode() {
        return paymentAdviceCode;
    }

    /**
     * Sets the value of the paymentAdviceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentAdviceCode(String value) {
        this.paymentAdviceCode = value;
    }

}
