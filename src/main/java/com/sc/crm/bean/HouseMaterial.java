package com.sc.crm.bean;

public class HouseMaterial {
    private Integer houseMaterialId;

    private Integer materialId;

    private Integer materialNumber;

    private String materialState;

    private Integer houseId;
    
    private Material material;

    /**
	 * @return the material
	 */
	public Material getMaterial() {
		return material;
	}

	/**
	 * @param material the material to set
	 */
	public void setMaterial(Material material) {
		this.material = material;
	}

	public Integer getHouseMaterialId() {
        return houseMaterialId;
    }

    public void setHouseMaterialId(Integer houseMaterialId) {
        this.houseMaterialId = houseMaterialId;
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

    public String getMaterialState() {
        return materialState;
    }

    public void setMaterialState(String materialState) {
        this.materialState = materialState == null ? null : materialState.trim();
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HouseMaterial [houseMaterialId=" + houseMaterialId + ", materialId=" + materialId + ", materialNumber="
				+ materialNumber + ", materialState=" + materialState + ", houseId=" + houseId + ", material="
				+ material + "]";
	}
    
    
}