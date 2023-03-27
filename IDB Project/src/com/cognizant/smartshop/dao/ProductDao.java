package com.cognizant.smartshop.dao;

import java.util.List;

import com.cognizant.smartshop.model.Product;

public interface ProductDao {
	public Product getProduct(String productCode) throws Exception;
	public void addProduct(Product product) throws Exception;
    public void modifyProduct(Product product) throws Exception;
	void removeProduct(String productCodeId) throws Exception;
	public List<Product> getAllProduct(String productType) throws Exception;
	List<Product> searchProduct();
	
}
