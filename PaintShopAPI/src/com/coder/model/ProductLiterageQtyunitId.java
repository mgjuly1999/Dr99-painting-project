package com.coder.model;
// Generated Jan 23, 2021 7:50:44 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProductLiterageQtyunitId generated by hbm2java
 */
@Embeddable
public class ProductLiterageQtyunitId implements java.io.Serializable {

	private int productId;
	private double litreageUnitPrice;
	private int litreageQty;
	private String qtyUnit;

	public ProductLiterageQtyunitId() {
	}

	public ProductLiterageQtyunitId(int productId, double litreageUnitPrice, int litreageQty, String qtyUnit) {
		this.productId = productId;
		this.litreageUnitPrice = litreageUnitPrice;
		this.litreageQty = litreageQty;
		this.qtyUnit = qtyUnit;
	}

	@Column(name = "product_id", nullable = false)
	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Column(name = "litreage_unit_price", nullable = false, precision = 22, scale = 0)
	public double getLitreageUnitPrice() {
		return this.litreageUnitPrice;
	}

	public void setLitreageUnitPrice(double litreageUnitPrice) {
		this.litreageUnitPrice = litreageUnitPrice;
	}

	@Column(name = "litreage_qty", nullable = false)
	public int getLitreageQty() {
		return this.litreageQty;
	}

	public void setLitreageQty(int litreageQty) {
		this.litreageQty = litreageQty;
	}

	@Column(name = "qty_unit", nullable = false, length = 400)
	public String getQtyUnit() {
		return this.qtyUnit;
	}

	public void setQtyUnit(String qtyUnit) {
		this.qtyUnit = qtyUnit;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProductLiterageQtyunitId))
			return false;
		ProductLiterageQtyunitId castOther = (ProductLiterageQtyunitId) other;

		return (this.getProductId() == castOther.getProductId())
				&& (this.getLitreageUnitPrice() == castOther.getLitreageUnitPrice())
				&& (this.getLitreageQty() == castOther.getLitreageQty())
				&& ((this.getQtyUnit() == castOther.getQtyUnit()) || (this.getQtyUnit() != null
						&& castOther.getQtyUnit() != null && this.getQtyUnit().equals(castOther.getQtyUnit())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getProductId();
		result = 37 * result + (int) this.getLitreageUnitPrice();
		result = 37 * result + this.getLitreageQty();
		result = 37 * result + (getQtyUnit() == null ? 0 : this.getQtyUnit().hashCode());
		return result;
	}

}
