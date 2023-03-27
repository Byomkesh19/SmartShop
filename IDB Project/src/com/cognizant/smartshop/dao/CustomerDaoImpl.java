package com.cognizant.smartshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import com.cognizant.smartshop.model.User;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public void setCustomerDetail(User user) throws Exception {
		Connection connection = ConnectionHandler.getConnection();
		String addUser = SqlQuery.ADD_CUSTOMER_DETAIL;
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
		public boolean checkLogin(User user) throws Exception	{
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
          
                	pst.close();
            con.close();
        return flag;
	
	}

	public String getUserType(String userId) throws Exception {
		
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
