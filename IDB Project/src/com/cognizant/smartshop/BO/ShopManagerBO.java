package com.cognizant.smartshop.BO;

import com.cognizant.smartshop.dao.ShopManagerDaoImpl;
import com.cognizant.smartshop.model.User;

public class ShopManagerBO {
	
	public void setShopManagerDetails(User user) throws Exception
	{
		ShopManagerDaoImpl shopManager = new ShopManagerDaoImpl();
		shopManager.setShopManagerDetail(user);
		
	}
	public boolean checkShopManagerLogin(User user) throws Exception {
			
			boolean flag = false;
	        ShopManagerDaoImpl shopManager = new ShopManagerDaoImpl();
	        flag = shopManager.checkLoginShopManager(user);
	        return flag;
	}
	public String getUserTypeBo(String userId) throws Exception
	{
        ShopManagerDaoImpl shopManager = new ShopManagerDaoImpl();
        String userType=shopManager.getUserType(userId);
        return userType;

	}
	public String getStatusBo(String userId) throws Exception
	{
        ShopManagerDaoImpl shopManager = new ShopManagerDaoImpl();
        String status=shopManager.getStatus(userId);
        return status;

	}
	


}
