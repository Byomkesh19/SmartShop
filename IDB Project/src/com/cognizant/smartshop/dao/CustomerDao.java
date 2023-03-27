package com.cognizant.smartshop.dao;
import com.cognizant.smartshop.model.User;

public interface CustomerDao {
	public void setCustomerDetail(User user) throws Exception;
	public boolean checkLogin(User user) throws Exception;
}
