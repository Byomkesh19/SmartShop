package com.cognizant.smartshop.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * Servlet implementation class ModifyProductServlet
 */
@WebServlet("/ModifyProductServlet")
public class ModifyProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = MyLogger.getlogger(ModifyProductServlet.class.getName());  

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String productId = request.getParameter("productId");
        String productName = request.getParameter("pname");
        String productQuantityType = request.getParameter("productType");
		LOGGER.log(Level.CONFIG, "Pid and Pname and PType retrived from jsp and transferred to servlet:");

        try{
	        String stock = request.getParameter("pstock");
	        Date dateOfManufacture = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("manufacture_date"));
	        Date dateOfExpiry = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("expiry_date"));
	        Product product=new Product(productId, productName, productQuantityType, stock, dateOfManufacture, dateOfExpiry);
	        ProductBO productService = new ProductBO();
	        productService.modifyProduct(product);
	        RequestDispatcher rd=request.getRequestDispatcher("managestock.jsp");
	        rd.forward(request,response);
        }
        catch(Exception e){
                        e.printStackTrace();
        }
	}

}
