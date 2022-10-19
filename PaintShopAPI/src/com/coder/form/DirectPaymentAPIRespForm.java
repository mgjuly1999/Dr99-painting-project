package com.coder.form;

public class DirectPaymentAPIRespForm {

	private	String  Channel;
	private	String  ReferIntegrationId;
	private	String  MerchantUserId;
	private	String  Amount;
	private	String  Remark;
	private	String  RespDescription;
	private	String  RespCode;
	private	String  HashValue;
	 
	public String getChannel() {
		return Channel;
	}
	public void setChannel(String channel) {
		Channel = channel;
	}
	public String getReferIntegrationId() {
		return ReferIntegrationId;
	}
	public void setReferIntegrationId(String referIntegrationId) {
		ReferIntegrationId = referIntegrationId;
	}
	public String getMerchantUserId() {
		return MerchantUserId;
	}
	public void setMerchantUserId(String merchantUserId) {
		MerchantUserId = merchantUserId;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public String getRespDescription() {
		return RespDescription;
	}
	public void setRespDescription(String respDescription) {
		RespDescription = respDescription;
	}
	public String getRespCode() {
		return RespCode;
	}
	public void setRespCode(String respCode) {
		RespCode = respCode;
	}
	public String getHashValue() {
		return HashValue;
	}
	public void setHashValue(String hashValue) {
		HashValue = hashValue;
	}
	@Override
	public String toString() {
		return "DirectPaymentAPIRespForm [Channel=" + Channel + ", ReferIntegrationId=" + ReferIntegrationId
				+ ", MerchantUserId=" + MerchantUserId + ", Amount=" + Amount + ", Remark=" + Remark
				+ ", RespDescription=" + RespDescription + ", RespCode=" + RespCode + ", HashValue=" + HashValue + "]";
	}
	
}
