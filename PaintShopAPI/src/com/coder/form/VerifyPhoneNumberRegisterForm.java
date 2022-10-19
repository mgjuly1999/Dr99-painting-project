package com.coder.form;

import com.coder.form.VerifyPhoneNumberForm;
import com.coder.form.VerifyPhoneNumberRespForm;
import com.coder.model.OnePayPaymentMethod;
import com.coder.model.PaymentMethod;

public class VerifyPhoneNumberRegisterForm {
	
private VerifyPhoneNumberRespForm verifyPhoneNumberRespForm;
private VerifyPhoneNumberForm  verifyPhoneNumberForm;
private OnePayPaymentMethod onePayPaymentMethod;
private String errorMSG;


public VerifyPhoneNumberRespForm getVerifyPhoneNumberRespForm() {
	return verifyPhoneNumberRespForm;
}
public void setVerifyPhoneNumberRespForm(VerifyPhoneNumberRespForm verifyPhoneNumberRespForm) {
	this.verifyPhoneNumberRespForm = verifyPhoneNumberRespForm;
}
public VerifyPhoneNumberForm getVerifyPhoneNumberForm() {
	return verifyPhoneNumberForm;
}
public void setVerifyPhoneNumberForm(VerifyPhoneNumberForm verifyPhoneNumberForm) {
	this.verifyPhoneNumberForm = verifyPhoneNumberForm;
}
public String getErrorMSG() {
	return errorMSG;
}
public OnePayPaymentMethod getOnePayPaymentMethod() {
	return onePayPaymentMethod;
}
public void setOnePayPaymentMethod(OnePayPaymentMethod onePayPaymentMethod) {
	this.onePayPaymentMethod = onePayPaymentMethod;
}
public void setErrorMSG(String errorMSG) {
	this.errorMSG = errorMSG;
}
}
