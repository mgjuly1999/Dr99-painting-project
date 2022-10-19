package com.coder.model;
// Generated Jan 23, 2021 7:50:44 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ProductFeatureLanguage generated by hbm2java
 */
@Entity
@Table(name = "product_feature_language", catalog = "drnineni_paint_shop")
public class ProductFeatureLanguage implements java.io.Serializable {

	private ProductFeatureLanguageId id;

	public ProductFeatureLanguage() {
	}

	public ProductFeatureLanguage(ProductFeatureLanguageId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)),
			@AttributeOverride(name = "featureId", column = @Column(name = "feature_id", nullable = false)),
			@AttributeOverride(name = "languageId", column = @Column(name = "language_id", nullable = false)),
			@AttributeOverride(name = "featureName", column = @Column(name = "feature_name", nullable = false, length = 1500)) })
	public ProductFeatureLanguageId getId() {
		return this.id;
	}

	public void setId(ProductFeatureLanguageId id) {
		this.id = id;
	}

}