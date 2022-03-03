//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.02.24 at 11:44:08 AM EAT 
//


package com.mycompany.myapp;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PendingStatusCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PendingStatusCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="echeck"/>
 *     &lt;enumeration value="intl"/>
 *     &lt;enumeration value="verify"/>
 *     &lt;enumeration value="address"/>
 *     &lt;enumeration value="unilateral"/>
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="upgrade"/>
 *     &lt;enumeration value="multi-currency"/>
 *     &lt;enumeration value="authorization"/>
 *     &lt;enumeration value="order"/>
 *     &lt;enumeration value="payment-review"/>
 *     &lt;enumeration value="regulatory-review"/>
 *     &lt;enumeration value="delayed-disbursement"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PendingStatusCodeType")
@XmlEnum
public enum PendingStatusCodeType {

    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("echeck")
    ECHECK("echeck"),
    @XmlEnumValue("intl")
    INTL("intl"),
    @XmlEnumValue("verify")
    VERIFY("verify"),
    @XmlEnumValue("address")
    ADDRESS("address"),
    @XmlEnumValue("unilateral")
    UNILATERAL("unilateral"),
    @XmlEnumValue("other")
    OTHER("other"),
    @XmlEnumValue("upgrade")
    UPGRADE("upgrade"),
    @XmlEnumValue("multi-currency")
    MULTI_CURRENCY("multi-currency"),
    @XmlEnumValue("authorization")
    AUTHORIZATION("authorization"),
    @XmlEnumValue("order")
    ORDER("order"),
    @XmlEnumValue("payment-review")
    PAYMENT_REVIEW("payment-review"),
    @XmlEnumValue("regulatory-review")
    REGULATORY_REVIEW("regulatory-review"),
    @XmlEnumValue("delayed-disbursement")
    DELAYED_DISBURSEMENT("delayed-disbursement");
    private final String value;

    PendingStatusCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PendingStatusCodeType fromValue(String v) {
        for (PendingStatusCodeType c: PendingStatusCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
