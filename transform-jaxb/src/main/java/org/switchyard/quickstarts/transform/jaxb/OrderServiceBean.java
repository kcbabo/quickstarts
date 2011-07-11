package org.switchyard.quickstarts.transform.jaxb;

import org.switchyard.component.bean.Service;

@Service(OrderService.class)
public class OrderServiceBean implements OrderService {
    
    @Override
    public OrderAck submitOrder(Order order) {
        // Create an order ack
        OrderAckType orderAckType = new OrderAckType();
        orderAckType.setOrderId(order.getOrder().getOrderId());
        orderAckType.setAccepted(true);
        orderAckType.setStatus("Order Accepted");
        OrderAck orderAck = new OrderAck();
        orderAck.setOrderAck(orderAckType);
        
        return orderAck;
    }

}
