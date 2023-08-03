package com.codingtest.rgt.order.controller.dto.request;

import lombok.Getter;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class OrderCommand {
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

    public void setDateTime(String dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.dateTime = LocalDateTime.parse(dateTime, formatter);
    }
}
