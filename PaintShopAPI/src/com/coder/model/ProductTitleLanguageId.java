package com.coder.model;
// Generated Jan 23, 2021 7:50:44 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProductTitleLanguageId generated by hbm2java
 */
@Embeddable
public class ProductTitleLanguageId implements java.io.Serializable {

	private int productId;
	private int languageId;

	public ProductTitleLanguageId() {
	}

	public ProductTitleLanguageId(int productId, int languageId) {
		this.productId = productId;
		this.languageId = languageId;
	}

	@Column(name = "product_id", nullable = false)
	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Column(name = "language_id", nullable = false)
	public int getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProductTitleLanguageId))
			return false;
		ProductTitleLanguageId castOther = (ProductTitleLanguageId) other;

		return (this.getProductId() == castOther.getProductId()) && (this.getLanguageId() == castOther.getLanguageId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getProductId();
		result = 37 * result + this.getLanguageId();
		return result;
	}

}
