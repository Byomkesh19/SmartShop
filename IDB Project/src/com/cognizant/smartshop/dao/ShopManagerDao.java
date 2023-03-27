package com.cognizant.smartshop.dao;

import java.util.List;

import com.cognizant.smartshop.model.Billing;
import com.cognizant.smartshop.model.Product;
import com.cognizant.smartshop.model.User;

public interface ShopManagerDao {
	public void setShopManagerDetail(User user) throws Exception;
	//public boolean checkLogin(String userId, String password) throws Exception;
	public boolean checkLoginShopManager(User user) throws Exception;
	List<Product> showProductForBillingByType(String productType) throws Exception;
	Product getProduct(String productId) throws Exception;
	void updateStockOfProduct(String productId, String productQuantity) throws Exception;
	void updatePurchaseHistory(String productId, String userId, String productQuantity) throws Exception;
	Billing showAllProductInBill(String userId, String customerPhoneNumber, String productQuantity) throws Exception;
	Billing showPurchaseHistory(String userId) throws Exception;
	Billing billProduct(String userId, String customerPhoneNumber) throws Exception;
	void updateAisleAndSelfDetails(String productId, String aisle, String shelf) throws Exception;
	public void approveShopManager(String status,String userId) throws Exception;
	public List<User> getUser() throws Exception; 
	public User getUserById(String userId) throws Exception;
	public String getStatus(String userId) throws Exception;
	public String getUserType(String userId) throws Exception;
}
