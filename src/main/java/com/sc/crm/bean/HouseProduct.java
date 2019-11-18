package com.sc.crm.bean;

public class HouseProduct {
    private Integer houseProductId;

    private Integer productId;

    private Integer houseId;

    private Integer productNum;

    private Integer houseProductState;
    
    private Product product;

	/**
	 * @return the houseProductId
	 */
	public Integer getHouseProductId() {
		return houseProductId;
	}

	/**
	 * @param houseProductId the houseProductId to set
	 */
	public void setHouseProductId(Integer houseProductId) {
		this.houseProductId = houseProductId;
	}

	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * @return the houseId
	 */
	public Integer getHouseId() {
		return houseId;
	}

	/**
	 * @param houseId the houseId to set
	 */
	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	/**
	 * @return the productNum
	 */
	public Integer getProductNum() {
		return productNum;
	}

	/**
	 * @param productNum the productNum to set
	 */
	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}

	/**
	 * @return the houseProductState
	 */
	public Integer getHouseProductState() {
		return houseProductState;
	}

	/**
	 * @param houseProductState the houseProductState to set
	 */
	public void setHouseProductState(Integer houseProductState) {
		this.houseProductState = houseProductState;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HouseProduct [houseProductId=" + houseProductId + ", productId=" + productId + ", houseId=" + houseId
				+ ", productNum=" + productNum + ", houseProductState=" + houseProductState + ", product=" + product
				+ "]";
	}

	
}