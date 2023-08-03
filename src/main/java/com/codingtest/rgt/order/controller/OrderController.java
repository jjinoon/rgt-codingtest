package com.codingtest.rgt.order.controller;

import com.codingtest.rgt.common.response.CommonResponse;
import com.codingtest.rgt.order.controller.dto.request.OrderCommand;
import com.codingtest.rgt.order.controller.dto.response.GetOrderResponse;
import com.codingtest.rgt.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/codingTest")
public class OrderController {

    private final MessageSource messageSource;

    private final OrderService orderService;

    @GetMapping("/order")
    public CommonResponse<?> getOrder() {
        var rows = orderService.getOrderList();
        return CommonResponse.success(rows.stream().map(GetOrderResponse::new).toList());
    }

    @PostMapping("/order")
    public CommonResponse<?> saveOrder(@RequestBody OrderCommand command) {
        orderService.saveOrder(command);
        return CommonResponse.success(messageSource.getMessage("order.save.success", new String[]{command.getOrderId()}, Locale.getDefault()));
    }
}
