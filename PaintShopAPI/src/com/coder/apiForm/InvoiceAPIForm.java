package com.coder.apiForm;

import java.util.ArrayList;
import java.util.List;

public class InvoiceAPIForm {
private String invoiceId;
private String customer;
private String deliveryAddress;
private String deliveryCharge;
private String deliveryTownship;
private String deliveryType;
private String orderStatus;
private String paymentDue;
private String phone;
private String taxRate;
private String totalDiscountRate;
private String totalPrice;
private String subSubTotal;
private List<InvoiceItemAPIForm> invoiceItemAPIForms=new ArrayList<InvoiceItemAPIForm>(0);

public String getInvoiceId() {
	return invoiceId;
}
public void setInvoiceId(String invoiceId) {
	this.invoiceId = invoiceId;
}
public String getDeliveryAddress() {
	return deliveryAddress;
}
public void setDeliveryAddress(String deliveryAddress) {
	this.deliveryAddress = deliveryAddress;
}
public String getDeliveryCharge() {
	return deliveryCharge;
}
public void setDeliveryCharge(String deliveryCharge) {
	this.deliveryCharge = deliveryCharge;
}
public String getDeliveryTownship() {
	return deliveryTownship;
}
public void setDeliveryTownship(String deliveryTownship) {
	this.deliveryTownship = deliveryTownship;
}
public String getDeliveryType() {
	return deliveryType;
}
public void setDeliveryType(String deliveryType) {
	this.deliveryType = deliveryType;
}
public String getOrderStatus() {
	return orderStatus;
}
public void setOrderStatus(String orderStatus) {
	this.orderStatus = orderStatus;
}
public String getPaymentDue() {
	return paymentDue;
}
public void setPaymentDue(String paymentDue) {
	this.paymentDue = paymentDue;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getTaxRate() {
	return taxRate;
}
public String getCustomer() {
	return customer;
}
public void setCustomer(String customer) {
	this.customer = customer;
}
public String getSubSubTotal() {
	return subSubTotal;
}
public void setSubSubTotal(String subSubTotal) {
	this.subSubTotal = subSubTotal;
}
public void setTaxRate(String taxRate) {
	this.taxRate = taxRate;
}
public String getTotalDiscountRate() {
	return totalDiscountRate;
}
public void setTotalDiscountRate(String totalDiscountRate) {
	this.totalDiscountRate = totalDiscountRate;
}
public String getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(String totalPrice) {
	this.totalPrice = totalPrice;
}
public List<InvoiceItemAPIForm> getInvoiceItemAPIForms() {
	return invoiceItemAPIForms;
}
public void setInvoiceItemAPIForms(List<InvoiceItemAPIForm> invoiceItemAPIForms) {
	this.invoiceItemAPIForms = invoiceItemAPIForms;
}


}
