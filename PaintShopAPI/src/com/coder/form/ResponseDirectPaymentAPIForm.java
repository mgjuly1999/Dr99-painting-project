package com.coder.form;

public class ResponseDirectPaymentAPIForm {

	private String MerchantUserId;
	private String Amount;
	private String ReferIntegrationId;
	private String InvoiceNo;
	private String TransactionStatus;
	private String TransactionID;
	private String HashValue;
	
	
	public String getMerchantUserId() {
		return MerchantUserId;
	}
	public void setMerchantUserId(String MerchantUserId) {
		this.MerchantUserId = MerchantUserId;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String Amount) {
		this.Amount = Amount;
	}
	public String getReferIntegrationId() {
		return ReferIntegrationId;
	}
	public void setReferIntegrationId(String ReferIntegrationId) {
		this.ReferIntegrationId = ReferIntegrationId;
	}
	public String getInvoiceNo() {
		return InvoiceNo;
	}
	public void setInvoiceNo(String InvoiceNo) {
		this.InvoiceNo = InvoiceNo;
	}
	public String getTransactionStatus() {
		return TransactionStatus;
	}
	public void setTransactionStatus(String TransactionStatus) {
		this.TransactionStatus = TransactionStatus;
	}
	public String getTransactionID() {
		return TransactionID;
	}
	public void setTransactionID(String TransactionID) {
		this.TransactionID = TransactionID;
	}
	public String getHashValue() {
		return HashValue;
	}
	public void setHashValue(String HashValue) {
		this.HashValue = HashValue;
	}
	
	@Override
	public String toString() {
		return "ResponseDirectPaymentAPIForm [MerchantUserId=" + MerchantUserId + ", Amount=" + Amount
				+ ", ReferIntegrationId=" + ReferIntegrationId + ", InvoiceNo=" + InvoiceNo + ", TransactionStatus="
				+ TransactionStatus + ", TransactionID=" + TransactionID + ", HashValue=" + HashValue + "]";
	}

	
	
	
}
