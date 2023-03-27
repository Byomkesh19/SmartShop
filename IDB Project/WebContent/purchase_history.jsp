<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
                  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchase history</title>
<link rel="stylesheet" type="text/css" href="css/style1.css">
<script src="js/homepage2.js"></script>
</head>
<body background="images/bak.jfif">
<header>
<img src="css/logo.jpg">
<a href="manager_page.jsp">QuickStore</a>
<a class="logout" href="ShopManagerLogoutServlet">Logout</a>
</header>

<br>
<br>
<form>
<h1>Purchase History</h1>
<br>
<table width="70%">
<tr>
<th><label>Date of Purchase</label></th>
<th><label>Product Code</label></th>
<th><label>Product Name</label></th>
<th><label>Product Type</label></th>
<th><label>Brand</label></th>
<th><label>Customer ID</label></th>
</tr>


<c:forEach items="${billing.productList}" var="product" >
<tr>
<td>${billing.buyDate}</td>
<td>${product.product_id}</td>
<td>${product.product_name}</td>
<td>${product.brand}</td>
<td>${product.type}</td>


<br>
<br>
<br>
<td>${billing.customerId}</td>


</tr>

</c:forEach>

</table>
</form>


</body>
</html>