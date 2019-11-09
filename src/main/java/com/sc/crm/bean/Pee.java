package com.sc.crm.bean;

public class Pee {
    private Integer perId;

    private String perName;

    private String perType;

    private String perUrl;

    private String perCode;

    private Integer perParentid;

    private String perParentids;

    private String perSotr;
    

	@Override
	public String toString() {
		return "Pee [perId=" + perId + ", perName=" + perName + ", perType=" + perType + ", perUrl=" + perUrl
				+ ", perCode=" + perCode + ", perParentid=" + perParentid + ", perParentids=" + perParentids
				+ ", perSotr=" + perSotr + "]";
	}

	public Integer getPerId() {
		return perId;
	}

	public void setPerId(Integer perId) {
		this.perId = perId;
	}

	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	public String getPerType() {
		return perType;
	}

	public void setPerType(String perType) {
		this.perType = perType;
	}

	public String getPerUrl() {
		return perUrl;
	}

	public void setPerUrl(String perUrl) {
		this.perUrl = perUrl;
	}

	public String getPerCode() {
		return perCode;
	}

	public void setPerCode(String perCode) {
		this.perCode = perCode;
	}

	public Integer getPerParentid() {
		return perParentid;
	}

	public void setPerParentid(Integer perParentid) {
		this.perParentid = perParentid;
	}

	public String getPerParentids() {
		return perParentids;
	}

	public void setPerParentids(String perParentids) {
		this.perParentids = perParentids;
	}

	public String getPerSotr() {
		return perSotr;
	}

	public void setPerSotr(String perSotr) {
		this.perSotr = perSotr;
	}
    
    
}