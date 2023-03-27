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

import com.cognizant.smartshop.dao.ShopManagerDao;
import com.cognizant.smartshop.dao.ShopManagerDaoImpl;
import com.cognizant.smartshop.logger.MyLogger;
import com.cognizant.smartshop.model.Billing;

/**
 * Servlet implementation class SubmitBillingServlet
 */
@WebServlet("/SubmitBillingServlet")
public class SubmitBillingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = MyLogger.getlogger(SubmitBillingServlet.class.getName());  

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitBillingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId=request.getParameter("uid");
		String customerPhoneNumber=request.getParameter("cpno");
		LOGGER.log(Level.CONFIG, " Id and Cpno retrived from jsp and transferred to servlet:");

		ShopManagerDao shopManagerDao=null;
		shopManagerDao=new ShopManagerDaoImpl();
		Billing billing=null;
		try {
			billing=shopManagerDao.billProduct(userId,customerPhoneNumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("billing",billing);
		RequestDispatcher rd=request.getRequestDispatcher("billing4.jsp");
		rd.forward(request,response);
	}
///,productId,productQuantity,
}
