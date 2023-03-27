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
import com.cognizant.smartshop.BO.ProductBO;
import com.cognizant.smartshop.logger.MyLogger;
import com.cognizant.smartshop.model.Product;

/**
 * Servlet implementation class ModifyProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final static Logger LOGGER = MyLogger.getlogger(AddProductServlet.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        String productId = request.getParameter("pid");
        String productName = request.getParameter("pname");
        String productBrand = request.getParameter("brand");
        String productType = request.getParameter("ptype");
        String productQuantityType = request.getParameter("quantity");
        String productRate = request.getParameter("rate");
        LOGGER.log(Level.CONFIG, "Data retrived from jsp and transferred to servlet:");
        try{
	        String productStock = request.getParameter("stock");
	        Product product = new Product(productId,productName,productBrand,productType,productQuantityType,productRate,productStock);
	        ProductBO productBO = new ProductBO();
	        boolean flag = productBO.productAdd(product);
	        request.setAttribute("flagMsg", flag);
	        RequestDispatcher rd=request.getRequestDispatcher("add-product.jsp");
	        rd.forward(request,response);
        }
        catch(java.text.ParseException e){
                        e.printStackTrace();
        }              
        catch(Exception e){
        	RequestDispatcher requestDispatch = request.getRequestDispatcher("existing_product.jsp");
			requestDispatch.forward(request, response);
                        e.printStackTrace();
        }
	}

}
