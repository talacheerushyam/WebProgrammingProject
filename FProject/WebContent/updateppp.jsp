<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="db.prepayparking"%>
    <%@page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/adminHome.css" />
<script type="text/javascript" src="js/customerReg.js"></script>
<title>Update Pre Paid Parking Details</title>
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
		
		<form action="prepayServlet" method="post">
		 <div style="height:1000px;">
		   <h1> Updating Per Pay Parking Details</h1>
				<%
					String pp_slots =null;
					String vip_slots = null;
					String normal_slots = null;
					String vip_slots_cost = null;
					String normal_slots_cost = null;
				
					prepayparking prepay =  new prepayparking();
					prepay.MysqlOpenConnection();
					ResultSet rs = prepay.ExecuteSelectQuery();
					
					if (rs == null)
					{
						out.print("<h2>At this time we wont have any PRE PAY PARKING SLOTS</h2>");
					}
					else{
						if (rs.next()){
							 pp_slots = rs.getString("pp_slots");
							 vip_slots = rs.getString("vip_slots");
							 normal_slots = rs.getString("normal_slots");
							 vip_slots_cost = rs.getString("vip_slots_cost");
							 normal_slots_cost = rs.getString("normal_slots_cost");
						}
					}
					prepay.MysqlCloseConnection();
					
					System.out.println(pp_slots);
				%>
				
				<table id="ppUpdateTable">
					<tr><td class="crtdL"><label> Total No. Of Slots : </label></td><td class="crtdR"><input type="text" id="pp_slots" name="pp_slots" maxlength="7"  value=<% if(pp_slots != null) out.println(pp_slots); %> disabled /></td></tr>
					<tr><td></td><td class="crtdR"><label id="pp_slotsMsg"></label></td></tr>
									
						<tr><td class="crtdL"><label> Total No. Of VIP Slots : </label></td><td class="crtdR"><input type="text" id="vip_slots" name="vip_slots" value=<% if(vip_slots != null) out.println(vip_slots); %>/><span class="requierd">*</span></td></tr>
					<tr><td></td><td class="crtdR"><label id="vip_slotsMsg"></label></td></tr>
					
					<tr><td class="crtdL"><label> Total No. Of Normal Slots : </label></td><td class="crtdR"><input type="text" id="normal_slots" name="normal_slots" value=<%if (normal_slots != null) out.println(normal_slots); %>/><span class="requierd">*</span></td></tr>
					<tr><td></td><td class="crtdR"><label id="normal_slotsMsg"></label></td></tr>
					
					<tr><td class="crtdL"><label> Cost for Each VIP Slot / Day: </label></td><td class="crtdR"><input type="text" id="vip_slots_cost" name="vip_slots_cost" value=<%if (vip_slots_cost != null) out.println(vip_slots_cost); %>/><span class="requierd">*</span></td></tr>
					<tr><td></td><td class="crtdR"><label id="vip_slots_costMsg"></label></td></tr>
					
					<tr><td class="crtdL"><label> Cost for Each Normal Slot / Day: </label></td><td class="crtdR"><input type="text" id="normal_slots_cost" name="normal_slots_cost" value=<%if (normal_slots_cost != null) out.println(normal_slots_cost); %>/><span class="requierd">*</span></td></tr>
					<tr><td></td><td class="crtdR"><label id="normal_slots_costMsg"></label></td></tr>
					
					
					<tr><td></td><td class="crtdR"><label id="AllMsg">${param.message}</label></td></tr>
					<tr><td class="crtdL"></td><td class="crtdR"><input type="submit" id ="pp_update" name ="pp_update" value="Update Slots" onclick="return checkPPFields()"/></td></tr>
				</table>
		</div>
		</form>
	</div>
</body>
</html>