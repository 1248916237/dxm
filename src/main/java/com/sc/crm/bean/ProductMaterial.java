package com.sc.crm.bean;

public class ProductMaterial {
    private Integer productMaterialId;

    private Integer productId;

    private Integer materialId;

    private Integer materialNumber;

    public Integer getProductMaterialId() {
        return productMaterialId;
    }

    public void setProductMaterialId(Integer productMaterialId) {
        this.productMaterialId = productMaterialId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Integer getMaterialNumber() {
        return materialNumber;
    }

    public void setMaterialNumber(Integer materialNumber) {
        this.materialNumber = materialNumber;
    }
}