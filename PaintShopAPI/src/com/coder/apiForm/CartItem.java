package com.coder.apiForm;

public class CartItem {
	
private String orderLineId;
private String productId;
private String productName;
private String unitPrice;
private String qty;
private String colorId;
private String color;
private String litreageId;
private String litreage;
private String imageUrl;

public String getOrderLineId() {
	return orderLineId;
}
public void setOrderLineId(String orderLineId) {
	this.orderLineId = orderLineId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getUnitPrice() {
	return unitPrice;
}
public void setUnitPrice(String unitPrice) {
	this.unitPrice = unitPrice;
}
public String getQty() {
	return qty;
}
public void setQty(String qty) {
	this.qty = qty;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}
public String getColorId() {
	return colorId;
}
public void setColorId(String colorId) {
	this.colorId = colorId;
}
public String getLitreageId() {
	return litreageId;
}
public void setLitreageId(String litreageId) {
	this.litreageId = litreageId;
}
public String getLitreage() {
	return litreage;
}
public void setLitreage(String litreage) {
	this.litreage = litreage;
}
public String getImageUrl() {
	return imageUrl;
}
public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}

}
