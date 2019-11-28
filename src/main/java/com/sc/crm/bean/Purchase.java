package com.sc.crm.bean;

import java.util.Date;
import java.util.List;

public class Purchase {
    private Integer purchaseId;

    private Integer userId;

    private Date purchaseDate;

    private Integer purchaseState;
    
    private List<Material> materialList;
    
    

    @Override
	public String toString() {
		return "Purchase [purchaseId=" + purchaseId + ", userId=" + userId + ", purchaseDate=" + purchaseDate
				+ ", purchaseState=" + purchaseState + ", materialList=" + materialList + "]";
	}

	public List<Material> getMaterialList() {
		return materialList;
	}

	public void setMaterialList(List<Material> materialList) {
		this.materialList = materialList;
	}

	public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Integer getPurchaseState() {
        return purchaseState;
    }

    public void setPurchaseState(Integer purchaseState) {
        this.purchaseState = purchaseState;
    }
}