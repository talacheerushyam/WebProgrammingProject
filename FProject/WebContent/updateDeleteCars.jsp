<%@page import="com.mysql.jdbc.authentication.MysqlClearPasswordPlugin"%>
<%@page import="db.car"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="db.airlines"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/adminHome.css" />
<script type="text/javascript" src="js/flights.js"></script>
<title>View Available Rental Cars</title>
</head>
<body>
<form action="UpdateCarServlet" method="post">
	<div id ="cmainDiv">
			<div class="menuBar"> 
			<ul>
			  <li><a href="adminHome.jsp">Home</a></li>
			  <li><a class="active" href="newFlights.jsp" >Flights</a>
				  <ul>
		            <li><a href="newFlights.jsp">Add Flights</a></li>
		            <li><a href="updateDeleteFlights.jsp">Update Flights</a></li>
		          </ul>
	          </li>
			  <li><a href="newCars.jsp">Rental Car</a>
		  	   	   <ul>
		            <li><a href="newCars.jsp">Add Rental Car</a></li>
		            <li><a href="updateDeleteCars.jsp">Update Rental Car</a></li>
		          </ul>
			  </li>
			  <li><a href="prePayParking.jsp">Pre-Pay Parking Slots</a></li>
			  <li><a href="newDeals.jsp">Deals/Offers</a></li>
			  <li><a href="allOrderHistory.jsp">All Orders</a></li>
			  <li><a href="inventoryAvailable.jsp">Inventory</a></li>
			   <li style="float:right"><a href="index.jsp">Sign out</a></li>
			</ul>
		</div>	
		 <div style="height:1000px; text-align: center">
				<h1>View Available Rental Cars</h1>
				<div class="flightUpdateDiv">
				<table class="flightUdateTable">
				<tr><th></th><th>Car Type</th><th>Car Make</th><th>Cost</th><th></th></tr>
				<%
					car c =  new car();
					c.MysqlOpenConnection();
					ResultSet rs = c.GetAllCars();
					while(rs.next()){
						String car_no = rs.getString("car_no");
						String car_type = rs.getString("car_type");
						String car_make = rs.getString("car_make");
						String rent_cost = rs.getString("rent_cost");
						
						out.println("<tr><td class=UDTD><a href=updateCar.jsp?car_no="+car_no+" target=_self>UPDATE</a></td>");
						out.println("<td class=UDTD>"+car_type+"</td><td class=UDTD>"+car_make+"</td><td class=UDTD>"+rent_cost+"</td>");
						out.println("<td class=UDTD><a href=deleteCar.jsp?car_no="+car_no+" target=_self>DELETE</a></td></tr>");
					}
					c.MysqlOpenConnection();
				%>
				</table>
				</div>
		</div>
	</div>
	</form>
</body>
</html>