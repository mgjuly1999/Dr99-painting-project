package com.coder.apiForm;

import com.coder.form.MakePaymentForm;

public class CheckOutAPIForm {
private String deliveryAddressId;
private	MakePaymentForm makePaymentForm;

public MakePaymentForm getMakePaymentForm() {
	return makePaymentForm;
}

public void setMakePaymentForm(MakePaymentForm makePaymentForm) {
	this.makePaymentForm = makePaymentForm;
}

public String getDeliveryAddressId() {
	return deliveryAddressId;
}

public void setDeliveryAddressId(String deliveryAddressId) {
	this.deliveryAddressId = deliveryAddressId;
}



}
