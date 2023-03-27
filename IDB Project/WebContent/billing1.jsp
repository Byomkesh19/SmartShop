<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style6.css">
<script src="js/homepage2.js"></script>

</head>
<body id="homep1" background="images/bak.jfif">

<header>
<img id="imag" src="css/logo.jpg">
<a href="manager_page.jsp">QuickStore</a>
<a class="logout" href="ShopManagerLogoutServlet">Logout</a>
</header>




<!-- MAIN (Center website) -->
<div class="main">

<h1></h1>
<hr>

<h2>Billing</h2>

<div id="myBtnContainer">

  <button class="btn" onclick="filterSelection('electronics')"> Electronics</button>
  <button class="btn" onclick="filterSelection('home')">Furniture</button>
  <button class="btn" onclick="filterSelection('fashion')">Fashion</button>
  <button class="btn" onclick="filterSelection('footwear')">Footwear</button>
  <button class="btn" onclick="filterSelection('beauty')">Beauty</button>
</div>
<form action="SearchProductByIdServlet" method="post">
<div>
 <input id="search" type="text" name="spid" placeholder="Search..">
 <input type="Submit" id="search" value="Search">
 </div>
</form>
<!-- Portfolio Gallery Grid -->
<div class="row">
  <div class="column electronics">
    <div class="content">
      <img src="images/elec.jpeg" alt="Mountains" style="width:100%">
      <h4><a href="ElectronicsBillingDisplayServlet?ptype=${1}">Electronics</a></h4>
     
    </div>
  </div>
  <div class="column home">
    <div class="content">
    <img src="images/homeapp.jpg" alt="Lights" style="width:100%">
      <h4><a href="FurnitureBillingDisplayServlet?ptype=${2}">Furniture</a></h4>
     
    </div>
  </div>
  <div class="column fashion">
    <div class="content">
    <img src="images/fashion.jpg" alt="Nature" style="width:100%">
      <h4><a href="FashionBillingDisplayServlet?ptype=${3}">Fashion</a></h4>
      <p></p>
    </div>
  </div>
  </div>
  <div class="row">
  <div class="column footwear">
    <div class="content">
    
      <img src="images/shoes.jpeg" alt="Car" style="width:100%">
      <h4><a href="FootwearBillingDisplayServlet?ptype=${4}">Footwear</h4>
      
    </div>
  </div>
  <div class="column beauty">
    <div class="content">
    <img src="images/makeup.jpg" alt="Car" style="width:100%">
      <h4><a href="BeautyBillingDisplayServlet?ptype=${5}">Beauty</h4>
      
    </div>
    </div>
  </div>
  </div>
<!-- END GRID -->
</div>

<!-- END MAIN -->
</div>


</body>
</html>