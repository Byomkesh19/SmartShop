package com.cognizant.smartshop.BO;


import java.util.ArrayList;
import java.util.List;

import com.cognizant.smartshop.dao.ProductDaoImpl;
import com.cognizant.smartshop.model.Product;

public class ProductBO {
	public boolean productAdd(Product product) throws Exception
	{
		boolean flag = true;
		ProductDaoImpl productDao = new ProductDaoImpl();
		productDao.addProduct(product);
		return flag;
	}

	public void modifyProduct(Product product) throws Exception {
		ProductDaoImpl productDao = new ProductDaoImpl();
		productDao.modifyProduct(product);
		
	}
	
	public List<Product> getAllProduct(String productType) throws Exception
	{
		ProductDaoImpl product = new ProductDaoImpl();
		List<Product> productList = new ArrayList<>();
		productList = product.getAllProduct(productType);
		return productList;
	}
	
	public Product getProduct(String productCode) throws Exception
	{
		ProductDaoImpl productDao = new ProductDaoImpl();
		Product productList = productDao.getProduct(productCode);
		return productList;
	}
	
	public void removeProduct(String productCodeId) throws Exception
	{
		ProductDaoImpl productDao = new ProductDaoImpl();
		productDao.removeProduct(productCodeId);
	}
}
