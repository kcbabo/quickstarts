/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.switchyard.quickstarts.bean.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.ReferenceInvoker;
import org.switchyard.component.bean.Service;

@Service(OrderService.class)
public class OrderServiceBean implements OrderService {

    @Inject
    @Reference("InventoryService")
    private ReferenceInvoker _inventory;
    
    @Inject @Named("ExtraBean")
    private Extra extras;

    @Override
    public OrderAck submitOrder(Order order) {
        System.out.println("=========== Calling normal CDI Bean ===========");
        extras.execute();
        // Create an order ack
        OrderAck orderAck = new OrderAck().setOrderId(order.getOrderId());
        // Check the inventory
        try {
            System.out.println("=========== Using ReferenceInvoker ===========");
            Item orderItem = _inventory.newInvocation("lookupItem")
                    .invoke(order.getItemId()).getMessage().getContent(Item.class);
            // Check quantity on hand and generate the ack
            if (orderItem.getQuantity() >= order.getQuantity()) {
                orderAck.setAccepted(true).setStatus("Order Accepted");
            } else {
                orderAck.setAccepted(false).setStatus("Insufficient Quantity");
            }
        } catch (ItemNotFoundException infEx) {
            orderAck.setAccepted(false).setStatus("Item Not Available");
        }
        catch (Exception ex) {
            System.out.println("failed with reference invoker");
            ex.printStackTrace();
        }
        return orderAck;
    }

}
