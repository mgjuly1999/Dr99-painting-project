package com.coder.form;

public class VerifyPhoneNumberForm {
	
	private	String channel;
	private	String hashValue;
	private	String merchantUserId;
	private	String onepayPhoneNo;
	private String amount;
	private String invoiceNo;
	
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getHashValue() {
		return hashValue;
	}
	public void setHashValue(String hashValue) {
		this.hashValue = hashValue;
	}
	public String getMerchantUserId() {
		return merchantUserId;
	}
	public void setMerchantUserId(String merchantUserId) {
		this.merchantUserId = merchantUserId;
	}
	public String getOnepayPhoneNo() {
		return onepayPhoneNo;
	}
	public void setOnepayPhoneNo(String onepayPhoneNo) {
		this.onepayPhoneNo = onepayPhoneNo;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	@Override
	public String toString() {
		return "VerifyPhoneNumberForm [channel=" + channel + ", hashValue=" + hashValue + ", merchantUserId="
				+ merchantUserId + ", onepayPhoneNo=" + onepayPhoneNo + ", amount=" + amount + ", invoiceNo="
				+ invoiceNo + "]";
	}
	
	
	
		
}
