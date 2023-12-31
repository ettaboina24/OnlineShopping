package com.capg.onlineshopping.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String name;
	private int quantity;
	private String brand;
	private String description;
	private int price;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="category_id",referencedColumnName = "category_id")
	@JsonBackReference(value="category_id")
	private Category category;
	public Product(int productId, String name, int quantity, String brand, String description, int price) {
		this.productId = productId;
		this.name = name;
		this.quantity = quantity;
		this.brand = brand;
		this.description = description;
		this.price = price;
	}

	
	
	public Product(int productId, String name, int quantity, String brand, String description, int price,
			Category category) {
		this.productId = productId;
		this.name = name;
		this.quantity = quantity;
		this.brand = brand;
		this.description = description;
		this.price = price;
		this.category = category;
	}



	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", quantity=" + quantity + ", brand=" + brand
				+ ", description=" + description + ", price=" + price + ", category=" + category.getId() + "]";
	}



	public Product() 
	{
	}
	

	
}
