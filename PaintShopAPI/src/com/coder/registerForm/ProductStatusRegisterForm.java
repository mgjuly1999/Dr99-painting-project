package com.coder.registerForm;

import java.util.List;

import com.coder.form.ProductStatusForm;
import com.coder.model.ProductStatus;

public class ProductStatusRegisterForm {
private ProductStatusForm productStatusForm;
private List<ProductStatus> productStatuss;
public ProductStatusForm getProductStatusForm() {
	return productStatusForm;
}

public void setProductStatusForm(ProductStatusForm productStatusForm) {
	this.productStatusForm = productStatusForm;
}

public List<ProductStatus> getProductStatuss() {
	return productStatuss;
}

public void setProductStatuss(List<ProductStatus> productStatuss) {
	this.productStatuss = productStatuss;
}
}
