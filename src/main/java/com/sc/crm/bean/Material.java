package com.sc.crm.bean;

public class Material {
    private Integer materialId;

    private String materialName;

    private String materialIntro;

    private Integer houseId;

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

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }
}