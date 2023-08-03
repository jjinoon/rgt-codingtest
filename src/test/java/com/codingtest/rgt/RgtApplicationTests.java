package com.codingtest.rgt;

import com.codingtest.rgt.order.controller.dto.request.NewOrderCommand;
import com.codingtest.rgt.order.dao.OrderMapper;
import com.codingtest.rgt.order.model.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RgtApplicationTests {

	@Autowired
	OrderMapper orderMapper;

	@Test
	void Test_2() {
		/**
		 *  2-1 데이터 중복 처리
		 *
		 *  DB에 저장되 있는 데이터를 각 order_id 마다 마지막 등록일 기준 으로 불러온 뒤 새로운 테이블에 저장
		 *
		 */
		List<Order> orders = orderMapper.findLastDateTimeOrders();

		orders.forEach(order -> {
			orderMapper.insertNewOrder(new NewOrderCommand(order, "카페테리아", "카페라떼"));
		});
	}
}
