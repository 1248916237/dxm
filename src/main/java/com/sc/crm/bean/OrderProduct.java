package com.sc.crm.bean;

public class OrderProduct {
    private Integer orderProductId;

    private String orderId;

    private Integer productId;

    private Integer productNum;

    private Long productPrice;
    
    private Product proDuc;

    public Product getProDuc() {
		return proDuc;
	}

	public void setProDuc(Product proDuc) {
		this.proDuc = proDuc;
	}

	public Integer getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(Integer orderProductId) {
        this.orderProductId = orderProductId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }
}