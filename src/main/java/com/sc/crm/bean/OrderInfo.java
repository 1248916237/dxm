package com.sc.crm.bean;

import java.util.List;

public class OrderInfo {
	
	private String id;
	private Integer clientId;
	private Integer orderState;
	private Integer orderPayment;
	public Integer getOrderPayment() {
		return orderPayment;
	}
	public void setOrderPayment(Integer orderPayment) {
		this.orderPayment = orderPayment;
	}
	private String orderWay;
	private List<OrderProduct> orderProductList;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public Integer getOrderState() {
		return orderState;
	}
	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}
	public String getOrderWay() {
		return orderWay;
	}
	public void setOrderWay(String orderWay) {
		this.orderWay = orderWay;
	}
	public List<OrderProduct> getOrderProductList() {
		return orderProductList;
	}
	public void setOrderProductList(List<OrderProduct> orderProductList) {
		this.orderProductList = orderProductList;
	}
	
	
}
