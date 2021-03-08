package com.accolite.ordermanagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.accolite.ordermanagement.model.Order;
import com.accolite.ordermanagement.model.OrderItem;
import com.accolite.ordermanagent.service.Orderservice;

import java.util.List;

@RestController
@RequestMapping({"/orders"})
public class Ordercontroller {
    @Autowired
    Orderservice orderService;

    /**
     a) POST API to Create an Order
     b) POST API to Add items in an Order
     c) PUT API to Update Item details
     d) GET API to Get all the Item details in an Order
     e) DELETE API to Delete an Item in an Order
     f) DELETE API to Delete an Order
     */

    @SuppressWarnings("unchecked")
	@PostMapping({"/createorder"})
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        if(order.isValid()) {
            return new ResponseEntity(this.orderService.createOrder(order), HttpStatus.CREATED);
        }
        return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
    }

    @PostMapping({"/additem/{id}"})
    public ResponseEntity<Order> addItemToOrder(@PathVariable(required = true, name = "orderId") int orderId, @RequestBody OrderItem item) {
        if(this.orderService.checkOrderItem(orderId) == false){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        if(item.isValid()) {
            return new ResponseEntity(this.orderService.addItemToOrder(orderId, item), HttpStatus.CREATED);
        }
        return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping({"/orderitems/{id}"})
    public ResponseEntity<List<OrderItem>> getAllOrderItems(@PathVariable(required = true, name = "orderId") int orderId) {
        if(this.orderService.checkOrderItem(orderId) == false){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(this.orderService.getOrderItems(orderId), HttpStatus.OK);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping({"/allorders"})
    public ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity(this.orderService.getAllOrders(), HttpStatus.OK);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping({"/updateitem/{order_id}/{item_id}"})
    public ResponseEntity<OrderItem> updateItem(@PathVariable(required = true,name = "itemId") int itemId, @PathVariable(required = true,name = "orderId") int orderId, @RequestBody OrderItem item) {
        if(this.orderService.checkOrderItem(orderId) == false){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        if(item.isValid()) {
            return new ResponseEntity(this.orderService.updateItem(itemId, orderId, item), HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping({"/deleteitem/{orderid}/{itemid}"})
    public ResponseEntity<Boolean> deleteItemFromOrder(@PathVariable(required = true, name = "orderId") int orderId, @PathVariable(required = true, name = "itemId") int itemId) {
        if(this.orderService.checkOrderItem(orderId) == false){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(this.orderService.removeItemFromOrder(orderId, itemId), HttpStatus.OK);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping({"/deleteOrder/{id}"})
    public ResponseEntity<Boolean> deleteOrder(@PathVariable(required = true, name = "orderId") int orderId) {
        if(this.orderService.checkOrderItem(orderId) == false){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(this.orderService.removeOrder(orderId), HttpStatus.OK);
    }
}
