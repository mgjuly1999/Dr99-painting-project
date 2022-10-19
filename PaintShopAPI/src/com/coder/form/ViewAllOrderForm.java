package com.coder.form;

import java.util.List;

import com.coder.model.OrderForm;

public class ViewAllOrderForm {
private List<OrderHistory>  orderHistory;

public List<OrderHistory> getOrderHistory() {
	return orderHistory;
}

public void setOrderHistory(List<OrderHistory> orderHistory) {
	this.orderHistory = orderHistory;
}
}
