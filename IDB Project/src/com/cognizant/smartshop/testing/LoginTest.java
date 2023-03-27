package com.cognizant.smartshop.testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cognizant.smartshop.BO.CustomerBO;
import com.cognizant.smartshop.BO.ShopManagerBO;
import com.cognizant.smartshop.model.CustomerUser;
import com.cognizant.smartshop.model.ShopManager;
import com.cognizant.smartshop.model.User;

public class LoginTest {

	@Test
	public void loginTest() throws Exception
	{
		User customer = new CustomerUser("Walter","White","52","male","5698521476","899652","1255478965","U","What was the name of your 1st pet?","What is the name of your First school?","What is your mother's maiden name?","Gucci","Mckv","c");
		User manager = new ShopManager("Sayan","Pal","22","male","7063402116","899856","1254785698","A","What was the name of your 1st pet?","What is the name of your First school?","What is your mother's maiden name?","a","b","Pushpa"); 
		assertEquals(true, new CustomerBO().checkLogin(customer));
		assertEquals(true, new ShopManagerBO().checkShopManagerLogin(manager));
	}
}
