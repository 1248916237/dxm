package com.sc.crm.bean;

public class ClientLoss {
    private Integer lossId;

    private Integer clientId;

    private String lossReason;

    private String lossRemedy;

    private String lossResult;

    public Integer getLossId() {
        return lossId;
    }

    public void setLossId(Integer lossId) {
        this.lossId = lossId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getLossReason() {
        return lossReason;
    }

    public void setLossReason(String lossReason) {
        this.lossReason = lossReason == null ? null : lossReason.trim();
    }

    public String getLossRemedy() {
        return lossRemedy;
    }

    public void setLossRemedy(String lossRemedy) {
        this.lossRemedy = lossRemedy == null ? null : lossRemedy.trim();
    }

    public String getLossResult() {
        return lossResult;
    }

    public void setLossResult(String lossResult) {
        this.lossResult = lossResult == null ? null : lossResult.trim();
    }
}