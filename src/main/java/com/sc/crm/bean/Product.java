package com.sc.crm.bean;

import java.util.List;

public class Product {
    private Integer productId;

    private String productNumber;

    private String productName;

    private Long productPrice;

	private Integer productState;

    private String productIntro;

    private Integer houseId;
    
    private List<ProductMaterial> productmaterial;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber == null ? null : productNumber.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductState() {
        return productState;
    }

    public void setProductState(Integer productState) {
        this.productState = productState;
    }

    public String getProductIntro() {
        return productIntro;
    }

    public void setProductIntro(String productIntro) {
        this.productIntro = productIntro == null ? null : productIntro.trim();
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }
    /**
	 * @return the productmaterial
	 */
	public List<ProductMaterial> getProductmaterial() {
		return productmaterial;
	}

	/**
	 * @param productmaterial the productmaterial to set
	 */
	public void setProductmaterial(List<ProductMaterial> productmaterial) {
		this.productmaterial = productmaterial;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productNumber=" + productNumber + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", productState=" + productState + ", productIntro=" + productIntro
				+ ", houseId=" + houseId + "]";
	}
	
	
}