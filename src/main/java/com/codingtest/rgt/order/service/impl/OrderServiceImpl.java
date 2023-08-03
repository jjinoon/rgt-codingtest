package com.codingtest.rgt.order.service.impl;

import com.codingtest.rgt.order.controller.dto.request.OrderCommand;
import com.codingtest.rgt.order.dao.OrderMapper;
import com.codingtest.rgt.order.model.Order;
import com.codingtest.rgt.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    @Override
    @Transactional
    public void saveOrder(OrderCommand command) {
        orderMapper.insertOrder(command);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getOrderList() {
        return orderMapper.selectOrderList();
    }
}
