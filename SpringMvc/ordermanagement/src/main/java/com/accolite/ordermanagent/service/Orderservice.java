package com.accolite.ordermanagent.service;

import com.accolite.ordermanagement.model.Order;
import com.accolite.ordermanagement.model.OrderItem;
import com.accolite.ordermanagement.model.Ordermanage;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Orderservice {

    private int lastOrderIdGiven, lastItemIdGiven;
    private Ordermanage orders;

    public Orderservice(){
        this.lastOrderIdGiven = 0;
        this.lastItemIdGiven = 0;
        orders = new Ordermanage();
    }

    public Order createOrder(Order order){
        order.setId(++lastItemIdGiven);
        orders.setOrdersList(order);
        return order;
    }

    public List<Order> getAllOrders(){
        return orders.getOrdersList();
    }

    public Order addItemToOrder(int orderId, OrderItem item){
        Order currentOrder = orders.getOrder(orderId);
        item.setId(++lastOrderIdGiven);
        if(currentOrder.addItem(item)) {
            return currentOrder;
        }
        return null;
    }

    public List<OrderItem> getOrderItems(int orderId){
        Order currentOrder = orders.getOrder(orderId);
        return currentOrder.getItemsList();
    }

    public boolean checkOrderItem(int orderId){
        Order currentOrder = orders.getOrder(orderId);
        if(currentOrder == null){
            return false;
        }
        return true;
    }

    public boolean removeItemFromOrder(int orderId, int itemId){
        Order currentOrder = orders.getOrder(orderId);
        return currentOrder.removeItem(itemId);
    }

    public OrderItem updateItem(int itemId, int orderId, OrderItem item){
        Order currentOrder = orders.getOrder(orderId);
        item.setId(++lastOrderIdGiven);
        return currentOrder.updateOrderItem(itemId, item);
    }

    public boolean removeOrder(int orderId){
        return orders.removeOrder(orderId);
    }
}
