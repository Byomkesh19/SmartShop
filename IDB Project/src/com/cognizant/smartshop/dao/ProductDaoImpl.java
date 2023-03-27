package com.cognizant.smartshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.smartshop.model.Product;

public class ProductDaoImpl implements ProductDao{


	@Override
	public Product getProduct(String productCode) throws Exception {
		// TODO Auto-generated method stub
		Connection con = ConnectionHandler.getConnection();
		String sql= SqlQuery.SHOW_PRODUCT;
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1,productCode);
		ResultSet resultSet = statement.executeQuery();
		resultSet.next();
		String productId = resultSet.getString(1);
		String productName = resultSet.getString(2);
		String stock = resultSet.getString(3);
		String productType = resultSet.getString(4);
		Date dateOfManufacture = null;
		if(resultSet.getString(5) != null)
			dateOfManufacture = new SimpleDateFormat("YYYY-MM-DD").parse(resultSet.getString(5));
		else
		{
			dateOfManufacture = new Date();
		}
			
		Date dateOfExpiry = null;
		if(resultSet.getString(6) != null)
			dateOfExpiry = new SimpleDateFormat("YYYY-MM-DD").parse(resultSet.getString(6));
		else
			dateOfExpiry = new Date();
		Product product = new Product(productId,productName,productType,stock,dateOfManufacture,dateOfExpiry);
		con.close();
		statement.close();
		return product;
	}

	@Override
	public void removeProduct(String productCodeId) throws Exception {
		
        Connection con=ConnectionHandler.getConnection();
        String query = SqlQuery.DELETE_PRODUCT_FROM_PURCHASE;
        String sql = SqlQuery.DELETE_PRODUCT;
        PreparedStatement pst=con.prepareStatement(query);
        PreparedStatement statement=con.prepareStatement(sql);
        pst.setString(1,productCodeId);
        statement.setString(1, productCodeId);
        pst.executeUpdate();
        
        statement.executeUpdate();
        con.close();
        pst.close();
        statement.close();
	}

	@Override
	public List<Product> searchProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProduct(Product product) throws Exception {
		
		
		 Connection con=ConnectionHandler.getConnection();
		 String sql = SqlQuery.ADD_PRODUCT;
	     PreparedStatement pst=con.prepareStatement(sql);
	     pst.setString(1,product.getProduct_id());
	     pst.setString(2,product.getProduct_name());
	     pst.setString(4,product.getBrand());
	     pst.setString(3,product.getType());
	     pst.setString(5,product.getQuantity_type());
	     pst.setString(6,product.getRate_per_quantity());
	     pst.setString(7,product.getStock_count());
	     pst.executeUpdate();
			
		}

	@Override
	public void modifyProduct(Product product) throws Exception {
		
		Connection con=ConnectionHandler.getConnection();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String sql = SqlQuery.UPDATE_PRODUCT;
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setString(1,product.getProduct_name());
        pst.setString(2,product.getType());
        pst.setString(3,product.getStock_count());
        Date dateOfManufacture=product.getDate_of_manufacture();
        String strDateOfManufacture = dateFormat.format(dateOfManufacture);
        pst.setString(4, strDateOfManufacture);
        Date dateOfExpiry=product.getDate_of_expiry();
        String strDateOfExpiry = dateFormat.format(dateOfExpiry);
        pst.setString(5,strDateOfExpiry);
        pst.setString(6,product.getProduct_id());
        pst.executeUpdate();
        con.close();
        pst.close();
		
	}

	@Override
	public List<Product> getAllProduct(String productType) throws Exception {
		
        Connection con=ConnectionHandler.getConnection();
        ArrayList<Product> product_list=new ArrayList<>();
        String sql = SqlQuery.SHOW_ALL_PRODUCT;
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setString(1, productType);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
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
            Date date_of_manufacture=rs.getDate(11);
            Date date_of_expiry=rs.getDate(12);
            Product productObj = new Product(product_id,product_name,brand,type,quantity_type,rate_per_quantity,stock_count,date,aisle,shelf,date_of_manufacture,date_of_expiry);
            product_list.add(productObj);
        }
        con.close();
        pst.close();
        return product_list;                                         

	}

}
