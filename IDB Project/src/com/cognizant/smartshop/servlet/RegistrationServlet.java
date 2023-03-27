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

import com.cognizant.smartshop.BO.CustomerBO;
import com.cognizant.smartshop.BO.ShopManagerBO;
import com.cognizant.smartshop.logger.MyLogger;
import com.cognizant.smartshop.model.CustomerUser;
import com.cognizant.smartshop.model.ShopManager;
import com.cognizant.smartshop.model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = MyLogger.getlogger(RegistrationServlet.class.getName());  


    /**
     * Default constructor. 
     */
    public RegistrationServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
			String age = request.getParameter("age");
			String gender = request.getParameter("gender");
			String contactNumber = request.getParameter("number");
			String userId = request.getParameter("userid");
			String password = request.getParameter("password");
			String userType = request.getParameter("type");
			String firstQuestion=request.getParameter("firstQuestion");
			String secondQuestion=request.getParameter("secondQuestion");
			String thirdQuestion=request.getParameter("thirdQuestion");
			String firstAnswer = request.getParameter("firstAnswer");
			String secondAnswer = request.getParameter("secondAnswer");
			String thirdAnswer = request.getParameter("thirdAnswer");
			LOGGER.log(Level.CONFIG, "Data retrived from jsp and transferred to servlet:");

			if(userType.equalsIgnoreCase("U"))
			{
				User customer = new CustomerUser();
				customer.setFirstName(firstName);
				customer.setLastName(lastName);
				customer.setAge(age);
				customer.setGender(gender);
				customer.setContactNumber(contactNumber);
				customer.setUserId(userId);
				customer.setPassword(password);
				customer.setUserType(userType);
				customer.setFirstQuestion(firstQuestion);
				customer.setSecondQuestion(secondQuestion);
				customer.setThirdQuestion(thirdQuestion);
				customer.setFirstAnswer(firstAnswer);
				customer.setSecondAnswer(secondAnswer);
				customer.setThirdAnswer(thirdAnswer);
				CustomerBO customerBO = new CustomerBO();
				customerBO.setCustomerDetails(customer);
				LOGGER.log(Level.CONFIG, "Data set to database:");

			}
			
			else if(userType.equalsIgnoreCase("A"))
			{
				User admin = new ShopManager();
				admin.setFirstName(firstName);
				admin.setLastName(lastName);
				admin.setAge(age);
				admin.setGender(gender);
				admin.setContactNumber(contactNumber);
				admin.setUserId(userId);
				admin.setPassword(password);
				admin.setUserType(userType);
				admin.setFirstQuestion(firstQuestion);
				admin.setSecondQuestion(secondQuestion);
				admin.setThirdQuestion(thirdQuestion);
				admin.setFirstAnswer(firstAnswer);
				admin.setSecondAnswer(secondAnswer);
				admin.setThirdAnswer(thirdAnswer);
				ShopManagerBO shopManagerBo = new ShopManagerBO();
				shopManagerBo.setShopManagerDetails(admin);
				LOGGER.log(Level.CONFIG, "Data set to database:");

			}
			if(firstName.isEmpty() || lastName.isEmpty() || age.isEmpty() || gender.isEmpty() || contactNumber.isEmpty() || 
			userId.isEmpty() || password.isEmpty() || userType.isEmpty())
			{ 
				RequestDispatcher req = request.getRequestDispatcher("registration-page.jsp");
				req.include(request, response);

			}
			else if(userType.equalsIgnoreCase("U"))
			{
				
				boolean flag=true;
				if(flag == true)
				{
					request.setAttribute("flag", flag);
					request.setAttribute("userId", userId);
				}
				RequestDispatcher req = request.getRequestDispatcher("customer-login-page.jsp");
				req.forward(request, response);
			}
			else if(userType.equalsIgnoreCase("A"))
			{
				boolean flag=true;
				if(flag == true)
				{
					request.setAttribute("flag", flag);
					request.setAttribute("userId", userId);
				}
				RequestDispatcher req = request.getRequestDispatcher("shop-manager-login-page.jsp");
				req.forward(request, response);
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			RequestDispatcher requestDispatch = request.getRequestDispatcher("existing_user.jsp");
			requestDispatch.forward(request, response);
			e.printStackTrace();
		}

	}
}
