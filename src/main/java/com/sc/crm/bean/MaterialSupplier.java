package com.sc.crm.bean;

public class MaterialSupplier {
    private Integer materialSupplierId;

    private Integer materialId;

    private Integer supplierId;

    private Long materialPrice;

    public Integer getMaterialSupplierId() {
        return materialSupplierId;
    }

    public void setMaterialSupplierId(Integer materialSupplierId) {
        this.materialSupplierId = materialSupplierId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Long getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(Long materialPrice) {
        this.materialPrice = materialPrice;
    }

    
}