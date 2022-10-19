package com.coder.registerForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.coder.form.ProductNextForm;
import com.coder.model.FeatureLanguage;
import com.coder.model.FeatureLanguageId;
import com.coder.model.GuideLanguage;
import com.coder.model.GuideLanguageId;
import com.coder.model.Product;
import com.coder.model.ToolLanguage;
import com.coder.model.ToolLanguageId;

public class ProductRegisterNextForm {
	private String productId;
	private Product product;
	private ProductNextForm productNextForm;
	List<FeatureLanguage> featureLanguages=new ArrayList<FeatureLanguage>();
	List<GuideLanguage> guideLanguages=new ArrayList<GuideLanguage>();
	List<ToolLanguage> toolLanguages=new ArrayList<ToolLanguage>();
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<FeatureLanguage> getFeatureLanguages() {
		return featureLanguages;
	}
	public void setFeatureLanguages(List<FeatureLanguage> featureLanguages) {
		this.featureLanguages = featureLanguages;
	}
	public List<GuideLanguage> getGuideLanguages() {
		return guideLanguages;
	}
	public void setGuideLanguages(List<GuideLanguage> guideLanguages) {
		this.guideLanguages = guideLanguages;
	}
	public List<ToolLanguage> getToolLanguages() {
		return toolLanguages;
	}
	public void setToolLanguages(List<ToolLanguage> toolLanguages) {
		this.toolLanguages = toolLanguages;
	}
	public ProductNextForm getProductNextForm() {
		return productNextForm;
	}
	public void setProductNextForm(ProductNextForm productNextForm) {
		this.productNextForm = productNextForm;
	}

	
}
