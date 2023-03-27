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
 * Servlet implementation class ApproveManagerServlet
 */
@WebServlet("/ApproveManagerServlet")
public class ApproveManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = MyLogger.getlogger(ApproveManagerServlet.class.getName());  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String status=request.getParameter("a");
		String userId=request.getParameter("uid");
		ShopManagerDao shopManagerDao=null;
		shopManagerDao=new ShopManagerDaoImpl();
		LOGGER.log(Level.CONFIG, "Data retrived from jsp and transferred to servlet:");
		try {
			shopManagerDao.approveShopManager(status, userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("id",userId);
		RequestDispatcher rd=request.getRequestDispatcher("approved_user.jsp");
		rd.forward(request,response);
		 LOGGER.log(Level.CONFIG, "After approval redirecting to next page:");
	}

}
