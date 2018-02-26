<%@page import="java.sql.ResultSet"%>
<%@page import="db.prepayparking"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/adminHome.css" />
<script type="text/javascript" src="js/customerReg.js"></script>
<title>Pre Pay Parking Slots</title>
</head>
<body>
	<div id ="cmainDiv">
			<div class="menuBar"> 
			<ul>
			  <li><a class="active" href="adminHome.jsp">Home</a></li>
			  <li><a href="newFlights.jsp" >Flights</a>
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
		 <div style="height:1000px;" id="ppDiv">
				<h1> Pre Pay Parking Slots</h1>
				
				
				
				<%
					prepayparking prepay =  new prepayparking();
					prepay.MysqlOpenConnection();
					ResultSet rs = prepay.ExecuteSelectQuery();
					
					if (rs != null)
					{
						out.print("<table id=ppTable><tr><th>Total No. Of Slots</th><th>VIP Slots</th><th>Normal Slots</th><th>VIP Slots Cost</th><th>Normal Slots Cost</th><th></th><th></th></tr>");
						if (rs.next()){
							String pp_slots = rs.getString("pp_slots");
							String vip_slots = rs.getString("vip_slots");
							String normal_slots = rs.getString("normal_slots");
							String vip_slots_cost = rs.getString("vip_slots_cost");
							String normal_slots_cost = rs.getString("normal_slots_cost");
							System.out.println(pp_slots);
							out.print("<tr><td>"+pp_slots+"</td><td>"+vip_slots+"</td><td>"+normal_slots+"</td><td>"+vip_slots_cost+"</td><td>"+normal_slots_cost+"</td><td><a href=updateppp.jsp>UPDATE</a></td><td><a href=deleteppp.jsp>DELETE</a></td></tr>");
							
						}
					}
					else{
						out.print("<h2>At this time we wont have any PRE PAY PARKING SLOTS</h2>");
					}
					
					
					prepay.MysqlCloseConnection();
				%>
				</table>
		</div>
	</div>
</body>
</html>