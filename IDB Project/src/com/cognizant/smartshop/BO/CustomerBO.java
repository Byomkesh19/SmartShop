package com.cognizant.smartshop.BO;

import com.cognizant.smartshop.dao.CustomerDaoImpl;
import com.cognizant.smartshop.dao.CustomerDao;
import com.cognizant.smartshop.model.User;

public class CustomerBO {
	public boolean checkLogin(User user) throws Exception {
		
		boolean flag = false;
		

        CustomerDao customerDao = new CustomerDaoImpl();
		flag = customerDao.checkLogin(user);

        return flag;
	}
	public void setCustomerDetails(User user) throws Exception
	{
		CustomerDaoImpl customer = new CustomerDaoImpl();
		customer.setCustomerDetail(user);
		
	}
	public String getUserTypeBo(String userId) throws Exception
	{
        CustomerDaoImpl customer = new CustomerDaoImpl();
        String userType=customer.getUserType(userId);
        return userType;

	}
}
