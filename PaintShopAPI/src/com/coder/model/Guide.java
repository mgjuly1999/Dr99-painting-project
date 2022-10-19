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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Guide generated by hbm2java
 */
@Entity
@Table(name = "guide", catalog = "drnineni_paint_shop")
public class Guide implements java.io.Serializable {

	private Integer guideId;
	private Set<GuideLanguage> guideLanguages = new HashSet<GuideLanguage>(0);
	private Set<Product> products = new HashSet<Product>(0);

	public Guide() {
	}

	public Guide(Set<GuideLanguage> guideLanguages, Set<Product> products) {
		this.guideLanguages = guideLanguages;
		this.products = products;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "guide_id", unique = true, nullable = false)
	public Integer getGuideId() {
		return this.guideId;
	}

	public void setGuideId(Integer guideId) {
		this.guideId = guideId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "guide")
	public Set<GuideLanguage> getGuideLanguages() {
		return this.guideLanguages;
	}

	public void setGuideLanguages(Set<GuideLanguage> guideLanguages) {
		this.guideLanguages = guideLanguages;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "guides")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}