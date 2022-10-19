package com.coder.model;
// Generated Jan 23, 2021 7:50:44 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ProductGroup generated by hbm2java
 */
@Entity
@Table(name = "product_group", catalog = "drnineni_paint_shop")
public class ProductGroup implements java.io.Serializable {

	private Integer productGroupId;
	private Set<GroupLanguage> groupLanguages = new HashSet<GroupLanguage>(0);
	private Set<ProductType> productTypes = new HashSet<ProductType>(0);

	public ProductGroup() {
	}

	public ProductGroup(Set<GroupLanguage> groupLanguages, Set<ProductType> productTypes) {
		this.groupLanguages = groupLanguages;
		this.productTypes = productTypes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "product_group_id", unique = true, nullable = false)
	public Integer getProductGroupId() {
		return this.productGroupId;
	}

	public void setProductGroupId(Integer productGroupId) {
		this.productGroupId = productGroupId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productGroup")
	public Set<GroupLanguage> getGroupLanguages() {
		return this.groupLanguages;
	}

	public void setGroupLanguages(Set<GroupLanguage> groupLanguages) {
		this.groupLanguages = groupLanguages;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productGroup")
	public Set<ProductType> getProductTypes() {
		return this.productTypes;
	}

	public void setProductTypes(Set<ProductType> productTypes) {
		this.productTypes = productTypes;
	}

}