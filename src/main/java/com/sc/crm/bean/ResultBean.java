package com.sc.crm.bean;

public class ResultBean {
	
	private Integer resultState;
	
	private String resultMsg;
	
	

	@Override
	public String toString() {
		return "ResultBean [resultState=" + resultState + ", resultMsg=" + resultMsg + "]";
	}

	public Integer getResultState() {
		return resultState;
	}

	public void setResultState(Integer resultState) {
		this.resultState = resultState;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	

}
