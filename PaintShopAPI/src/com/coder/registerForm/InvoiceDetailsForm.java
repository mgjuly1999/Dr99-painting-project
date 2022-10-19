package com.coder.registerForm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.coder.apiForm.OrderItem;
import com.coder.model.DeliveryAddress;
import com.coder.model.DeliveryType;
import com.coder.model.OrderForm;
import com.coder.model.OrderStatus;
import com.coder.model.PaymentMethod;

public class InvoiceDetailsForm {

private String orderFormId;
private String deliveryAddress;
private String addressDetails;
private String deliveryType;
private String orderStatus;
private String paymentDue;
private String phone;
private String totalDicountRate;
private String totalPrice;
private String note;
private String currentDate=new Date().toString();
private List<OrderItem> orderItems=new ArrayList<>(0);


public String getOrderFormId() {
	return orderFormId;
}
public void setOrderFormId(String orderFormId) {
	this.orderFormId = orderFormId;
}
public String getDeliveryAddress() {
	return deliveryAddress;
}
public void setDeliveryAddress(String deliveryAddress) {
	this.deliveryAddress = deliveryAddress;
}
public String getAddressDetails() {
	return addressDetails;
}
public void setAddressDetails(String addressDetails) {
	this.addressDetails = addressDetails;
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
public String getTotalDicountRate() {
	return totalDicountRate;
}
public void setTotalDicountRate(String totalDicountRate) {
	this.totalDicountRate = totalDicountRate;
}
public String getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(String totalPrice) {
	this.totalPrice = totalPrice;
}
public String getNote() {
	return note;
}
public void setNote(String note) {
	this.note = note;
}

public List<OrderItem> getOrderItems() {
	return orderItems;
}
public void setOrderItems(List<OrderItem> orderItems) {
	this.orderItems = orderItems;
}
public String getCurrentDate() {
	return currentDate;
}
public void setCurrentDate(String currentDate) {
	this.currentDate = currentDate;
}




	

}
