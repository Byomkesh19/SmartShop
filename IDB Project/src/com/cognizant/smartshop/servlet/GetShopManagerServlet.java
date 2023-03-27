package com.cognizant.smartshop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
 * Servlet implementation class GetShopManagerServlet
 */
@WebServlet("/GetShopManagerServlet")
public class GetShopManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = MyLogger.getlogger(GetShopManagerServlet.class.getName());  

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetShopManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ShopManagerDao shopManagerDao=null;
		shopManagerDao=new ShopManagerDaoImpl();
		List<User> user=new ArrayList<>();
		try {
			user=shopManagerDao.getUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("user",user);
		RequestDispatcher rd=request.getRequestDispatcher("adminpage_approval.jsp");
		rd.forward(request,response);
	
	}

}
