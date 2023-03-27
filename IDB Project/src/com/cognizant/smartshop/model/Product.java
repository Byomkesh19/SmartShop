package com.cognizant.smartshop.model;

import java.util.Date;

public class Product {
	private String product_id;
	private String product_name;
	private String brand;
	private String type;
	private String quantity_type;
	private String rate_per_quantity;
	private String stock_count;
	private Date date;
	private String aisle;
	private String shelf;
	private Date date_of_manufacture;
	private Date date_of_expiry;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Product(String product_id, String product_name, String type,
			String stock_count, Date date_of_manufacture,
			Date date_of_expiry) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.type = type;
		this.stock_count = stock_count;
		this.date_of_manufacture = date_of_manufacture;
		this.date_of_expiry = date_of_expiry;
	}
	
	public Product(String product_id, String product_name, String brand, String type, String quantity_type,
			String rate_per_quantity, String stock_count) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.brand = brand;
		this.type = type;
		this.quantity_type = quantity_type;
		this.rate_per_quantity = rate_per_quantity;
		this.stock_count = stock_count;
	}
	



	public Product(String product_id, String product_name, String type, String brand, String quantity_type,
			String rate_per_quantity, String stock_count, Date date, String aisle, String shelf,
			Date date_of_manufacture, Date date_of_expiry) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.brand = brand;
		this.type = type;
		this.quantity_type = quantity_type;
		this.rate_per_quantity = rate_per_quantity;
		this.stock_count = stock_count;
		this.date = date;
		this.aisle = aisle;
		this.shelf = shelf;
		this.date_of_manufacture = date_of_manufacture;
		this.date_of_expiry = date_of_expiry;
	}



	public String getProduct_id() {
		return product_id;
	}



	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}



	public String getProduct_name() {
		return product_name;
	}



	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getQuantity_type() {
		return quantity_type;
	}



	public void setQuantity_type(String quantity_type) {
		this.quantity_type = quantity_type;
	}



	public String getRate_per_quantity() {
		return rate_per_quantity;
	}



	public void setRate_per_quantity(String rate_per_quantity) {
		this.rate_per_quantity = rate_per_quantity;
	}



	public String getStock_count() {
		return stock_count;
	}



	public void setStock_count(String stock_count) {
		this.stock_count = stock_count;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getAisle() {
		return aisle;
	}



	public void setAisle(String aisle) {
		this.aisle = aisle;
	}



	public String getShelf() {
		return shelf;
	}



	public void setShelf(String shelf) {
		this.shelf = shelf;
	}



	public Date getDate_of_manufacture() {
		return date_of_manufacture;
	}



	public void setDate_of_manufacture(Date date_of_manufacture) {
		this.date_of_manufacture = date_of_manufacture;
	}



	public Date getDate_of_expiry() {
		return date_of_expiry;
	}



	public void setDate_of_expiry(Date date_of_expiry) {
		this.date_of_expiry = date_of_expiry;
	}



	@Override
	public boolean equals(Object obj) {
		return false;
		
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", brand=" + brand + ", type="
				+ type + ", quantity_type=" + quantity_type + ", rate_per_quantity=" + rate_per_quantity
				+ ", stock_count=" + stock_count + "]";
	}
	
	
}
