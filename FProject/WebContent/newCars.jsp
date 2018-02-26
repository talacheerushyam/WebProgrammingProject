<%@page import="java.sql.ResultSet"%>
<%@page import="db.airlines"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/adminHome.css" />
<script type="text/javascript" src="js/cars.js"></script>
<title>Add New Rental Car</title>
</head>
<body>
<form action="CarServlet" method="post">
	<div id ="cmainDiv">
			<div class="menuBar"> 
			<ul>
			  <li><a href="adminHome.jsp">Home</a></li>
			  <li><a href="newFlights.jsp" >Flights</a>
				  <ul>
		            <li><a href="newFlights.jsp">Add Flights</a></li>
		            <li><a href="updateDeleteFlights.jsp">Update / Delete Flights</a></li>
		          </ul>
	          </li>
			  <li><a class="active" href="newCars.jsp">Rental Car</a>
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
				<h1>Adding New Cars</h1>
				<div class="newFlightsDiv">
				<table class="newFlightsTable">
					<tr><td class="NFtdL"><label>Car Number</label></td>
					<td class="NFtdR"><input type="text" id="carno" name="carno" maxlength="10" />
					<span class="req">*</span></td></tr>
					<tr><td class="NFtdL"></td><td class="NFtdR"><label id="carnoMsg"></label></td></tr>
					<tr><td class="NFtdL"><label>Car Type</label></td>
					<td class="NFtdR">
						<select id="cartype" name="cartype">
							<option value="select">Select</option>
							<option value="small">Small</option>
							<option value="sedan">Sedan</option>
							<option value="suv">SUV</option>
							<option value="van">Van</option>
							<option value="15seats">15 Seaters</option>
							<option value="18seats">18 Seaters</option>
						</select><span class="req">*</span>
					</td></tr>
					<tr><td class="NFtdL"></td><td class="NFtdR"><label id="cartypeMsg"></label></td></tr>
					<tr><td class="NFtdL"><label>Car Make</label></td>
					<td class="NFtdR">
						<select id="carmake" name="carmake">
							<option value="select">Select</option>
							<option value="honda">Honda</option>
							<option value="toyota">Toyota</option>
							<option value="mazda">Mazda</option>
							<option value="lexus">Lexus</option>
							<option value="bmw">BMW</option>
							<option value="benz">Benz</option>
						</select><span class="req">*</span>
					</td></tr>
					<tr><td class="NFtdL"></td><td class="NFtdR"><label id="carmakeMsg"></label></td></tr>
					<tr><td class="NFtdL"><label>Rent / Day</label></td><td class="NFtdR"><input type="text" name="cost" id="cost" maxlength="4"/><span class="req">*</span></td></tr>
					<tr><td class="NFtdL"></td><td class="NFtdR"><label id="costMsg"></label></td></tr>
					
					<tr><td class="NFtdL"></td><td class="NFtdR"><label id="AllMsg">${param.message}</label></td></tr>
					<tr><td class="NFtdL"></td><td class="NFtdR"><input name="car" type="submit" value="Add Car" onclick="return verifyCarFields()"/></td></tr>
				</table>
				</div>
		</div>
	</div>
	</form>
</body>
</html>