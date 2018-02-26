<%@page import="db.cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/customerHome.css" />
<script type="text/javascript" src="js/customerReg.js"></script>
<title>Customer Home</title>
</head>
<%
if (session.getAttribute("username") == null || session.getAttribute("pass").equals("") ||session.getAttribute("type").equals("")
|| session.getAttribute("username").equals("") || session.getAttribute("pass") == null ||session.getAttribute("type")== null)
{
	String redirectURL= "index.jsp";  
    response.sendRedirect(redirectURL);
}
String userID = (String)session.getAttribute("username");
cart c = new cart();
c.MysqlOpenConnection();
int No_cart = c.GetCart((String)session.getAttribute("username"));
c.MysqlCloseConnection();
%>
<body>
	<div id ="cmainDiv">
		<div class="sidebar">
			<a class="sideLink" href=<%out.print("mycart.jsp?username="+userID);%> target="_self"><%out.print("My Cart("+No_cart+")"); %></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		
		<div class="menuBar"> 
			<ul>
			  <li><a class="active" href="customerHome.jsp">Home</a></li>
			  <li><a href="flightBooking.jsp">Flight Booking</a></li>
			  <li><a href="rentalCar.jsp">Rental Car</a></li>
			  <li><a href="prePayParking.jsp">Pre-Pay Parking</a></li>
			  <li><a href="deals.jsp">Deals/Offers</a></li>
			  <li><a href="orderHistory.jsp">Order History</a></li>
			  <li><a href="profile.jsp">Account/Profile</a></li>
			  <li style="float:right"><a href="index.jsp">Sign out</a></li>
			  
			</ul>
		</div>	
		 <div style="height:1500px;">
				
		</div>
	</div>
</body>
</html>