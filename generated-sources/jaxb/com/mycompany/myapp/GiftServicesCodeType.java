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
 * <p>Java class for GiftServicesCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GiftServicesCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="GiftExpressShipping"/>
 *     &lt;enumeration value="GiftShipToRecipient"/>
 *     &lt;enumeration value="GiftWrap"/>
 *     &lt;enumeration value="CustomCode"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GiftServicesCodeType")
@XmlEnum
public enum GiftServicesCodeType {


    /**
     * 
     *                         indicates that the seller is offering to ship the item via
     *                         an express shipping method as described in the item
     *                         description.
     *                     
     * 
     */
    @XmlEnumValue("GiftExpressShipping")
    GIFT_EXPRESS_SHIPPING("GiftExpressShipping"),

    /**
     * 
     *                         indicates that the seller is offering to ship to the gift recipient,
     *                         not the buyer, when payment clears.
     *                     
     * 
     */
    @XmlEnumValue("GiftShipToRecipient")
    GIFT_SHIP_TO_RECIPIENT("GiftShipToRecipient"),

    /**
     * 
     *                         indicates that the seller is offering to wrap the item (and
     *                         optionally include a card) as described in the item
     *                         description.
     *                     
     * 
     */
    @XmlEnumValue("GiftWrap")
    GIFT_WRAP("GiftWrap"),

    /**
     * 
     *                         Reserved for internal or future use.
     *                     
     * 
     */
    @XmlEnumValue("CustomCode")
    CUSTOM_CODE("CustomCode");
    private final String value;

    GiftServicesCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GiftServicesCodeType fromValue(String v) {
        for (GiftServicesCodeType c: GiftServicesCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
