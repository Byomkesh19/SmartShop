package com.cognizant.smartshop.model;

public class ShopManager extends User {

	public ShopManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShopManager(String firstName, String lastName, String age, String gender, String contactNumber,
			String userId, String password, String userType, String firstQuestion, String secondQuestion,
			String thirdQuestion, String firstAnswer, String secondAnswer, String thirdAnswer) {
		super(firstName, lastName, age, gender, contactNumber, userId, password, userType, firstQuestion, secondQuestion,
				thirdQuestion, firstAnswer, secondAnswer, thirdAnswer);
		// TODO Auto-generated constructor stub
	}

	public ShopManager(String userId, String password) {
		super(userId, password);
		// TODO Auto-generated constructor stub
	}

}
