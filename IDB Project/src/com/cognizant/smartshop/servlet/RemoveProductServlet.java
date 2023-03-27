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
 * Servlet implementation class RemoveProductServlet
 */
@WebServlet("/RemoveProductServlet")
public class RemoveProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = MyLogger.getlogger(RemoveProductServlet.class.getName());  

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productCode = request.getParameter("productCode");
		String productType = request.getParameter("productType");
		productCode=productCode.trim();
		productType=productType.trim();
		LOGGER.log(Level.CONFIG, " code and type retrived from jsp and transferred to servlet:");

	
		ProductBO productService = new ProductBO();
		try {
			productService.removeProduct(productCode);
			List<Product> productList = productService.getAllProduct(productType);
			request.setAttribute("productList", productList);
			RequestDispatcher rd = request.getRequestDispatcher("electronics3_s.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
