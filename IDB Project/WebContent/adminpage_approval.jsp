<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Pending Approval</title>
<link rel="stylesheet" type="text/css" href="css/style3.css">

</head>
<body  background="images/bak.jfif">
<header>
<img src="css/logo.jpg">
<a href="admin_page.jsp">QuickStore</a>
</header>
<form>

<h2><label>Pending Approvals</label></h2>
<table >
<tr>
<th><label>User ID</label></th>
<th><label>Name</label></th>
<th><label>Status</label></th>



</tr>


<c:forEach items="${user}" var="user" >
<tr>
<td>${user.userId}</td>
<td>${user.firstName} ${user.lastName}</td>


<td>${user.status}</td>
<td><a href="PendingApprovalServlet?uid=${user.userId}">Change</a></td>
<br>
<br>
</tr>

</c:forEach>

</table>
</form>
<br>
</body>
</html>