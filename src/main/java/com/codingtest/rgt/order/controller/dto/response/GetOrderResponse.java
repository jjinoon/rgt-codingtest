package com.codingtest.rgt.order.controller.dto.response;

import com.codingtest.rgt.order.model.Order;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetOrderResponse {
    final Order row;

    public GetOrderResponse(Order row) {
        this.row = row;
    }


    @JsonProperty
    public String getOrderId() {
        return row.getOrderId();
    }

    @JsonProperty
    public String getProductName() {
        return row.getProductName();
    }

    @JsonProperty
    public String getOptions() {
        return row.getOptions();
    }

    @JsonProperty
    public Short getTableNo() {
        return row.getTableNo();
    }

    @JsonProperty
    public Short getQuantity() {
        return row.getQuantity();
    }

    @JsonProperty
    public Date getOrderDate() {
        return row.getOrderDate();
    }

    @JsonProperty
    public Time getOrderTime() {
        return row.getOrderTime();
    }

    @JsonProperty
    public String getDateTime() {
        LocalDateTime dateTime = row.getDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime != null ? dateTime.format(formatter) : null;
    }

    @JsonProperty
    public String getRobotStatus() {
        return row.getRobotStatus();
    }

    @JsonProperty
    public String getDong() {
        return row.getDong();
    }

    @JsonProperty
    public String getHo() {
        return row.getHo();
    }

    @JsonProperty
    public String getSeq() {
        return row.getSeq();
    }

    @JsonProperty
    public String getOrdererName() {
        return row.getOrdererName();
    }
}
