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
import com.cognizant.smartshop.model.Product;

/**
 * Servlet implementation class BillByIdProductServlet
 */
@WebServlet("/ShowBillingProductServlet")
public class ShowBillingProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = MyLogger.getlogger(ShowBillingProductServlet.class.getName());  

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBillingProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String productId=request.getParameter("pid");
		LOGGER.log(Level.CONFIG, " code retrived from jsp and transferred to servlet:");

		ShopManagerDao shopManagerDao=null;
		shopManagerDao=new ShopManagerDaoImpl();
		Product product=null;
		try {
			product=shopManagerDao.getProduct(productId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("product",product);
		RequestDispatcher rd=request.getRequestDispatcher("billing2.jsp");
		rd.forward(request,response);
		LOGGER.log(Level.CONFIG, "Billing Page:");


	}

}
