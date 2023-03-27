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
import com.cognizant.smartshop.model.User;

/**
 * Servlet implementation class PendingApprovalServlet
 */
@WebServlet("/PendingApprovalServlet")
public class PendingApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = MyLogger.getlogger(PendingApprovalServlet.class.getName());  

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PendingApprovalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String userId=request.getParameter("uid");
		LOGGER.log(Level.CONFIG, "ID retrived from jsp and transferred to servlet:");

		ShopManagerDao shopManagerDao=null;
		shopManagerDao=new ShopManagerDaoImpl();
		User user=null;
		try {
			user=shopManagerDao.getUserById(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("user",user);
		RequestDispatcher rd=request.getRequestDispatcher("approve_for_admin.jsp");
		rd.forward(request,response);
		
	}

}
