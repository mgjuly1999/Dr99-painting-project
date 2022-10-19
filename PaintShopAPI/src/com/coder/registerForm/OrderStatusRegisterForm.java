package com.coder.registerForm;

import java.util.List;

import com.coder.form.OrderStatusForm;
import com.coder.model.OrderStatus;

public class OrderStatusRegisterForm {
private OrderStatusForm orderStatusForm;
private List<OrderStatus> orderStatuss;
public OrderStatusForm getOrderStatusForm() {
	return orderStatusForm;
}

public List<OrderStatus> getOrderStatuss() {
	return orderStatuss;
}

public void setOrderStatuss(List<OrderStatus> orderStatuss) {
	this.orderStatuss = orderStatuss;
}

public void setOrderStatusForm(OrderStatusForm orderStatusForm) {
	this.orderStatusForm = orderStatusForm;
}
}
