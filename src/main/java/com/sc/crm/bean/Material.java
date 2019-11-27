package com.sc.crm.bean;

public class Material {
    private Integer materialId;

    private String materialName;

    private String materialIntro;

    private Integer materialNum;

    private Long materialPrice;

    private Integer houseId;
    
    private Supplier supplier;

    @Override
	public String toString() {
		return "Material [materialId=" + materialId + ", materialName=" + materialName + ", materialIntro="
				+ materialIntro + ", materialNum=" + materialNum + ", materialPrice=" + materialPrice + ", houseId="
				+ houseId + "]";
	}

	public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getMaterialIntro() {
        return materialIntro;
    }

    public void setMaterialIntro(String materialIntro) {
        this.materialIntro = materialIntro == null ? null : materialIntro.trim();
    }

    public Integer getMaterialNum() {
        return materialNum;
    }

    public void setMaterialNum(Integer materialNum) {
        this.materialNum = materialNum;
    }

    public Long getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(Long materialPrice) {
        this.materialPrice = materialPrice;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
    
    
}