<%@page import="com.mysql.jdbc.authentication.MysqlClearPasswordPlugin"%>
<%@page import="db.flights"%>
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
<title>View Available Flights</title>
</head>
<body>
<form action="UpdateFlightServlet" method="post">
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
				<h1>View All Flights Available</h1>
				<div class="flightUpdateDiv">
				<table class="flightUdateTable">
				<tr><th></th><th>Airlines</th><th>Starting Place</th><th>Ending Place</th>
				<th>Starting Time</th><th>Reaching Time</th><th></th></tr>
				<%
					flights f = new flights();
					f.MysqlOpenConnection();
					ResultSet rs = f.GetAllFlights();
					while(rs.next()){
						String FNO = rs.getString("flight_no");
						String AName = rs.getString("flight_airlines");
						String from_place = rs.getString("from_place");
						String to_place = rs.getString("to_place");
						String start_time = rs.getString("start_time");
						String reach_time = rs.getString("reach_time");
						
						out.println("<tr><td class=UDTD><a href=updateFlight.jsp?FNO="+FNO+" target=_self>UPDATE</a></td>");
						out.println("<td class=UDTD>"+AName+"</td><td class=UDTD>"+from_place+"</td><td class=UDTD>"+to_place+"</td>");
						out.println("<td class=UDTD>"+start_time+"</td><td class=UDTD>"+reach_time+"</td>");
						out.println("<td class=UDTD><a href=deleteFlight.jsp?FNO="+FNO+" target=_self>DELETE</a></td></tr>");
					}
				%>
				</table>
				</div>
		</div>
	</div>
	</form>
</body>
</html>