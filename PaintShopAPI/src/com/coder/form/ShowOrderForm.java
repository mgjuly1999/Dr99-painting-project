package com.coder.form;

import com.coder.model.DeliveryAddress;
import com.coder.model.DeliveryType;
import com.coder.model.OrderForm;
import com.coder.model.OrderStatus;
import com.coder.model.PaymentMethod;

public class ShowOrderForm {
private OrderForm orderForm;
private DeliveryAddress deliveryAddress;
private OrderStatus orderStatus;
private DeliveryType deliveryType;
private PaymentMethod paymentMethod;
public OrderForm getOrderForm() {
	return orderForm;
}
public void setOrderForm(OrderForm orderForm) {
	this.orderForm = orderForm;
}
public DeliveryAddress getDeliveryAddress() {
	return deliveryAddress;
}
public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
	this.deliveryAddress = deliveryAddress;
}
public OrderStatus getOrderStatus() {
	return orderStatus;
}
public void setOrderStatus(OrderStatus orderStatus) {
	this.orderStatus = orderStatus;
}
public DeliveryType getDeliveryType() {
	return deliveryType;
}
public void setDeliveryType(DeliveryType deliveryType) {
	this.deliveryType = deliveryType;
}
public PaymentMethod getPaymentMethod() {
	return paymentMethod;
}
public void setPaymentMethod(PaymentMethod paymentMethod) {
	this.paymentMethod = paymentMethod;
}
}
