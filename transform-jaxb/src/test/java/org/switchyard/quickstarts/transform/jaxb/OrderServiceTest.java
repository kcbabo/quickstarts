/* 
 * JBoss, Home of Professional Open Source 
 * Copyright 2010-2011 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved. 
 * See the copyright.txt in the distribution for a 
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use, 
 * modify, copy, or redistribute it subject to the terms and conditions 
 * of the GNU Lesser General Public License, v. 2.1. 
 * This program is distributed in the hope that it will be useful, but WITHOUT A 
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more 
 * details. You should have received a copy of the GNU Lesser General Public 
 * License, v.2.1 along with this distribution; if not, write to the Free 
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  
 * 02110-1301, USA.
 */

package org.switchyard.quickstarts.transform.jaxb;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;

import org.junit.Assert;
import org.junit.Test;
import org.switchyard.test.SwitchYardTestCase;
import org.switchyard.test.SwitchYardTestCaseConfig;
import org.switchyard.test.mixins.CDIMixIn;

@SwitchYardTestCaseConfig(mixins = CDIMixIn.class)
public class OrderServiceTest extends SwitchYardTestCase {

    private static final String XML_ORDER = "<?xml version=\"1.0\" encoding=\"UTF-8\" " +
    		"standalone=\"yes\"?><ns2:submitOrder " +
    		"xmlns:ns2=\"urn:switchyard-quickstart-transform-jaxb:1.0\"><order>" +
    		"<orderId>xz-456</orderId><itemId>id4987</itemId><quantity>4</quantity>" +
    		"</order></ns2:submitOrder>"; 

    private static final String XML_ORDERACK = "<?xml version=\"1.0\" encoding=\"UTF-8\" " +
    		"standalone=\"yes\"?><ns2:submitOrderResponse " +
    		"xmlns:ns2=\"urn:switchyard-quickstart-transform-jaxb:1.0\"><orderAck>" +
    		"<orderId>xz-456</orderId><accepted>true</accepted><status>Processing</status>" +
    		"</orderAck></ns2:submitOrderResponse>"; 
    
    @Test
    public void testJaxbOrderToXML() throws Exception {
        OrderType orderType = new OrderType();
        orderType.setItemId("id4987");
        orderType.setOrderId("xz-456");
        orderType.setQuantity(4);
        
        Order order = new Order();
        order.setOrder(orderType);
        
        ObjectFactory of = new ObjectFactory();
        JAXBElement<Order> jaxbOrder = of.createSubmitOrder(order);
        
        JAXBContext jaxbContext = JAXBContext.newInstance(new Class[] {Order.class});
        StringWriter resultWriter = new StringWriter();
        Marshaller marshaller = jaxbContext.createMarshaller();
        
        marshaller.marshal(jaxbOrder, resultWriter);

        Assert.assertEquals(XML_ORDER, resultWriter.toString());
    }
    
    @Test
    public void testJaxbOrderAckToXML() throws Exception {
        OrderAckType orderAckType = new OrderAckType();
        orderAckType.setAccepted(Boolean.TRUE);
        orderAckType.setOrderId("xz-456");
        orderAckType.setStatus("Processing");
        
        OrderAck orderAck = new OrderAck();
        orderAck.setOrderAck(orderAckType);
        
        ObjectFactory of = new ObjectFactory();
        JAXBElement<OrderAck> jaxbOrderAck = of.createSubmitOrderResponse(orderAck);
        
        JAXBContext jaxbContext = JAXBContext.newInstance(new Class[] {OrderAck.class});
        StringWriter resultWriter = new StringWriter();
        Marshaller marshaller = jaxbContext.createMarshaller();
        
        marshaller.marshal(jaxbOrderAck, resultWriter);
        
        System.out.println(resultWriter.toString());
        
        Assert.assertEquals(XML_ORDERACK, resultWriter.toString());
    }
    
    @Test
    public void testOrderAccepted() throws Exception {
        OrderType orderType = new OrderType();
        orderType.setOrderId("ORDER01");
        orderType.setItemId("BUTTER");
        orderType.setQuantity(100);
        Order order = new Order();
        order.setOrder(orderType);
        
        OrderAck ack = newInvoker("OrderService")
            .operation("submitOrder")
            .sendInOut(order)
            .getContent(OrderAck.class);

        Assert.assertTrue(ack.getOrderAck().isAccepted());
    }
}
