package com.coder.form;

import com.coder.form.DirectPaymentAPIForm;
import com.coder.form.DirectPaymentAPIRespForm;
import com.coder.form.VerifyPhoneNumberForm;
import com.coder.form.VerifyPhoneNumberRespForm;
import com.coder.model.OnePayPaymentMethod;


public class DirectPaymentAPIPrepareForm {
private VerifyPhoneNumberForm verifyPhoneNumberForm;
private DirectPaymentAPIForm directPaymentAPIForm;
private VerifyPhoneNumberRespForm verifyPhoneNumberRespForm;
private DirectPaymentAPIRespForm directPaymentAPIRespForm;
private OnePayPaymentMethod onePayPaymentMethod;


public void setDirectPaymentAPIForm(DirectPaymentAPIForm directPaymentAPIForm) {
	this.directPaymentAPIForm = directPaymentAPIForm;
}

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

public DirectPaymentAPIRespForm getDirectPaymentAPIRespForm() {
	return directPaymentAPIRespForm;
}

public void setDirectPaymentAPIRespForm(DirectPaymentAPIRespForm directPaymentAPIRespForm) {
	this.directPaymentAPIRespForm = directPaymentAPIRespForm;
}

public OnePayPaymentMethod getOnePayPaymentMethod() {
	return onePayPaymentMethod;
}

public void setOnePayPaymentMethod(OnePayPaymentMethod onePayPaymentMethod) {
	this.onePayPaymentMethod = onePayPaymentMethod;
}

public DirectPaymentAPIForm getDirectPaymentAPIForm() {
	return directPaymentAPIForm;
}


}
