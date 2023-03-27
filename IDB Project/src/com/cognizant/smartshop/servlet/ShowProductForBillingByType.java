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
import com.cognizant.smartshop.dao.ShopManagerDao;
import com.cognizant.smartshop.dao.ShopManagerDaoImpl;
import com.cognizant.smartshop.logger.MyLogger;
import com.cognizant.smartshop.model.Product;

/**
 * Servlet implementation class ShowProductForBillingByType
 */
@WebServlet("/ShowProductForBillingByType")
public class ShowProductForBillingByType extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = MyLogger.getlogger(ShowProductForBillingByType.class.getName());  

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProductForBillingByType() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productType=request.getParameter("ptype");
		LOGGER.log(Level.CONFIG, " Type retrived from jsp and transferred to servlet:");

		ShopManagerDao shopManagerDao=null;
		List<Product> product=null;		
		try{
			shopManagerDao=new ShopManagerDaoImpl();
			 product=shopManagerDao.showProductForBillingByType(productType); 

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		request.setAttribute("product",product);
		RequestDispatcher rd=request.getRequestDispatcher("show_product.jsp");
		rd.forward(request, response);
	}

}
