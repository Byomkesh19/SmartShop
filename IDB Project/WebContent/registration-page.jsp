<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style1.css">
<script type="text/javascript" src="validation.js"></script>
<title>Insert title here</title>
</head>
<body background="images/bak.jfif">
<header>
<img src="css/logo.jpg">
<a href="index.jsp">QuickStore</a>
</header>
<form id="registration" onsubmit='return validate()' action="RegistrationServlet" method="post">
<p>Registration</p>
<br>
<br>
First Name:<br><input type="text" placeholder="First Name" name="firstname" id="firstname">
<br>
<br>
Last Name:<br><input type="text" placeholder="Last Name" name="lastname" id="lastname">
<br>
<br>
Age:<br><input type="text" placeholder="Age" name="age" id="age">
<br>
<br>
Gender:<br><input type="radio"  name="gender" id="male" value="male" ><label for="male">Male</label>
<input type="radio"  name="gender" id="female" value="female"><label for="male">Female</label>
<input type="radio" name="gender" id="other" value="other"><label for="other">Other</label>
<br>
<br>
Contact Number:<br><input type="text" placeholder="Contact number" name="number" id="number">
<br>
<br>
UserID:<br><input type="text" placeholder="UserId" name="userid" id="userid">
<br>
<br>
Password:<br><input type="password" placeholder="Password" name="password" id="password">
<br>
<br>
User Type:<br><input type="radio" name="type" id="admin" value="A"><label for="admin">Admin</label>
<input type="radio" name="type" id="user" value="U"><label for="user">User</label>
<br>
<br>

Secret Question 1:
		<br>
		<select name="firstQuestion">
		  <option></option>
		  <option value="What was the name of your 1st pet?">What was the name of your 1st pet?</option>
		  <option value="What is the name of your First school?">What is the name of your First school?</option>
		  <option value="What is your mother's maiden name?">What is your mother's maiden name?</option>
		  <option value="What is/was favorite subject in school?">What is/was favorite subject in school?</option>
		</select>
		<br>
		<input type="text" placeholder="Secret Answer 1" name="firstAnswer">
		<br>
		<br>
		Secret Question 2:
		<br>
		<select name="secondQuestion">
		  <option></option>
		  <option value="What was the name of your 1st pet?">What was the name of your 1st pet?</option>
		  <option value="What is the name of your First school?">What is the name of your First school?</option>
		  <option value="What is your mother's maiden name?">What is your mother's maiden name?</option>
		  <option value="What is/was favorite subject in school?">What is/was favorite subject in school?</option>
		</select>
		<br>
		<input type="text" placeholder="Secret Answer 2" name="secondAnswer">
		<br>
		<br>
		Secret Question 3:
		<br>
		<select name="thirdQuestion">
		  <option></option>
		   <option value="What was the name of your 1st pet?">What was the name of your 1st pet?</option>
		  <option value="What is the name of your First school?">What is the name of your First school?</option>
		  <option value="What is your mother's maiden name?">What is your mother's maiden name?</option>
		  <option value="What is/was favorite subject in school?">What is/was favorite subject in school?</option>
		</select>
		<br>
		<input type="text" placeholder="Secret Answer 3" name="thirdAnswer">
		<br>
		<br>
<input type="submit" value="Submit" onclick ="return validate()">
</form>

</body>
</html>