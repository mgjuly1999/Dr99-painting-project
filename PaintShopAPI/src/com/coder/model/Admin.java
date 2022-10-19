package com.coder.model;
// Generated Jan 23, 2021 7:50:44 PM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Admin generated by hbm2java
 */
@Entity
@Table(name = "admin", catalog = "drnineni_paint_shop")
public class Admin implements java.io.Serializable {

	private Integer adminId;
	private AdminStatus adminStatus;
	private String name;
	private String email;
	private String password;
	private String phone;
	private String nrc;
	private String gender;
	private String description;
	private Date createDate;
	private Set<Shop> shops = new HashSet<Shop>(0);
	private Set<Product> products = new HashSet<Product>(0);

	public Admin() {
	}

	public Admin(AdminStatus adminStatus, String name, String email, String password, String phone, String nrc,
			String gender, Date createDate) {
		this.adminStatus = adminStatus;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.nrc = nrc;
		this.gender = gender;
		this.createDate = createDate;
	}

	public Admin(AdminStatus adminStatus, String name, String email, String password, String phone, String nrc,
			String gender, String description, Date createDate, Set<Shop> shops, Set<Product> products) {
		this.adminStatus = adminStatus;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.nrc = nrc;
		this.gender = gender;
		this.description = description;
		this.createDate = createDate;
		this.shops = shops;
		this.products = products;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "admin_id", unique = true, nullable = false)
	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admin_status_id", nullable = false)
	public AdminStatus getAdminStatus() {
		return this.adminStatus;
	}

	public void setAdminStatus(AdminStatus adminStatus) {
		this.adminStatus = adminStatus;
	}

	@Column(name = "name", nullable = false, length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 1000)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "phone", nullable = false, length = 30)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "nrc", nullable = false, length = 200)
	public String getNrc() {
		return this.nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

	@Column(name = "gender", nullable = false, length = 20)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "description", length = 1500)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "create_date", nullable = false, length = 10)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "admin")
	public Set<Shop> getShops() {
		return this.shops;
	}

	public void setShops(Set<Shop> shops) {
		this.shops = shops;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "admin")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
