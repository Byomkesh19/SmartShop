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
 * Servlet implementation class SearchProductByIdServlet
 */
@WebServlet("/SearchProductByIdServlet")
public class SearchProductByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = MyLogger.getlogger(SearchProductByIdServlet.class.getName());  

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productId=request.getParameter("spid");
		LOGGER.log(Level.CONFIG, " PId retrived from jsp and transferred to servlet:");

		ShopManagerDao shopManagerDao=null;
		shopManagerDao=new ShopManagerDaoImpl();
		Product product=null;
		try {
			product=shopManagerDao.getProduct(productId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		if(product.getProduct_id()==null)
		{
			request.setAttribute("id",productId);
			RequestDispatcher rd=request.getRequestDispatcher("noProduct.jsp");
			rd.forward(request,response);
			LOGGER.log(Level.CONFIG, " Display No Product.");
			return;

		}
		else{
		request.setAttribute("product",product);
		RequestDispatcher rd=request.getRequestDispatcher("billing2.jsp");
		rd.forward(request,response);
		LOGGER.log(Level.CONFIG, "Billing Page Directed");

	}
	}

}
