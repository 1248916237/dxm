package com.sc.crm.bean;

public class PurchaseMaterial {
    private Integer purchaseMaterialId;

    private Integer purchaseId;

    private Integer materialId;

    private Integer materialNum;

    private Integer materialSupplierId;
    
    private Material material;
    
    public Integer getPurchaseMaterialId() {
        return purchaseMaterialId;
    }

    public void setPurchaseMaterialId(Integer purchaseMaterialId) {
        this.purchaseMaterialId = purchaseMaterialId;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Integer getMaterialNum() {
        return materialNum;
    }

    public void setMaterialNum(Integer materialNum) {
        this.materialNum = materialNum;
    }

    public Integer getMaterialSupplierId() {
        return materialSupplierId;
    }

    public void setMaterialSupplierId(Integer materialSupplierId) {
        this.materialSupplierId = materialSupplierId;
    }

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
    
}