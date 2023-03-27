<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style1.css">
<script type="text/javascript" src="login_validate.js"></script>
<title>login</title>
</head>
<body background="images/bak.jfif" >
<header>
<img src="css/logo.jpg">
<a href="index.jsp">QuickStore</a>

</header>
<form class="log" action="LoginCustomerServlet" method="post"  onsubmit='return loginValidate()'>
<p>Customer Login</p>
<br><br>
<c:if test="${loginMes==false}"><h2>Wrong Credentials</h2></c:if>
<c:if test="${flag==true}">${userId}</c:if>
<br><br>
Enter User Id:<br>
<input type="text" id="userId" name="userId" required="required">
<br><br>

Enter Password:<br>
<input type="password" id="password" name="password" required="required">
<br><br>
<input type="submit" value="Submit" onclick ="return loginValidate()">

</form>

</body>
</html>