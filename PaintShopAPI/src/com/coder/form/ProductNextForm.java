package com.coder.form;

public class ProductNextForm {

	private String productId;
	private String[] features=null;
	private String[] tools=null;
	private String[] guides=null;
	
	public String[] getFeatures() {
		return features;
	}
	public void setFeatures(String[] features) {
		this.features = features;
	}
	public String[] getTools() {
		return tools;
	}
	public void setTools(String[] tools) {
		this.tools = tools;
	}
	public String[] getGuides() {
		return guides;
	}
	public void setGuides(String[] guides) {
		this.guides = guides;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
}
