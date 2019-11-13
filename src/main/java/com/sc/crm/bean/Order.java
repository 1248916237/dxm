package com.sc.crm.bean;

import java.util.Date;

public class Order {
    private String orderId;

    private Date orderDate;

    private Integer userId;

    private String orderWay;

    private Integer clientId;

    private Integer orderPayment;

    private Integer orderState;

    private Long orderAllPrice;

    private Date payDate;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderWay() {
        return orderWay;
    }

    public void setOrderWay(String orderWay) {
        this.orderWay = orderWay == null ? null : orderWay.trim();
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getOrderPayment() {
        return orderPayment;
    }

    public void setOrderPayment(Integer orderPayment) {
        this.orderPayment = orderPayment;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Long getOrderAllPrice() {
        return orderAllPrice;
    }

    public void setOrderAllPrice(Long orderAllPrice) {
        this.orderAllPrice = orderAllPrice;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
}