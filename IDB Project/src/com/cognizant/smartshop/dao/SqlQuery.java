package com.cognizant.smartshop.dao;

public final class SqlQuery {
	public static final String ADD_CUSTOMER_DETAIL =  "insert into user values(?,?,?,?,?,?,?,?,'A',?,?,?,?,?,?);"; //change to user after trial run
	public static final String VALIDATE= "SELECT user_id,password FROM user WHERE user_id = ? and password = ?;";
	public static final String ADD_SHOP_MANAGER_DETAIL = "insert into user values(?,?,?,?,?,?,?,?,'P',?,?,?,?,?,?);";//change to user after trial run
	public static final String ADD_PRODUCT = "insert into product(product_code,product_name,product_type,brand,quantity_type,rate_per_quantity,stock_count) values(?,?,?,?,?,?,?);";
	public static final String UPDATE_PRODUCT = "Update product set product_name=?, product_type=?, stock_count=?, date_of_manufacture=?, date_of_expiry=? where product_code=?;";//parameter index error
	public static final String SHOW_PRODUCT = "Select product_code, product_name, stock_count, product_type, date_of_manufacture, date_of_expiry from product where product_code=?;";
	public static final String DELETE_PRODUCT = "delete from product where product_code=?";
	public static final String DELETE_PRODUCT_FROM_PURCHASE = "delete from purchase where product_code=?";
	public static final String DELETE_PRODUCT_FROM_SEARCH = "delete from search where product_code=?";
	public static final String SHOW_ALL_PRODUCT = "Select * from product where product_type=?";
}
