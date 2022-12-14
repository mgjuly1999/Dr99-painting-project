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
 * Folder generated by hbm2java
 */
@Entity
@Table(name = "folder", catalog = "drnineni_paint_shop")
public class Folder implements java.io.Serializable {

	private Integer folderId;
	private String name;
	private Set<ProductMedia> productMedias = new HashSet<ProductMedia>(0);

	public Folder() {
	}

	public Folder(String name) {
		this.name = name;
	}

	public Folder(String name, Set<ProductMedia> productMedias) {
		this.name = name;
		this.productMedias = productMedias;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "folder_id", unique = true, nullable = false)
	public Integer getFolderId() {
		return this.folderId;
	}

	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}

	@Column(name = "name", nullable = false, length = 500)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "folder")
	public Set<ProductMedia> getProductMedias() {
		return this.productMedias;
	}

	public void setProductMedias(Set<ProductMedia> productMedias) {
		this.productMedias = productMedias;
	}

}
