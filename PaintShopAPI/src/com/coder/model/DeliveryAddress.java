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
 * DeliveryAddress generated by hbm2java
 */
@Entity
@Table(name = "delivery_address", catalog = "drnineni_paint_shop")
public class DeliveryAddress implements java.io.Serializable {

	private Integer deliveryAddressId;
	private String address;
	private double deliveryPrice;
	private String description;
	private Set<OrderForm> orderForms = new HashSet<OrderForm>(0);

	public DeliveryAddress() {
	}

	public DeliveryAddress(String address, double deliveryPrice) {
		this.address = address;
		this.deliveryPrice = deliveryPrice;
	}

	public DeliveryAddress(String address, double deliveryPrice, String description, Set<OrderForm> orderForms) {
		this.address = address;
		this.deliveryPrice = deliveryPrice;
		this.description = description;
		this.orderForms = orderForms;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "delivery_address_id", unique = true, nullable = false)
	public Integer getDeliveryAddressId() {
		return this.deliveryAddressId;
	}

	public void setDeliveryAddressId(Integer deliveryAddressId) {
		this.deliveryAddressId = deliveryAddressId;
	}

	@Column(name = "address", nullable = false, length = 1500)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "delivery_price", nullable = false, precision = 22, scale = 0)
	public double getDeliveryPrice() {
		return this.deliveryPrice;
	}

	public void setDeliveryPrice(double deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	@Column(name = "description", length = 1500)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "deliveryAddress")
	public Set<OrderForm> getOrderForms() {
		return this.orderForms;
	}

	public void setOrderForms(Set<OrderForm> orderForms) {
		this.orderForms = orderForms;
	}

}
