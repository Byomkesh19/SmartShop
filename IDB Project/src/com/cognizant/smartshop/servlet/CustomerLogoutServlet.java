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
@WebServlet("/CustomerLogoutServlet")
public class CustomerLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = MyLogger.getlogger(CustomerLogoutServlet.class.getName());  

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("user");
    		LOGGER.log(Level.CONFIG, "Removing Attributes fro user:");

            RequestDispatcher dispatcher = request.getRequestDispatcher("customer-login-page.jsp");
            dispatcher.forward(request, response);
	}

}
}
