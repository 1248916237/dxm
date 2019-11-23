package com.sc.crm.bean;

public class Material {
    private Integer materialId;

    private Integer houseId;


	private String materialName;

    private String materialIntro;

    private Integer materialState;

    private Integer materialNum;
    
    private Long materialPrice;
    
    		
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

    public Integer getMaterialState() {
        return materialState;
    }

    public void setMaterialState(Integer materialState) {
        this.materialState = materialState;
    }

    /**
	 * @return the materialNum
	 */
	public Integer getMaterialNum() {
		return materialNum;
	}

	/**
	 * @param materialNum the materialNum to set
	 */
	public void setMaterialNum(Integer materialNum) {
		this.materialNum = materialNum;
	}

	/**
	 * @return the materialPrice
	 */
	public Long getMaterialPrice() {
		return materialPrice;
	}

	/**
	 * @param materialPrice the materialPrice to set
	 */
	public void setMaterialPrice(Long materialPrice) {
		this.materialPrice = materialPrice;
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

}