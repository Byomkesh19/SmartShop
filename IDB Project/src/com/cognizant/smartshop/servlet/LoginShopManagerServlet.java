package com.cognizant.smartshop.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.smartshop.BO.ShopManagerBO;
import com.cognizant.smartshop.dao.ShopManagerDao;
import com.cognizant.smartshop.dao.ShopManagerDaoImpl;
import com.cognizant.smartshop.logger.MyLogger;
import com.cognizant.smartshop.model.User;

/**
 * Servlet implementation class LoginShopManagerServlet
 */
@WebServlet("/LoginShopManagerServlet")
public class LoginShopManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = MyLogger.getlogger(LoginShopManagerServlet.class.getName());  

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginShopManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
        String password = request.getParameter("password");
		LOGGER.log(Level.CONFIG, "userid and password retrived from jsp and transferred to servlet:");

        boolean flag = false;
        try {
        User user = new User(userId, password);
        ShopManagerBO shopObj = new ShopManagerBO();
        String status = shopObj.getStatusBo(userId);
        String userType=shopObj.getUserTypeBo(userId);
        if(userType.equals("A")){
	        if(status.equals("A"))
	        {
	        	ShopManagerBO shopManagerLogin = new ShopManagerBO();
	            String destPage = "shop-manager-login-page.jsp";
	    			flag = shopManagerLogin.checkShopManagerLogin(user);
	    			if (flag == true)
	
	                {
	    				HttpSession session = request.getSession();
	    	            session.setAttribute("shopManager", user);
	    	            destPage = "manager_page.jsp";
	    	     		LOGGER.log(Level.CONFIG, "Login Succesfull");
	
	                }
		            else
		            {
		            	request.setAttribute("loginMes", flag);
		            	LOGGER.log(Level.CONFIG, "Not Succesfull");
		
		            }
	    		RequestDispatcher rd = request.getRequestDispatcher(destPage);
	    		rd.forward(request, response);
	     		
	
	        }
	        else{
	        	request.setAttribute("message", userId);
	        	RequestDispatcher rd = request.getRequestDispatcher("no_access.jsp");
	        	rd.forward(request, response);
	     		LOGGER.log(Level.CONFIG, "No Access");
	        	}
	        }
        else{
        	RequestDispatcher rd = request.getRequestDispatcher("not_shop_manager.jsp");
        	rd.forward(request, response);
        }
        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
