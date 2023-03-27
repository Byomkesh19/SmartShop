<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style1.css">
<title>shelf and aisle update</title>
</head>
<body background="images/bak.jfif">
<header>
<img src="css/logo.jpg">
<a href="manager_page.jsp">QuickStore</a>
<a class="logout" href="ShopManagerLogoutServlet">Logout</a>
</header>
<form action="EditMenuItemServlet?menuItemId=${menuItem.id}" method="post">
<!-- <p><c:if test="${addCartStatus==true}">Details Updated Successfully</c:if><p>-->
<h1>Update Shelf and Aisle</h1>
<br>

<table class="tab">


<tr>
<td colspan="4" name="p_code">Product Code <br>
	<input type="text" id="p_code" name="p_code" size="55" required="required" value="${menuItem.name}"></td>
</tr>
<tr>
<td colspan="4" name="p_name">Product Name<br>
	<input type="text" id="p_name" name="p_name" size="80" required="required" value="${menuItem.name}" readonly></td>
</tr>
<tr>
<td name="shelf_no">Shelf Number
<input type="text" name="shelf_no" id="shelf_no" required="required" value="${menuItem.price}"></td>

<td >Aisle
	<input type="text" name="aisle" id="aisle" required="required" ></td>
</td>

</tr>
<tr>
<td><input type="submit" id="but" value="Submit" name="submit" onclick="">
</td>
</tr>

</table>
</form>
</body>
</html>