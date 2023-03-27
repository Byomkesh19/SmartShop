<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style1.css">
<title>Insert title here</title>
</head>
<body background="images/bak.jfif">
<header>
<img src="css/logo.jpg">
<a href="manager_page.jsp">QuickStore</a>
<a class="logout" href="ShopManagerLogoutServlet">Logout</a>
</header>
<form action="BillByIdProductServlet?pid=${product.product_id}" method="post">

<table class="tab">

<tr>
<tr>
<td colspan="4">Product Code : ${product.product_id}</td>
</tr>
<tr>
<td>Product Name : ${product.product_name}
</td>
</tr>
<td>
Customer ID
	<input type="text" name="uid" id="c_id" required="required">
	</td>
	<br><br>
	<td>
Phone Number
	<input type="text" name="cpno" id="c_number" required="required">
	</td>
<tr>
<td>Rate per Quantity : ${product.rate_per_quantity}</td>

<td>Quantity
	<input type="text" name="pqty" id="p_quantity" required="required"/>
</td>
</tr>
<tr>
</tr>

<tr>
	<td><input type="Submit" id="but" value="Add" name="submit"></td>
	</tr>
</table>
</form>
<!-- <form action="SubmitBillingServlet" method="post">
<tr>
<td><input type="submit" id="but" value="Submit" name="submit"></td>
</tr>
</form> -->
</body>
</html>