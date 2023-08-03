package com.codingtest.rgt.order.controller.dto.request;

import com.codingtest.rgt.order.model.Order;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

public class NewOrderCommand {
    private final Order row;

    /**
     * 2-2 데이터 수정
     * 수정 하고자 하는 이름이 있을 경우 사용
     */

    private String targetProductName;
    private String newProductName;

    public NewOrderCommand(Order row) {
        this.row = row;
    }

    public NewOrderCommand(Order row, String targetProductName, String newProductName) {
        this.row = row;
        this.targetProductName = targetProductName;
        this.newProductName = newProductName;
    }

    public String getOrderId() {
        return row.getOrderId();
    }

    public String getProductName() {
        return row.getProductName();
    }

    public String getOptions() {
        return row.getOptions();
    }

    public Short getTableNo() {
        return row.getTableNo();
    }

    public Short getQuantity() {
        return row.getQuantity();
    }

    public Date getOrderDate() {
        return row.getOrderDate();
    }

    public Time getOrderTime() {
        return row.getOrderTime();
    }

    public LocalDateTime getDateTime() {
        return row.getDateTime();
    }

    public String getRobotStatus() {
        return row.getRobotStatus();
    }

    public String getDong() {
        return row.getDong();
    }

    public String getHo() {
        return row.getHo();
    }

    public String getSeq() {
        return row.getSeq();
    }

    public String getOrdererName() {
        return row.getOrdererName();
    }

    public String getTargetProductName() {
        return targetProductName;
    }

    public String getNewProductName() {
        return newProductName;
    }
}