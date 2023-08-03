package com.codingtest.rgt.order.model;

import lombok.Getter;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

@Getter
public class Order {
    private String orderId;
    private String productName;
    private String options;
    private Short tableNo;
    private Short quantity;
    private Date orderDate;
    private Time orderTime;
    private LocalDateTime dateTime;
    private String robotStatus;
    private String dong;
    private String ho;
    private String seq;
    private String ordererName;
}
