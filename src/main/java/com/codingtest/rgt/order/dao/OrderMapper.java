package com.codingtest.rgt.order.dao;

import com.codingtest.rgt.order.controller.dto.request.NewOrderCommand;
import com.codingtest.rgt.order.controller.dto.request.OrderCommand;
import com.codingtest.rgt.order.model.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    void insertOrder(OrderCommand command);

    List<Order> selectOrderList();

    List<Order> findLastDateTimeOrders();

    void insertNewOrder(NewOrderCommand command);
}
