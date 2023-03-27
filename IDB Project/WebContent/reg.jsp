<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style1.css">
<script type="text/javascript" src="validation.js"></script>
<title>Insert title here</title>
</head>
<body background="css/loginpage.jpg">
<header id="head">
<img src="css/logo.jpg">
QuickStore
</header>
<form id="registration" action="RegistrationServlet" method="post" onsubmit='return validate()'>
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
<input type="radio"  name="gender" id="female" value="female"><label for="female">Female</label>
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
User Type:<br><input type="radio" name="type" id="admin"><label for="admin">Admin</label>
<input type="radio" name="type" id="user"><label for="user">User</label>
<br>
<br>
Status:
<br>
<br>
Secret Question 1:
<br>
<select>
  <option></option>
  <option>What was the name of your 1st pet?</option>
  <option>What is the name of your First school?</option>
  <option>What is your mother's maiden name?</option>
  <option>What is/was favorite subject in school?</option>
</select>
<br>
<input type="text" placeholder="Secret Answer 1" name="">
<br>
<br>
Secret Question 2:
<br>
<select>
  <option></option>
  <option>What was the name of your 1st pet?</option>
  <option>What is the name of your First school?</option>
  <option>What is your mother's maiden name?</option>
  <option>What is/was favorite subject in school?</option>
</select>
<br>
<input type="text" placeholder="Secret Answer 2" name="">
<br>
<br>
Secret Question 3:
<br>
<select>
  <option></option>
  <option>What was the name of your 1st pet?</option>
  <option>What is the name of your First school?</option>
  <option>What is your mother's maiden name?</option>
  <option>What is/was favorite subject in school?</option>
</select>
<br>
<input type="text" placeholder="Secret Answer 3" name="">
<br>
<br>
<input type="submit" value="submit" onclick="return validate()">

</form>

</body>
</html>
