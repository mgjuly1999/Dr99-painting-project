package com.coder.form;

public class DirectPaymentAPIForm {


		 
		private String Version;
		private String Channel;
		private String MerchantUserId;
		private String InvoiceNo;
		private String SequenceNo;
		private String Amount;
		private String Remark;
		private String WalletUserID;
		private String CallBackUrl;
		private String ExpiredSeconds;
		private String HashValue;
		
		public String getVersion() {
			return Version;
		}
		public void setVersion(String version) {
			Version = version;
		}
		public String getChannel() {
			return Channel;
		}
		public void setChannel(String channel) {
			Channel = channel;
		}
		public String getMerchantUserId() {
			return MerchantUserId;
		}
		public void setMerchantUserId(String merchantUserId) {
			MerchantUserId = merchantUserId;
		}
		public String getInvoiceNo() {
			return InvoiceNo;
		}
		public void setInvoiceNo(String invoiceNo) {
			InvoiceNo = invoiceNo;
		}
		public String getSequenceNo() {
			return SequenceNo;
		}
		public void setSequenceNo(String sequenceNo) {
			SequenceNo = sequenceNo;
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
		public String getWalletUserID() {
			return WalletUserID;
		}
		public void setWalletUserID(String walletUserID) {
			WalletUserID = walletUserID;
		}
		public String getCallBackUrl() {
			return CallBackUrl;
		}
		public void setCallBackUrl(String callBackUrl) {
			CallBackUrl = callBackUrl;
		}
		public String getExpiredSeconds() {
			return ExpiredSeconds;
		}
		@Override
		public String toString() {
			return "DirectPaymentAPIForm [Version=" + Version + ", Channel=" + Channel + ", MerchantUserId="
					+ MerchantUserId + ", InvoiceNo=" + InvoiceNo + ", SequenceNo=" + SequenceNo + ", Amount=" + Amount
					+ ", Remark=" + Remark + ", WalletUserID=" + WalletUserID + ", CallBackUrl=" + CallBackUrl
					+ ", ExpiredSeconds=" + ExpiredSeconds + ", HashValue=" + HashValue + "]";
		}
		public void setExpiredSeconds(String expiredSeconds) {
			ExpiredSeconds = expiredSeconds;
		}
		public String getHashValue() {
			return HashValue;
		}
		public void setHashValue(String hashValue) {
			HashValue = hashValue;
		}
		
 
		
	
}
