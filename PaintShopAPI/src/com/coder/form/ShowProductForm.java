package com.coder.form;

import com.coder.model.GroupLanguage;
import com.coder.model.Product;
import com.coder.model.ProductTitleLanguage;
import com.coder.model.QtyUnit;
import com.coder.model.TypeLanguage;

public class ShowProductForm {
private Product product;
private ProductTitleLanguage productTitleLanguage;
private QtyUnit qtyUnit;
private TypeLanguage typeLanguage;
private GroupLanguage groupLanguage;
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public ProductTitleLanguage getProductTitleLanguage() {
	return productTitleLanguage;
}
public void setProductTitleLanguage(ProductTitleLanguage productTitleLanguage) {
	this.productTitleLanguage = productTitleLanguage;
}
public QtyUnit getQtyUnit() {
	return qtyUnit;
}
public void setQtyUnit(QtyUnit qtyUnit) {
	this.qtyUnit = qtyUnit;
}
public TypeLanguage getTypeLanguage() {
	return typeLanguage;
}
public void setTypeLanguage(TypeLanguage typeLanguage) {
	this.typeLanguage = typeLanguage;
}
public GroupLanguage getGroupLanguage() {
	return groupLanguage;
}
public void setGroupLanguage(GroupLanguage groupLanguage) {
	this.groupLanguage = groupLanguage;
}
}
