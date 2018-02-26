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
<title>Update Flights Details</title>
</head>
<body>
<%
String FNO = null;
ResultSet rs= null;
FNO = request.getParameter("FNO");
String AName = null;
String fromPlace = null;
String toPlace = null;
String Ftime = null;
String Ttime = null;
String seats = null;
String Bseats = null;
String Fseats = null;
String Eseats = null;
String bcosts = null;
String fcosts = null;
String ecosts = null;

flights f = new flights();
f.MysqlOpenConnection();
rs = f.GetFlightsDetais(FNO);
if (rs.next()){
	 AName = rs.getString("flight_airlines");
	 fromPlace = rs.getString("from_place");
	 toPlace = rs.getString("to_place");
	 Ftime = rs.getString("start_time");
	 Ttime = rs.getString("reach_time");
	 seats = rs.getString("total_seats");
	 Bseats = rs.getString("b_c");
	 Fseats = rs.getString("f_c");
	 Eseats = rs.getString("e_c");
	 bcosts = rs.getString("cost_b");
	 fcosts = rs.getString("cost_f");
	 ecosts = rs.getString("cost_e");
}

System.out.println(AName+","+fromPlace+","+toPlace+","+Ftime+","+Ttime+","+seats
		+","+Bseats+","+Fseats+","+Eseats+","+bcosts+","+fcosts+","+ecosts);
%>
<form action="FilightServlet" method="post">
	<div id ="cmainDiv">
			<div class="menuBar"> 
			<ul>
			  <li><a href="adminHome.jsp">Home</a></li>
			  <li><a class="active" href="newFlights.jsp" >Flights</a>
				  <ul>
		            <li><a href="newFlights.jsp">Add Flights</a></li>
		            <li><a href="updateDeleteFlights.jsp">Update / Delete Flights</a></li>
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
				<h1>Adding New Flights</h1>
				<div class="newFlightsDiv">
				<input id="fno" name="fno" type="hidden" value=<% if(FNO != null) out.println(FNO); %>/>
				<input id="name1" name="name1" type="hidden" value=<% if(AName != null) out.println(AName); %>/>
				<table class="newFlightsTable">
				
					<tr><td class="NFtdL"><label>Airlines</label></td>
					<td class="NFtdR"><input type="text" name="AName" id="AName" value=<% if(AName != null) out.println(AName); %> disabled/></td></tr>
					<tr><td class="NFtdL"></td><td class="NFtdR"><label id="ANameMsg"></label></td></tr>
					<tr><td class="NFtdL"><label>From</label></td>
					<td class="NFtdR"><input type="text" name="fromPlace" id="fromPlace" value=<% if(fromPlace != null) out.println(fromPlace); %> disabled/>
					</td></tr>
					<tr><td class="NFtdL"></td><td class="NFtdR"><label id="FromPlaceMsg"></label></td></tr>
					<tr><td class="NFtdL"><label>To</label></td>
					<td class="NFtdR"><input type="text" name="toPlace" id="toPlace" value=<% if(toPlace != null) out.println(toPlace); %> disabled/>
					</td></tr>
					<tr><td class="NFtdL"></td><td class="NFtdR"><label id="ToPlaceMsg"></label></td></tr>
					<tr><td class="NFtdL"></td><td class="NFtdR"><label id="DaysMsg"></label></td></tr>
					<tr><td class="NFtdL"><label>Time(Starting & Reaching Time)</label></td>
					<td class="NFtdR">
					<label id="FTime">Starting Time</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label id="FTime">Reaching Time</label><br/>
					<input type="text" name="Ftime" id="Ftime" value=<% if(Ftime != null) out.println(Ftime); %> disabled/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="text" name="Ttime" id="Ttime" value=<% if(Ttime != null) out.println(Ttime); %> disabled/>
					</td></tr>
					<tr><td class="NFtdL"></td><td class="NFtdR"><label id="FTMsg"></label></td></tr>
					<tr><td class="NFtdL"><label>Total No of Seats</label></td><td class="NFtdR"><input type="text" name="seats" id="seats" maxlength="3" value=<%if (seats != null) out.println(seats); %> disabled/></td></tr>
					<tr><td class="NFtdL"></td><td class="NFtdR"><label id="SeatsMsg"></label></td></tr>
					<tr><td class="NFtdL"><label>Business Class</label></td><td class="NFtdR"><input type="text" id="Bseats" name="Bseats" maxlength="3" value=<%if (Bseats != null) out.println(Bseats); %> disabled/></td></tr>
					<tr><td class="NFtdL"></td><td class="NFtdR"><label id="BSeatsMsg"></label></td></tr>
					<tr><td class="NFtdL"><label>First Class</label></td><td class="NFtdR"><input type="text" id="Fseats" name="Fseats" maxlength="3" value=<%if (Fseats != null) out.println(Fseats); %> disabled/></td></tr>
					<tr><td class="NFtdL"></td><td class="NFtdR"><label id="FSeatsMsg"></label></td></tr>
					<tr><td class="NFtdL"><label>Economy Class</label></td><td class="NFtdR"><input type="text" id="Eseats" name="Eseats" maxlength="3" value=<%if (Eseats != null) out.println(Eseats); %> disabled/></td></tr>
					<tr><td class="NFtdL"></td><td class="NFtdR"><label id="ESeatsMsg"></label></td></tr>
					<tr><td class="NFtdL"><label>Cost of Business Class</label></td><td class="NFtdR"><input type="text" name="bcosts" id="bcosts" maxlength="4" value=<%if (bcosts != null) out.println(bcosts); %> disabled/></td></tr>
					<tr><td class="NFtdL"></td><td class="NFtdR"><label id="BCostsMsg"></label></td></tr>
					<tr><td class="NFtdL"><label>Cost of First Class</label></td><td class="NFtdR"><input type="text" name="fcosts" id="fcosts" maxlength="4" value=<%if (fcosts != null) out.println(fcosts); %> disabled/></td></tr>
					<tr><td class="NFtdL"></td><td class="NFtdR"><label id="FCostsMsg"></label></td></tr>
					<tr><td class="NFtdL"><label>Cost of Economy Class</label></td><td class="NFtdR"><input type="text" name="ecosts" id="ecosts" maxlength="4" value=<%if (ecosts != null) out.println(ecosts); %> disabled/></td></tr>
					<tr><td class="NFtdL"></td><td class="NFtdR"><label id="ECostsMsg"></label></td></tr>
					<tr><td class="NFtdL"></td><td class="NFtdR"><label id="AllMsg"></label></td></tr>
					<tr><td class="NFtdL"></td><td class="NFtdR"><input type="submit" name="flight" value="Delete Flight" onclick="return verifyFields()"/></td></tr>
				</table>
				</div>
		</div>
	</div>
	</form>
</body>
</html>