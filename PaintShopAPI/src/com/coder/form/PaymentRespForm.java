package com.coder.form;

public class PaymentRespForm {
	
private String respCode;
private String respDesc;

public String getRespCode() {
	return respCode;
}
public void setRespCode(String respCode) {
	this.respCode = respCode;
}
public String getRespDesc() {
	return respDesc;
}
public void setRespDesc(String respDesc) {
	this.respDesc = respDesc;
}
@Override
public String toString() {
	return "PaymentRespForm [respCode=" + respCode + ", respDesc=" + respDesc + "]";
}
}
