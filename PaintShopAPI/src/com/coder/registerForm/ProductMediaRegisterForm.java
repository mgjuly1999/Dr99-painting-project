package com.coder.registerForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.coder.form.ProductMediaForm;
import com.coder.model.Folder;
import com.coder.model.Product;
import com.coder.model.ProductMedia;

public class ProductMediaRegisterForm {
	
	private String productId;
	private Product product;
	private ProductMediaForm productMediaForm;
	private List<ProductMedia> productMedias;
	private Map<String,String> mapFolders=new HashedMap<String,String>();

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public ProductMediaForm getProductMediaForm() {
		return productMediaForm;
	}

	public void setProductMediaForm(ProductMediaForm productMediaForm) {
		this.productMediaForm = productMediaForm;
	}

	public Map<String, String> getMapFolders() {
		return mapFolders;
	}

	public void setMapFolders(Map<String, String> mapFolders) {
		this.mapFolders = mapFolders;
	}

	public List<ProductMedia> getProductMedias() {
		return productMedias;
	}

	public void setProductMedias(List<ProductMedia> productMedias) {
		this.productMedias = productMedias;
	}

	
	
}
