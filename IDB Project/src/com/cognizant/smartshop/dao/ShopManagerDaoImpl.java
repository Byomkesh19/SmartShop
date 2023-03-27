package com.cognizant.smartshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.smartshop.model.Billing;
import com.cognizant.smartshop.model.Product;
import com.cognizant.smartshop.model.User;

public class ShopManagerDaoImpl implements ShopManagerDao
{

	@Override
	public void setShopManagerDetail(User user) throws Exception {
		Connection connection = ConnectionHandler.getConnection();
		String addUser = SqlQuery.ADD_SHOP_MANAGER_DETAIL;
		PreparedStatement statement = connection.prepareStatement(addUser);
		statement.setString(1, user.getFirstName());
		statement.setString(2, user.getLastName());
		statement.setString(3, user.getAge());
		statement.setString(4, user.getGender());
		statement.setString(5, user.getContactNumber());
		statement.setString(6, user.getUserId());
		statement.setString(7, user.getPassword());
		statement.setString(8, user.getUserType());
		statement.setString(9, user.getFirstQuestion());
		statement.setString(10, user.getSecondQuestion());
		statement.setString(11, user.getThirdQuestion());
		statement.setString(12, user.getFirstAnswer());
		statement.setString(13, user.getSecondAnswer());
		statement.setString(14, user.getThirdAnswer());

		statement.executeUpdate();
		connection.close();
		statement.close();
		
	}

	@Override
	public boolean checkLoginShopManager(User user) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
        Connection con = ConnectionHandler.getConnection();
        String sql = SqlQuery.VALIDATE;
        PreparedStatement pst =con.prepareStatement(sql);
        pst.setString(1,user.getUserId());
        pst.setString(2, user.getPassword());
        ResultSet rs = pst.executeQuery();
        rs.next();
          try
          {
        	 String ss=rs.getString(1);
        	 flag=true;
          }catch(Exception e)
          {
        	  flag=false;
          }
          finally{
        
        	pst.close();
            con.close();
          }
        return flag;
	}
	@Override
	public List<Product> showProductForBillingByType(String productType) throws Exception {
		// TODO Auto-generated method stub
		Connection con=ConnectionHandler.getConnection();
		String sql="Select  product_code,product_name,brand,product_type,quantity_type,rate_per_quantity,stock_count,add_date,aisle,shelf from product where product_type=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,productType);
		ResultSet rs=pst.executeQuery();
		Product product =null;
		List<Product> arrayList=new ArrayList<Product>();
		while(rs.next())
		{
			String product_id=rs.getString(1);
			String product_name=rs.getString(2);
			String brand=rs.getString(3);
			String type=rs.getString(4);
			String quantity_type=rs.getString(5);
			String rate_per_quantity=rs.getString(6);
			String stock_count=rs.getString(7);
			Date date=rs.getDate(8);
			String aisle=rs.getString(9);
			String shelf=rs.getString(10);
			Date date_of_manufacture=null;//rs.getDate(11);
			Date date_of_expiry=null;//rs.getDate(12);
			 product = new Product(product_id,product_name,brand,type,quantity_type,rate_per_quantity,stock_count,date,aisle,shelf,date_of_manufacture,date_of_expiry); 
			 arrayList.add(product);
		}
		con.close();
		pst.close();
		return arrayList;
	}
	@Override
	public Product getProduct(String productId) throws Exception {
		// TODO Auto-generated method stub
		Connection con=ConnectionHandler.getConnection();
		String sql="Select product_code,product_name,brand,product_type,quantity_type,rate_per_quantity,stock_count,add_date,aisle,shelf,date_of_manufacture,date_of_expiry from product where product_code=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,productId);
		ResultSet rs=pst.executeQuery();
		 if(rs.next()){
		 	String product_id1=rs.getString(1);
			String product_name=rs.getString(2);
			String brand=rs.getString(3);
			String type=rs.getString(4);
			String quantity_type=rs.getString(5);
			String rate_per_quantity=rs.getString(6);
			String stock_count=rs.getString(7);
			Date date=rs.getDate(8);
			String aisle=rs.getString(9);
			String shelf=rs.getString(10);
			Date date_of_manufacture=null;//rs.getDate(11);
			Date date_of_expiry=null;//rs.getDate(12);
			Product product = new Product(product_id1,product_name,brand,type,quantity_type,rate_per_quantity,stock_count,date,aisle,shelf,date_of_manufacture,date_of_expiry);
			con.close();
			pst.close();

			return product;
		 }

		 else{
			Product product1=new Product();
			con.close();	
			pst.close();

			return product1;
		 }
	}
	@Override
	public void updateStockOfProduct(String productId,String productQuantity) throws Exception {
		// TODO Auto-generated method stub
		Connection con=ConnectionHandler.getConnection();
		String sql="Select stock_count from product where product_code=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,productId);
		ResultSet rs=pst.executeQuery();
		rs.next();
		int qty=Integer.parseInt(rs.getString(1));
		int q=Integer.parseInt(productQuantity);
		int uqty=qty-q;
		String upadatedQuantity=Integer.toString(uqty);
		String sql1="Update product set stock_count=? where product_code=?";
		pst=con.prepareStatement(sql1);
		pst.setString(2,productId);
		pst.setString(1,upadatedQuantity);
		pst.executeUpdate();
		con.close();
		pst.close();
	}
	
	@Override
	public void updatePurchaseHistory(String productId, String userId,String productQuantity) throws Exception {
		// TODO Auto-generated method stub
		Connection con=ConnectionHandler.getConnection();
		String sql="Insert into purchase (user_id,product_code,quantity,buy_date,check_bill)values(?,?,?,CURDATE(),'true')";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,userId);
		pst.setString(2,productId);
		pst.setString(3,productQuantity);
		pst.executeUpdate();
		con.close();
		pst.close();
	}
	
	@Override
	public Billing showAllProductInBill(String userId,String customerPhoneNumber,String productQuantity) throws Exception{
		Connection con=ConnectionHandler.getConnection();
		String sql="Select pr.product_code,pr.product_name,pr.brand,pr.product_type,pr.quantity_type,pr.rate_per_quantity,pr.stock_count,pr.add_date,pr.aisle,pr.shelf,pr.date_of_manufacture,pr.date_of_expiry from product pr join purchase ps where ps.user_id=? and ps.check_bill='true' and pr.product_code=ps.product_code and ps.buy_date=CURDATE()";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,userId);
		ArrayList<Product> productList=new ArrayList<>();
		ResultSet rs=pst.executeQuery();
		Product product=null;
		while(rs.next())
		{

			String product_id=rs.getString(1);
			String product_name=rs.getString(2);
			String brand=rs.getString(3);
			String type=rs.getString(4);
			String quantity_type=rs.getString(5);
			String rate_per_quantity=rs.getString(6);
			String stock_count=rs.getString(7);
			Date date=rs.getDate(8);
			String aisle=rs.getString(9);
			String shelf=rs.getString(10);
			Date date_of_manufacture=null;//rs.getDate(11);
			Date date_of_expiry=null;//rs.getDate(12);
			product = new Product(product_id,product_name,brand,type,quantity_type,rate_per_quantity,stock_count,date,aisle,shelf,date_of_manufacture,date_of_expiry);
	        productList.add(product);
	}
		double total=0;
		 double ftotal=0;
	        String sql2="Select sum(pr.rate_per_quantity),ps.quantity from product pr join purchase ps where ps.user_id=? and ps.check_bill='true' and pr.product_code=ps.product_code";
	        pst=con.prepareStatement(sql2);
			pst.setString(1,userId);
			ResultSet rs1=pst.executeQuery();
			while(rs1.next()){
			String total1=rs1.getString(1);
			Double quant=rs1.getDouble(2);
			total=(Double.parseDouble(total1));
			System.out.println(total);
			ftotal=total*quant;
			
			}
			con.close();
			pst.close();
			return new Billing(productList,ftotal,userId,customerPhoneNumber);
	}
	@Override
	public Billing showPurchaseHistory(String userId) throws Exception {
		// TODO Auto-generated method stub
		Connection con=ConnectionHandler.getConnection();
		String sql="Select pr.product_code,pr.product_name,pr.brand,pr.product_type,pr.quantity_type,pr.rate_per_quantity,pr.stock_count,pr.add_date,pr.aisle,pr.shelf,pr.date_of_manufacture,pr.date_of_expiry,ps.buy_date from product pr join purchase ps where ps.user_id=? and pr.product_code=ps.product_code";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,userId);
		String customerPhoneNumber=null;
		ArrayList<Product> productList=new ArrayList<>();
		ResultSet rs=pst.executeQuery();
		Product product=null;
		String buyDate=null;
		while(rs.next())
		{
			String product_id=rs.getString(1);
			String product_name=rs.getString(2);
			String brand=rs.getString(3);
			String type=rs.getString(4);
			String quantity_type=rs.getString(5);
			String rate_per_quantity=rs.getString(6);
			String stock_count=rs.getString(7);
			Date date=rs.getDate(8);
			String aisle=rs.getString(9);
			String shelf=rs.getString(10);
			Date date_of_manufacture=null;//rs.getDate(11);
			Date date_of_expiry=null;//rs.getDate(12);
			buyDate=rs.getString(13);
			product = new Product(product_id,product_name,brand,type,quantity_type,rate_per_quantity,stock_count,date,aisle,shelf,date_of_manufacture,date_of_expiry);
	        productList.add(product);      
		}
		double total=0;
		 double ftotal=0;
	        String sql2="Select sum(pr.rate_per_quantity),ps.quantity from product pr join purchase ps where ps.user_id=? and pr.product_code=ps.product_code";
	        pst=con.prepareStatement(sql2);
			pst.setString(1,userId);
			ResultSet rs1=pst.executeQuery();
			Billing bill = null;
			while(rs1.next()){
			String total1=rs1.getString(1);
			Double quant=rs1.getDouble(2);
			total=(Double.parseDouble(total1));
			ftotal=total*quant;
			}
			bill = new Billing(productList,ftotal,userId,customerPhoneNumber,buyDate);
			con.close();
			pst.close();
			return bill;
	}
	@Override
	public Billing billProduct(String userId,String customerPhoneNumber) throws Exception {
		// TODO Auto-generated method stub
		Connection con=ConnectionHandler.getConnection();
		String sql="Select pr.product_code,pr.product_name,pr.brand,pr.product_type,pr.quantity_type,pr.rate_per_quantity,pr.stock_count,pr.add_date,pr.aisle,pr.shelf,pr.date_of_manufacture,pr.date_of_expiry from product pr join purchase ps where ps.user_id=? and ps.check_bill='true' and pr.product_code=ps.product_code";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,userId);
		ArrayList<Product> productList=new ArrayList<>();
		ResultSet rs=pst.executeQuery();
		Product product=null;
		while(rs.next())
		{
			String product_id=rs.getString(1);
			String product_name=rs.getString(2);
			String brand=rs.getString(3);
			String type=rs.getString(4);
			String quantity_type=rs.getString(5);
			String rate_per_quantity=rs.getString(6);
			String stock_count=rs.getString(7);
			Date date=rs.getDate(8);
			String aisle=rs.getString(9);
			String shelf=rs.getString(10);
			Date date_of_manufacture=null;//rs.getDate(11);
			Date date_of_expiry=null;//rs.getDate(12);
			product = new Product(product_id,product_name,brand,type,quantity_type,rate_per_quantity,stock_count,date,aisle,shelf,date_of_manufacture,date_of_expiry);
	        productList.add(product);
	}
		double total=0;
		 double ftotal=0;
	        String sql2="Select sum(pr.rate_per_quantity),ps.quantity from product pr join purchase ps where ps.user_id=? and ps.check_bill='true' and pr.product_code=ps.product_code";
	        pst=con.prepareStatement(sql2);
			pst.setString(1,userId);
			ResultSet rs1=pst.executeQuery();
			while(rs1.next()){
			String total1=rs1.getString(1);
			Double quant=rs1.getDouble(2);
			total=(Double.parseDouble(total1));
			ftotal=total*quant;
			}

		 String sql3="Update user set contact_number=? where user_id=?";
		 pst=con.prepareStatement(sql3);
		 pst.setString(2,userId);
		 pst.setString(1,customerPhoneNumber);
		 pst.executeUpdate();
		 
		 String sql4="Update purchase set check_bill='false' where user_id=?";
		 pst=con.prepareStatement(sql4);
		 pst.setString(1,userId);
		 pst.executeUpdate();
		 con.close();
		 pst.close();
		 return new Billing(productList,ftotal,userId,customerPhoneNumber);//productList,total,userId
		
		
	}
	@Override
	public void updateAisleAndSelfDetails(String productId, String aisle, String shelf) throws Exception {
		// TODO Auto-generated method stub
			Connection con=ConnectionHandler.getConnection();
			String sql="Update product set aisle=?,shelf=? where product_code=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(3,productId);
			pst.setString(1,aisle);
			pst.setString(2,shelf);
			pst.executeUpdate();
			con.close();
			pst.close();
	}


@Override
public void approveShopManager(String status,String userId) throws Exception {
	// TODO Auto-generated method stub
	Connection con=ConnectionHandler.getConnection();
	String sql="Update user set status=? where user_id=?";
	PreparedStatement pst=con.prepareStatement(sql);
	pst.setString(1,status);
	pst.setString(2,userId);
	pst.executeUpdate();
	con.close();
	pst.close();


}

@Override
public List<User> getUser() throws Exception {
		// TODO Auto-generated method stub
		Connection con=ConnectionHandler.getConnection();
		String sql="Select first_name,last_name,age,gender,contact_number,user_id,password,user_type,status,first_question,first_answer,second_question,second_answer,third_question,third_answer from user where status='P'";
		PreparedStatement pst=con.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		List<User> arrlist=new ArrayList<>();
		while(rs.next())
		{
		String first_name=rs.getString(1);
		String last_name=rs.getString(2);
		String age=rs.getString(3);
		String gender=rs.getString(4);
		String contact_number=rs.getString(5);
		String user_id=rs.getString(6);
		String password=rs.getString(7);
		String user_type=rs.getString(8);
		String status=rs.getString(9);
		String first_question=rs.getString(10);
		String first_answer=rs.getString(11);
		String second_question=rs.getString(12);
		String second_answer=rs.getString(13);
		String third_question=rs.getString(14);
		String third_answer=rs.getString(15);
		User user=new User(first_name,last_name,age,gender,contact_number,user_id,password,status);
		arrlist.add(user);
	}
		con.close();
		pst.close();
		
		
		return arrlist;
	}
@Override
public User getUserById(String userId) throws Exception {
	// TODO Auto-generated method stub
	Connection con=ConnectionHandler.getConnection();
	String sql="Select first_name,last_name,age,gender,contact_number,user_id,password,user_type,status,first_question,first_answer,second_question,second_answer,third_question,third_answer from user where user_id=?";
	PreparedStatement pst=con.prepareStatement(sql);
	pst.setString(1,userId);
	ResultSet rs=pst.executeQuery();
	List<User> arrlist=new ArrayList<>();
	rs.next();
	
	String first_name=rs.getString(1);
	String last_name=rs.getString(2);
	String age=rs.getString(3);
	String gender=rs.getString(4);
	String contact_number=rs.getString(5);
	String user_id=rs.getString(6);
	String password=rs.getString(7);
	String user_type=rs.getString(8);
	String status=rs.getString(9);
	String first_question=rs.getString(10);
	String first_answer=rs.getString(11);
	String second_question=rs.getString(12);
	String second_answer=rs.getString(13);
	String third_question=rs.getString(14);
	String third_answer=rs.getString(15);
	User user=new User(first_name,last_name,age,gender,contact_number,user_id,password,status);
	con.close();
	pst.close();
	return user;
	
	
}

@Override
public String getStatus(String userId) throws Exception {
	Connection con = ConnectionHandler.getConnection();
	String query = "select status from user where user_id=?";
	PreparedStatement prepare = con.prepareStatement(query);
	prepare.setString(1, userId);
	ResultSet result = prepare.executeQuery();
	result.next();
	String status = result.getString(1);
	con.close();
	prepare.close();
	return status;
}

@Override
public String getUserType(String userId) throws Exception {
	// TODO Auto-generated method stub
	Connection con = ConnectionHandler.getConnection();
	String query = "select user_type from user where user_id=?";
	PreparedStatement prepare = con.prepareStatement(query);
	prepare.setString(1,userId);
	ResultSet result = prepare.executeQuery();
	result.next();
	String userType = result.getString(1);
	con.close();
	prepare.close();
	return userType;
}
}
	

