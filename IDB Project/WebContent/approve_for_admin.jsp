<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style3.css">
</head>
<body>
<body  background="images/bak.jfif">
<header>
<img src="css/logo.jpg">
<a href="admin_page.jsp">QuickStore</a>
</header>


<form action="ApproveManagerServlet?uid=${user.userId}" method="post">
<h2><label>Pending Approvals</label></h2>
<table >
<tr>
<th><label>User ID</label></th>
<th><label>Name</label></th>
<th><label>Status</label></th>
<th></th>
</tr>

<tr>
<td>${user.userId}</td>
<td>${user.firstName} ${user.lastName}</td>


<td><input type="radio" id="Approved" name="a" value="A">
<label for="Approved">Approve</label>
 <input type="radio" id="Denied" name="a" value="D">
 <label for="Denied">Deny</label></td>
 <td><input type="submit" value="Change">
</td>
</tr>
<tr></td></tr>
</table>
</form>
</body>
</html>