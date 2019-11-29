package com.sc.crm.bean;

import java.util.List;

public class PurchaseInfo {

	private Integer userId;
	
	private List<PurchaseMaterial> purMaterialList;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<PurchaseMaterial> getPurMaterialList() {
		return purMaterialList;
	}

	public void setPurMaterialList(List<PurchaseMaterial> purMaterialList) {
		this.purMaterialList = purMaterialList;
	}

	
}
