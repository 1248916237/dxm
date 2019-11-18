package com.sc.crm.bean;

public class Supplier {
    private Integer supplierId;

    private String supplierName;

    private String supplierAddress;

    private String supplierKind;

    private String supplierPhone;

    private String supplierCard;

    private String cardKind;

    @Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", supplierAddress="
				+ supplierAddress + ", supplierKind=" + supplierKind + ", supplierPhone=" + supplierPhone
				+ ", supplierCard=" + supplierCard + ", cardKind=" + cardKind + "]";
	}

	public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress == null ? null : supplierAddress.trim();
    }

    public String getSupplierKind() {
        return supplierKind;
    }

    public void setSupplierKind(String supplierKind) {
        this.supplierKind = supplierKind == null ? null : supplierKind.trim();
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone == null ? null : supplierPhone.trim();
    }

    public String getSupplierCard() {
        return supplierCard;
    }

    public void setSupplierCard(String supplierCard) {
        this.supplierCard = supplierCard == null ? null : supplierCard.trim();
    }

    public String getCardKind() {
        return cardKind;
    }

    public void setCardKind(String cardKind) {
        this.cardKind = cardKind == null ? null : cardKind.trim();
    }
}