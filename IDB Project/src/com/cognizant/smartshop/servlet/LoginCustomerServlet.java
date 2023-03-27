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

import com.cognizant.smartshop.BO.CustomerBO;
import com.cognizant.smartshop.logger.MyLogger;
import com.cognizant.smartshop.model.User;

/**
 * Servlet implementation class LoginCustomerServlet
 */
@WebServlet("/LoginCustomerServlet")
public class LoginCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = MyLogger.getlogger(LoginCustomerServlet.class.getName());  

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCustomerServlet() {
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
		try {
        boolean flag = false;
        User user = new User(userId, password);
        CustomerBO login = new CustomerBO();
        String userType=login.getUserTypeBo(userId);
        if(userType.equals("U"))
        {
        if(userId.equals("111111"))
        {
        	
    			flag = login.checkLogin(user);
                String destPage = "customer-login-page.jsp";
    			if (flag == true)
                {
    				 HttpSession session = request.getSession();
    	             session.setAttribute("user", user);
    	             destPage = "admin_page.jsp";
    	     		LOGGER.log(Level.CONFIG, "Login Succesful");
                }
    			else
    			{
    				request.setAttribute("loginMes", flag);
    			}
    			RequestDispatcher rd = request.getRequestDispatcher(destPage);
    			rd.forward(request, response);
        }
    	else{
    			flag = login.checkLogin(user);
                String destPage = "customer-login-page.jsp";
    			if (flag == true)
                {
    				 HttpSession session = request.getSession();
    	             session.setAttribute("user", user);
    	             destPage = "homepage_customer.jsp";
    	     		 LOGGER.log(Level.CONFIG, "Return to home page");

    	        }
	            else
	
	            {
	            	request.setAttribute("loginMes", flag);
	
	            }
	        	RequestDispatcher rd = request.getRequestDispatcher(destPage);
	        	rd.forward(request, response);
    		}
        	}
        else
        {
        	RequestDispatcher rd = request.getRequestDispatcher("not_customer.jsp");
        	rd.forward(request, response);
        }
		}
        	catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
		
        }
	}


