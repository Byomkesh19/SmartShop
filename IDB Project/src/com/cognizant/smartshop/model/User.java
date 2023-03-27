package com.cognizant.smartshop.model;

public class User {
	private String firstName;
	private String lastName;
	private String age;
	private String gender;
	private String contactNumber;
	private String userId;
	private String password;
	private String userType;
	private String firstQuestion;
	private String secondQuestion;
	private String thirdQuestion;
	private String firstAnswer;
	private String secondAnswer;
	private String thirdAnswer;
	private String status;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String firstName, String lastName, String age, String gender, String contactNumber, String userId,
			String password, String userType, String firstQuestion, String secondQuestion, String thirdQuestion,
			String firstAnswer, String secondAnswer, String thirdAnswer) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.userId = userId;
		this.password = password;
		this.userType = userType;
		this.firstQuestion = firstQuestion;
		this.secondQuestion = secondQuestion;
		this.thirdQuestion = thirdQuestion;
		this.firstAnswer = firstAnswer;
		this.secondAnswer = secondAnswer;
		this.thirdAnswer = thirdAnswer;
	}
	
	
	



	public User(String firstName, String lastName, String age, String gender, String contactNumber, String userId,
			String password, String status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.userId = userId;
		this.password = password;
		this.status = status;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public String getFirstQuestion() {
		return firstQuestion;
	}

	public void setFirstQuestion(String firstQuestion) {
		this.firstQuestion = firstQuestion;
	}

	public String getSecondQuestion() {
		return secondQuestion;
	}

	public void setSecondQuestion(String secondQuestion) {
		this.secondQuestion = secondQuestion;
	}

	public String getThirdQuestion() {
		return thirdQuestion;
	}

	public void setThirdQuestion(String thirdQuestion) {
		this.thirdQuestion = thirdQuestion;
	}

	public String getFirstAnswer() {
		return firstAnswer;
	}

	public void setFirstAnswer(String firstAnswer) {
		this.firstAnswer = firstAnswer;
	}

	public String getSecondAnswer() {
		return secondAnswer;
	}

	public void setSecondAnswer(String secondAnswer) {
		this.secondAnswer = secondAnswer;
	}

	public String getThirdAnswer() {
		return thirdAnswer;
	}

	public void setThirdAnswer(String thirdAnswer) {
		this.thirdAnswer = thirdAnswer;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (contactNumber != other.contactNumber)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender
				+ ", contactNumber=" + contactNumber + ", userId=" + userId + ", password=" + password
				+ ", firstAnswer=" + firstAnswer + ", secondAnswer=" + secondAnswer + ", thirdAnswer=" + thirdAnswer
				+ "]";
	}


}
