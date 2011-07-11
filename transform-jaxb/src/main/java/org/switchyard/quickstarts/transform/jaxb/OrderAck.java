
package org.switchyard.quickstarts.transform.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrderAck complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderAck">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orderAck" type="{urn:switchyard-quickstart-transform-jaxb:1.0}orderAckType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderAck", propOrder = {
    "orderAck"
})
public class OrderAck {

    @XmlElement(required = true)
    protected OrderAckType orderAck;

    /**
     * Gets the value of the orderAck property.
     * 
     * @return
     *     possible object is
     *     {@link OrderAckType }
     *     
     */
    public OrderAckType getOrderAck() {
        return orderAck;
    }

    /**
     * Sets the value of the orderAck property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderAckType }
     *     
     */
    public void setOrderAck(OrderAckType value) {
        this.orderAck = value;
    }

}
