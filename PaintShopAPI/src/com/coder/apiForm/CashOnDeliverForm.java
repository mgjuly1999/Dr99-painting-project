package com.coder.apiForm;

import java.util.Arrays;

public class CashOnDeliverForm {
	

private String invoiceId;
private String phone;
private String address;
private String deliveryAddressId;



public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getDeliveryAddressId() {
	return deliveryAddressId;
}

public void setDeliveryAddressId(String deliveryAddressId) {
	this.deliveryAddressId = deliveryAddressId;
}

public String getInvoiceId() {
	return invoiceId;
}

public void setInvoiceId(String invoiceId) {
	this.invoiceId = invoiceId;
}




}
