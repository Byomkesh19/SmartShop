package com.cognizant.smartshop.servlet;

import java.io.IOException;
import java.util.List;
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
import com.cognizant.smartshop.model.Product;

/**
 * Servlet implementation class ShowAllProductServlet
 */
@WebServlet("/ShowAllProductServlet")
public class ShowAllProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = MyLogger.getlogger(ShowAllProductServlet.class.getName());  

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductBO product = new ProductBO();
		try {
			String productType = request.getParameter("productType");
			List<Product> products = product.getAllProduct(productType);
			
			request.setAttribute("productList", products);
			LOGGER.log(Level.CONFIG, " Product Stored in list and displayed:");

			RequestDispatcher requestDispatch=null;
			requestDispatch = request.getRequestDispatcher("electronics3_s.jsp");
			requestDispatch.forward(request, response);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
