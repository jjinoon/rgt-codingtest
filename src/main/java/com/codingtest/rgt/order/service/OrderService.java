package com.codingtest.rgt.order.service;

import com.codingtest.rgt.order.controller.dto.request.OrderCommand;
import com.codingtest.rgt.order.model.Order;

import java.util.List;

public interface OrderService {
    void saveOrder(OrderCommand command);

    List<Order> getOrderList();
}
