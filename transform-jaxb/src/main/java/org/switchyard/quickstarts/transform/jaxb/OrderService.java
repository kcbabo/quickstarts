package org.switchyard.quickstarts.transform.jaxb;

public interface OrderService {
    
    OrderAck submitOrder(Order order);
    
}
