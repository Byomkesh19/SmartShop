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

/**
 * Servlet implementation class UpdateAisleAndShelfDetailsServlet
 */
@WebServlet("/UpdateAisleAndShelfDetailsServlet")
public class UpdateAisleAndShelfDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = MyLogger.getlogger(UpdateAisleAndShelfDetailsServlet.class.getName());  

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAisleAndShelfDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productId=request.getParameter("pid");
		String aisle=request.getParameter("paisle");
		String shelf=request.getParameter("pshelf");
		LOGGER.log(Level.CONFIG, " Id, Aisle, Shelf retrived from jsp and transferred to servlet:");

		ShopManagerDao shopManagerDao=null;
		shopManagerDao=new ShopManagerDaoImpl();
		try {
			shopManagerDao.updateAisleAndSelfDetails(productId, aisle, shelf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("update_location.jsp");
		rd.forward(request,response);
		LOGGER.log(Level.CONFIG, "Location Displayed:");

	}

}
