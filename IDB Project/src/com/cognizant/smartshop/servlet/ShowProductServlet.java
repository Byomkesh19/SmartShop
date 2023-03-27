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

import com.cognizant.smartshop.BO.ProductBO;
import com.cognizant.smartshop.logger.MyLogger;

/**
 * Servlet implementation class ShowProductServlet
 */
@WebServlet("/ShowProductServlet")
public class ShowProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = MyLogger.getlogger(ShowProductServlet.class.getName());  

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductBO product = new ProductBO();
		String productID = request.getParameter("productCode");
		productID = productID.trim();
		LOGGER.log(Level.CONFIG, " code retrived from jsp and transferred to servlet:");

		try {
			request.setAttribute("productDetails",product.getProduct(productID));
			RequestDispatcher rd = request.getRequestDispatcher("managestock.jsp");
			rd.forward(request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
