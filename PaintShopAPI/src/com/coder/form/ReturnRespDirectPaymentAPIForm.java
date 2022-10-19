package com.coder.form;

import org.codehaus.jettison.json.JSONObject;

import com.google.gson.JsonObject;

public class ReturnRespDirectPaymentAPIForm {

	private String ReferIntegrationId;
	private String DataType;
	private String ConfrimationUrl;
	private String ItemListJsonStr;
	private String RespDescription;
	private String RespCode;
	private String HashValue;
	
	public String getReferIntegrationId() {
		return ReferIntegrationId;
	}
	public void setReferIntegrationId(String referIntegrationId) {
		ReferIntegrationId = referIntegrationId;
	}
	public String getDataType() {
		return DataType;
	}
	public void setDataType(String dataType) {
		DataType = dataType;
	}
	public String getConfrimationUrl() {
		return ConfrimationUrl;
	}
	public void setConfrimationUrl(String confrimationUrl) {
		ConfrimationUrl = confrimationUrl;
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
	
	public String getItemListJsonStr() {
		return ItemListJsonStr;
	}
	public void setItemListJsonStr(String itemListJsonStr) {
		ItemListJsonStr = itemListJsonStr;
	}
	public void setHashValue(String hashValue) {
		HashValue = hashValue;
	}

	
	
	
		
	
}
