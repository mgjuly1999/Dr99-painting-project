package com.coder.registerForm;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.coder.form.ProductForm;
import com.coder.model.Product;
import com.coder.model.ProductGroup;

public class ProductRegisterForm {
	
	private ProductForm  productForm=null;
	private String groupId;
	private String adminId;
	private Product product;
	private ProductGroup productGroup;
	private Map<String,String> mapProductTypes=new HashedMap<String,String>();
	private Map<String,String> mapQtyUnit=new HashedMap<String,String>();
	private Map<String,String> mapProductQuality=new HashedMap<String,String>();
	
	public Map<String, String> getMapProductTypes() {
		return mapProductTypes;
	}
	public void setMapProductTypes(Map<String, String> mapProductTypes) {
		this.mapProductTypes = mapProductTypes;
	}
	public Map<String, String> getMapQtyUnit() {
		return mapQtyUnit;
	}
	public void setMapQtyUnit(Map<String, String> mapQtyUnit) {
		this.mapQtyUnit = mapQtyUnit;
	}
	public ProductForm getProductForm() {
		return productForm;
	}
	public void setProductForm(ProductForm productForm) {
		this.productForm = productForm;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public ProductGroup getProductGroup() {
		return productGroup;
	}
	public void setProductGroup(ProductGroup productGroup) {
		this.productGroup = productGroup;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Map<String, String> getMapProductQuality() {
		return mapProductQuality;
	}
	public void setMapProductQuality(Map<String, String> mapProductQuality) {
		this.mapProductQuality = mapProductQuality;
	}
	
}
