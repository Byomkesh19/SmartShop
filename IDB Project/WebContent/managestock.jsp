<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style1.css">
<script type="text/javascript" src="modify_stock.js"></script>
</head>
<body  background="images/bak.jfif" >

<header>
<img src="css/logo.jpg" width="28" height="28">
<a href="manager_page.jsp">QuickStore</a>
<a id="ab" href="logo.jpg"></a>
<a class="logout" href="ShopManagerLogoutServlet">Logout</a>
 </header>

<form class="stockmod" action="ModifyProductServlet?productId=${productDetails.product_id}" method="post" onsubmit='return validate()'>
<table id="tab">


 <tr>
  <td><h1>Manage Stock</h1></td>
 </tr>
<tr>
<td><input type="hidden" id="productid" name="productId" size="100" value="${productDetails.product_id}"/>
</td>
</tr>
<tr>
<td><h3><label for="name">Product Name</label></h3></td>
</tr>
<tr>
<td><input type="text" id="productname" name="pname" size="100" value="${productDetails.product_name}"/>
</td>
</tr>
<tr>
<td><h3><label for="brand">Number of Items Available</label></h3></td>
</tr>

<tr>
<td><input type="text" id="brand" name="pstock" size="100" value="${productDetails.stock_count}"/></td>
</tr>

<td>
<h3><label for="ptype">Product Type</label></h3></td>
</tr>

<tr>
 <td><input type="text" id="producttype" name="productType" size="100" value="${productDetails.type}" readonly/></td>
<!--<td><c:out value="${productDetails.type}"></c:out></td> -->
</tr>

<td><h3><label for="rate">Date Of Manufacturing</label></h3>
</td>

<tr>
<td><input type="date" id="quantity" name="manufacture_date" size="100" value=<fmt:formatDate type="date" pattern="yyyy-MM-dd" value="${productDetails.date_of_manufacture}"/>/>
</td>
</tr>

<td><h3><label for="stock">Date of Expiry</label></h3></td>
<tr><td><input type="date" id="stock" name="expiry_date" size="100" value=<fmt:formatDate type="date" pattern="yyyy-MM-dd" value="${productDetails.date_of_expiry}"/>/></td></tr>

<tr>
<td>
<input type="submit" value="Submit" onclick ="return validate()"/>
</td>
</tr>
</table>

</form>

</body>

</html>
