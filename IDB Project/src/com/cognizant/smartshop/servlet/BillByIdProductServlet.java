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
import com.cognizant.smartshop.model.Billing;

/**
 * Servlet implementation class BillByIdProductServlet
 */
@WebServlet("/BillByIdProductServlet")
public class BillByIdProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = MyLogger.getlogger(BillByIdProductServlet.class.getName());  

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillByIdProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productId=request.getParameter("pid");
		LOGGER.log(Level.CONFIG, "Product ID retrived from jsp and transferred to servlet:");


		String userId=request.getParameter("uid");
		String productQuantity=request.getParameter("pqty");
		String customerPhoneNumber=request.getParameter("cpno");
		Billing billing=null;
		ShopManagerDao shopManagerDao=null;
		shopManagerDao=new ShopManagerDaoImpl();
		try {
			shopManagerDao.updateStockOfProduct(productId,productQuantity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			shopManagerDao.updatePurchaseHistory(productId,userId,productQuantity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		try{
			billing=shopManagerDao.showAllProductInBill(userId,customerPhoneNumber,productQuantity);//(userId, productId, productQuantity);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("billing",billing);

		
		RequestDispatcher rd=request.getRequestDispatcher("billing3.jsp");
		rd.forward(request,response);
		LOGGER.log(Level.CONFIG, "After updating redirecting to next page:");

	}

}
