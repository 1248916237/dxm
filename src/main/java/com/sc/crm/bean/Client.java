package com.sc.crm.bean;

public class Client {
    private Integer clientId;

    private String clientName;

    private String clientSex;

    private String clientAge;

    private String clientPhone;

    private String clientAddress;

    private Integer clientState;

    private Integer userId;

    private String clientCard;

    private String cardKind;
    
    private ClientLoss lossC;

    public ClientLoss getLossC() {
		return lossC;
	}

	public void setLossC(ClientLoss lossC) {
		this.lossC = lossC;
	}

	public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName == null ? null : clientName.trim();
    }

    public String getClientSex() {
        return clientSex;
    }

    public void setClientSex(String clientSex) {
        this.clientSex = clientSex == null ? null : clientSex.trim();
    }

    public String getClientAge() {
        return clientAge;
    }

    public void setClientAge(String clientAge) {
        this.clientAge = clientAge == null ? null : clientAge.trim();
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone == null ? null : clientPhone.trim();
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress == null ? null : clientAddress.trim();
    }

    public Integer getClientState() {
        return clientState;
    }

    public void setClientState(Integer clientState) {
        this.clientState = clientState;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getClientCard() {
        return clientCard;
    }

    public void setClientCard(String clientCard) {
        this.clientCard = clientCard == null ? null : clientCard.trim();
    }

    public String getCardKind() {
        return cardKind;
    }

    public void setCardKind(String cardKind) {
        this.cardKind = cardKind == null ? null : cardKind.trim();
    }
}