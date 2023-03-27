<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style1.css">
<link rel="stylesheet" type="text/css" href="css/buttons.css">
<script type="text/javascript" src="add_product.js"></script>

<title>Insert title here</title>
</head>
<body background="images/bak.jfif" >
<header>
<img src="css/logo.jpg">
<a href="manager_page.jsp" id="qs">QuickStore</a>
<a class="logout" href="ShopManagerLogoutServlet">Logout</a>
</header>

<form class="form" action="AddProductServlet" method="post" onsubmit='return validate()'>
<table id="tab">
	<tr>
  		<td><h1>Add Product</h1></td>
 	</tr>
 	<c:if test="${flagMsg==true}">
		<tr>
			<td>Product Added Successfully</td>
		</tr>
	</c:if>
	<tr>
		<td><h3><label for="name">Product ID</label></h3></td>
	</tr>
	<tr>
		<td><input type="text" id="productid" name="pid" size="50" required="required"/>
	</td>
 	<tr>
  		<td><h3><label for="name">Product Name</label></h3></td>
 	</tr>
	<tr>
		<td><input type="text" id="productname" name="pname" size="50" required="required"/>
		</td>
	</tr>
	<tr>
		<td><h3><label for="brand">Brand</label></h3></td>
	</tr>
	<tr>
		<td><input type="text" id="brand" name="brand" size="50" required="required"/></td>
	</tr>
	<tr>
		<td><h3><label for="product  type">Product Type</label></h3></td>
	</tr>
	<tr>
		<td><input type="text" id="producttype" name="ptype" size="50" required="required"/></td>
	</tr>
	<tr>
		<td><h3><label for="rate"> Quantity Type</label></h3>
	</td>

	<tr>
		<td><input type="text" id="quantity" name="quantity" size="50" required="required"/></td>
	</tr>

	<tr>
		<td><h3><label for="rate">Rate Per Quantity</label></h3>
	</td>

	<tr>
		<td><input type="text" id="rate" name="rate" size="50" required="required"/></td>
	</tr>

		<td><h3><label for="stock">Stock Count</label></h3>
		</td>

	<tr><td><input type="text" id="stock" name="stock" size="50" required="required"/></td></tr>
	<tr>
 		<td><h2><input type="submit" value="Submit" onclick ="return validate()"/></h2></td>
	</tr>
	

</table>
</form>

</body>
</html>