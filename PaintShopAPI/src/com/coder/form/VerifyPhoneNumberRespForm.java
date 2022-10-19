package com.coder.form;

import com.coder.model.PaymentMethod;

public class VerifyPhoneNumberRespForm 
	{	
	
		private String RespDescription;
		private String RespCode;
		private String HashValue;
		
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
			return "VerifyPhoneNumberRespForm [RespDescription=" + RespDescription + ", RespCode=" + RespCode
					+ ", HashValue=" + HashValue + "]";
		}
	}
