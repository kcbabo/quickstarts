
package org.switchyard.quickstarts.transform.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.switchyard.quickstarts.transform.jaxb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SubmitOrder_QNAME = new QName("urn:switchyard-quickstart-transform-jaxb:1.0", "submitOrder");
    private final static QName _SubmitOrderResponse_QNAME = new QName("urn:switchyard-quickstart-transform-jaxb:1.0", "submitOrderResponse");
    private final static QName _OrderAck_QNAME = new QName("urn:switchyard-quickstart-transform-jaxb:1.0", "orderAck");
    private final static QName _Order_QNAME = new QName("urn:switchyard-quickstart-transform-jaxb:1.0", "order");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.switchyard.quickstarts.transform.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link OrderAckType }
     * 
     */
    public OrderAckType createOrderAckType() {
        return new OrderAckType();
    }

    /**
     * Create an instance of {@link OrderAck }
     * 
     */
    public OrderAck createOrderAck() {
        return new OrderAck();
    }

    /**
     * Create an instance of {@link OrderType }
     * 
     */
    public OrderType createOrderType() {
        return new OrderType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Order }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:switchyard-quickstart-transform-jaxb:1.0", name = "submitOrder")
    public JAXBElement<Order> createSubmitOrder(Order value) {
        return new JAXBElement<Order>(_SubmitOrder_QNAME, Order.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderAck }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:switchyard-quickstart-transform-jaxb:1.0", name = "submitOrderResponse")
    public JAXBElement<OrderAck> createSubmitOrderResponse(OrderAck value) {
        return new JAXBElement<OrderAck>(_SubmitOrderResponse_QNAME, OrderAck.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderAckType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:switchyard-quickstart-transform-jaxb:1.0", name = "orderAck")
    public JAXBElement<OrderAckType> createOrderAck(OrderAckType value) {
        return new JAXBElement<OrderAckType>(_OrderAck_QNAME, OrderAckType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:switchyard-quickstart-transform-jaxb:1.0", name = "order")
    public JAXBElement<OrderType> createOrder(OrderType value) {
        return new JAXBElement<OrderType>(_Order_QNAME, OrderType.class, null, value);
    }

}
