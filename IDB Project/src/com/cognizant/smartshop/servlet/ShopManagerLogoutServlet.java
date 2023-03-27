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
import javax.servlet.http.HttpSession;

import com.cognizant.smartshop.logger.MyLogger;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/ShopManagerLogoutServlet")
public class ShopManagerLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = MyLogger.getlogger(ShopManagerLogoutServlet.class.getName());  

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopManagerLogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("shopManager");
			LOGGER.log(Level.CONFIG, " User Logout.");

            RequestDispatcher dispatcher = request.getRequestDispatcher("shop-manager-login-page.jsp");
            dispatcher.forward(request, response);
			LOGGER.log(Level.CONFIG, " Open Login Page");


	}

}
}
