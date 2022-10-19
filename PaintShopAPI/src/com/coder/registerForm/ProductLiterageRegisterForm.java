package com.coder.registerForm;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.coder.form.LiterageForm;
import com.coder.model.Product;

public class ProductLiterageRegisterForm {
	private Product product;
	private LiterageForm productLiterageForm;
	private Map<String,String> mapQtyUnits=new HashedMap<String,String>();

	public Map<String, String> getMapQtyUnits() {
		return mapQtyUnits;
	}

	public void setMapQtyUnits(Map<String, String> mapQtyUnits) {
		this.mapQtyUnits = mapQtyUnits;
	}

	public LiterageForm getProductLiterageForm() {
		return productLiterageForm;
	}

	public void setProductLiterageForm(LiterageForm productLiterageForm) {
		this.productLiterageForm = productLiterageForm;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
