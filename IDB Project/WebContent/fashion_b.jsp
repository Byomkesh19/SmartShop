<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style1.css">
<script src="js/homepage2.js"></script>
</head>
<body background="images/bak.jfif">
<header>
<img src="css/logo.jpg">
<a href="manager_page.jsp">QuickStore</a>
<a class="logout" href="ShopManagerLogoutServlet">Logout</a>
</header>

<form>
<table class="tab">
<tr>
<th><label>Product Code</label></th>
<th><label>Product Name</label></th>
<th><label>Product Type</label></th>
<th><label>Brand</label></th>
<th><label>Rate per Quantity</label></th>

</tr>


<c:forEach items="${productList}" var="product" >
<tr>	
		<td>${product.product_id}</td>
		<td>${product.product_name}</td>
		<td>${product.type}</td>
		<td>${product.brand}</td>
		<td>${product.rate_per_quantity}</td>
	

<td><a href="ShowBillingProductServlet?pid=${product.product_id}">Add</a>
</tr>

</c:forEach>

</table>
</form>


</body>
</html>