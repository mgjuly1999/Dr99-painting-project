package com.coder.registerForm;

import com.coder.model.AboutProductLanguage;
import com.coder.model.ColorGroup;
import com.coder.model.Discount;
import com.coder.model.Feature;
import com.coder.model.FeatureLanguage;
import com.coder.model.FreeTool;
import com.coder.model.Guide;
import com.coder.model.GuideLanguage;
import com.coder.model.Litreage;
import com.coder.model.Product;
import com.coder.model.ProductMedia;
import com.coder.model.ProductOrder;
import com.coder.model.ProductTitleLanguage;
import com.coder.model.ToolLanguage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.coder.apiForm.APIProduct;

public class ProductDetailsForm {

	private String productId;
	private Product product;
	private List<ProductTitleLanguage> productTitleLanguages;
	private List<ColorGroup> colorGroups;
	private List<AboutProductLanguage> aboutProductLanguages;
	private List<Litreage> litreages;
	private APIProduct APIProduct;
	private List<ToolLanguage> toolLanguages;
	private List<FeatureLanguage> featureLanguages;
	private List<GuideLanguage> guideLanguages;
	
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
	public APIProduct getAPIProduct() {
		return APIProduct;
	}
	public void setAPIProduct(APIProduct aPIProduct) {
		APIProduct = aPIProduct;
	}
	public List<ProductTitleLanguage> getProductTitleLanguages() {
		return productTitleLanguages;
	}
	public void setProductTitleLanguages(List<ProductTitleLanguage> productTitleLanguages) {
		this.productTitleLanguages = productTitleLanguages;
	}
	public List<ColorGroup> getColorGroups() {
		return colorGroups;
	}
	public void setColorGroups(List<ColorGroup> colorGroups) {
		this.colorGroups = colorGroups;
	}
	public List<AboutProductLanguage> getAboutProductLanguages() {
		return aboutProductLanguages;
	}
	public void setAboutProductLanguages(List<AboutProductLanguage> aboutProductLanguages) {
		this.aboutProductLanguages = aboutProductLanguages;
	}
	public List<Litreage> getLitreages() {
		return litreages;
	}
	public void setLitreages(List<Litreage> litreages) {
		this.litreages = litreages;
	}
	public List<ToolLanguage> getToolLanguages() {
		return toolLanguages;
	}
	public void setToolLanguages(List<ToolLanguage> toolLanguages) {
		this.toolLanguages = toolLanguages;
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
	
}
