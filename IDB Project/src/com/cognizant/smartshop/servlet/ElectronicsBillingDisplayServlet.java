package com.cognizant.smartshop.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class ElectronicsBillingDisplayServlet
 */
@WebServlet("/ElectronicsBillingDisplayServlet")
public class ElectronicsBillingDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = MyLogger.getlogger(ElectronicsBillingDisplayServlet.class.getName());  

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElectronicsBillingDisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productType=request.getParameter("ptype");
		LOGGER.log(Level.CONFIG, "Type retrived from jsp and transferred to servlet:");

		List<Product> product=new ArrayList<Product>();
		ShopManagerDao shopManagerDao=null;
		shopManagerDao=new ShopManagerDaoImpl();
		try {
			product=shopManagerDao.showProductForBillingByType(productType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("productList",product);
		RequestDispatcher rd=request.getRequestDispatcher("electronics_b.jsp");
		rd.forward(request,response);
		LOGGER.log(Level.CONFIG, "After billing redirecting to next page:");

	}

}
