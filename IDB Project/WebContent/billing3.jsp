<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
              <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style1.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="images/bak.jfif">
<header>
<img src="css/logo.jpg">
<a href="manager_page.jsp">QuickStore</a>
<a class="logout" href="ShopManagerLogoutServlet">Logout</a>
</header>

<form  id="billing" action="SubmitBillingServlet" method="post">
<p>Billing</p>
<br>
<br>

<table class="tab">
<tr>
	<th><label>Product Code</label></th>
	<th><label>Product Name</label></th>
	<th><label>Rate</label></th>
	<th><label>Quantity</label></th>
	<th><label></label></th>
</tr>
<c:forEach items="${billing.productList}" var="product">
<tr>
	<td>${product.product_id}</td>
	<td>${product.product_name}</td>
	<td>${product.rate_per_quantity}</td>
	<td>${product.stock_count}</td>
</tr>
</c:forEach>
		
		<tr>
				<th></th>
				<th>Total</th>
				<th><fmt:formatNumber value="${billing.total}" type="currency" currencySymbol="Rs. "/></th>
				<th></th>
			</tr>
</table>
<td>
Customer ID : 
	<input type="text" name="uid" id="c_id" required="required" value="${billing.customerId}">
	</td>
<br>
<br>
<td>
Phone Number
	<input type="text" name="cpno" id="c_number" required="required" value="${billing.contactNumber}">
	</td>
	<br>
<br>
	<input type="submit" value="Submit"></input>	
	<a href="billing1.jsp"><input type="button" value="Add more"></a>
</form>

</body>
</html>