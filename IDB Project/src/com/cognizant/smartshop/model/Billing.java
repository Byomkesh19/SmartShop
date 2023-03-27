package com.cognizant.smartshop.model;

import java.util.List;

public class Billing {
	
	private List<Product> productList;
	private double total;
	private String customerId;
	private String contactNumber;
	private String buyDate;
	
	
	public Billing(List<Product> productList, double total, String customerId, String contactNumber, String buyDate) {
		super();
		this.productList = productList;
		this.total = total;
		this.customerId = customerId;
		this.contactNumber = contactNumber;
		this.buyDate = buyDate;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Billing(List<Product> productList, double total, String customerId, String contactNumber) {
		super();
		this.productList = productList;
		this.total = total;
		this.customerId = customerId;
		this.contactNumber = contactNumber;
	}
	
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public Billing(List<Product> productList, double total) {
		super();
		this.productList = productList;
		this.total = total;
	}
	public Billing() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

}
