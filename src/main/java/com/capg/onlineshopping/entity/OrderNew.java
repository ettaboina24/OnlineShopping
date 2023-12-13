package com.capg.onlineshopping.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="order_new")
public class OrderNew {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	@Column(name="customer_name")
	private String customerName;
	@Column(name="product_id")
	private int productId;
	@Column(name="product_name")
	private String productName;
	@Column(name="quantity")
	private int quantity;
	@Column(name="amount")
	private String amount;
	@Column(name="order_date_time")
	private LocalDateTime orderDateTime;
	@Column(name="order_status")
	private String orderStatus;
	
	public OrderNew() {
	}

	public OrderNew(int orderId, String customerName, int productId, String productName, int quantity, String amount,
			LocalDateTime orderDateTime, String orderStatus) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.amount = amount;
		this.orderDateTime = orderDateTime;
		this.orderStatus = orderStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "OrderNew [orderId=" + orderId + ", customerName=" + customerName + ", productId=" + productId
				+ ", productName=" + productName + ", quantity=" + quantity + ", amount=" + amount + ", orderDateTime="
				+ orderDateTime + ", orderStatus=" + orderStatus + "]";
	}
	
}
