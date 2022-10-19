package com.coder.form;

public class MakePaymentForm {

private String channel;
private String merchantUserId;
private String invoiceId;
private String orderId;
private String amount;
private String phone;
private String address;

public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getChannel() {
	return channel;
}
public void setChannel(String channel) {
	this.channel = channel;
}
public String getMerchantUserId() {
	return merchantUserId;
}
public void setMerchantUserId(String merchantUserId) {
	this.merchantUserId = merchantUserId;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getInvoiceId() {
	return invoiceId;
}
public void setInvoiceId(String invoiceId) {
	this.invoiceId = invoiceId;
}
public String getAmount() {
	return amount;
}
public void setAmount(String amount) {
	this.amount = amount;
}
public String getOrderId() {
	return orderId;
}
public void setOrderId(String orderId) {
	this.orderId = orderId;
}



}
