<%@page import="db.*"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/customerHome.css" />
<script type="text/javascript" src="js/customerReg.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){	
	$('#search').click(function(){
		var check = 0;
		function checkfields(){
			var fno = $('#from').val();
			var toNo = $('#to').val();
			var fromName = $("#from option:selected").text();
			var toName = $("#to option:selected").text();
			var tickets = $('#tickets').val();
			var TClass = $('#tclass').val();
			var ddate = $('#ddate').val();
			if (ddate == "")
			{
				alert("Please Enter Current Date !!");
				$('#ddate').focus();
			}else if (fno == "select")
			{
				alert("Please Select Starting Place !!");
				check = 1;
				$('#from').focus();
				
			}else if (toNo == "select")
			{
				alert("Please Select Destination Place !!");
				check = 1;
				$('#to').focus();
			}else if (tickets == "select")
			{
				alert("Please Select Destination Place !!");
				check = 1;
				$('#tickets').focus();
			}else if (TClass == "select")
			{
				alert("Please Select Destination Place !!");
				check = 1;
				$('#TClass').focus();
			}
		}
		checkfields();
		var fno = $('#from').val();
		var fromName = $("#from option:selected").text();
		var toName = $("#to option:selected").text();
		var tickets = $('#tickets').val();
		var TClass = $('#tclass').val();
		//alert("Ajax");
		if (check == 0){
			$.ajax({
				type:'POST',
				data: {
					fno: fno,
					fromName: fromName,
					toName: toName,
					tickets: tickets,
					TClass: TClass,
					action:'getFlight'
				},
				url:'AjaxController',
				success: function(result){
					//alert(result);
					$('#AjaxDiv').html(result);
				}
			});
		}
	});
});
$(document).ready(function(){	
	$('#from').change(function(){
		//alert("On change");
		var fno = $('#from').val();
		//alert(fno);
		var fromName = $("#from option:selected").text();
		//alert(fromName);
		$.ajax({
			type: 'POST',
			data:{
				fno: fno,
				fromName: fromName,
				action: 'getTo'
			},
			url: 'AjaxController',
			success: function(result){
				//alert(result);
				$('#to').html(result);
			}
		});
	});
});


$(document).ready(function(){	
	$('#ddate').change(function(){
		var ddate = $('#ddate').val();
		var DateRegularExp = new RegExp("[0-9]./-"); 
		//alert(currentDate.split("/").length - 1);
		if (ddate == "")
		{
			alert("Please Enter Current Date !!");
			$('#ddate').focus();
		}else if (ddate.indexOf("/") < 0)
		{
			alert("Please Enter Date in MM/DD/YYYY format !!");
			$('#ddate').focus();
		} else if (ddate.match(DateRegularExp))
		{
			alert("Please Enter Date in MM/DD/YYYY format !!");
			$('#ddate').focus();
		}else if ((ddate.split("/").length - 1) != 2)
		{
			alert("Please Enter Date in MM/DD/YYYY format !!");
			$('#ddate').focus();
		} else {
			var myDate = new Date(ddate);
	        var today = new Date();
	        if (myDate<=today) { 
	        	alert("Please Enter Date Greater than today's date format !!");
				$('#ddate').focus();
	        }
		}
	});
});
</script>
<title>Flight Booking</title>
</head>
<body>
	<div id ="cmainDiv">
		<div class="sidebar">
		<a class="sideLink" href=<%out.print("mycart.jsp?username="+userID);%> target="_self"><%out.print("My Cart("+No_cart+")"); %></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		
		<div class="menuBar"> 
			<ul>
			  <li><a href="customerHome.jsp">Home</a></li>
			  <li><a  class="active" href="flightBooking.jsp">Flight Booking</a></li>
			  <li><a href="rentalCar.jsp">Rental Car</a></li>
			  <li><a href="PayParking.jsp">Pre-Pay Parking</a></li>
			  <li><a href="deals.jsp">Deals/Offers</a></li>
			  <li><a href="orderHistory.jsp">Order History</a></li>
			  <li><a href="profile.jsp">Account/Profile</a></li>
			  <li style="float:right"><a href="index.jsp">Sign out</a></li>
			  
			</ul>
		</div>	
		 <div class="mainBookingDiv" style="height:1500px;">
				<h1>Flight Booking</h1>	
				<div class="tableDiv">
				<table class="bookingTable">
				<tr><td><label>Date : </label></td><td><input type="text" name="ddate" id="ddate" onchange="checkDate()"/><span class="req">*</span></td><td>(MM/DD/YYYY)</td><td></td></tr>
					<tr><td><label>From : </label></td>
					<td> <select id="from" name="from">
					<option value="select">Select</option>
					<% 	flights f = new flights();
						f.MysqlOpenConnection();
						ResultSet rs = f.GetAllFromFlights();
						 while (rs.next()) {
							 String fno = rs.getString("flight_no");
							 String from = rs.getString("from_place");
							 out.println("<option value="+fno+">"+from+"</option>");
						 }
						 f.MysqlCloseConnection();
					%>
					</select><span class="req">*</span>
					</td><td><label>To :</label> </td>
					<td><select id="to" name="to">
					<option value="select">Select</option>
					</select><span class="req">*</span>
					</td></tr>
					<tr><td></td><td></td><td></td><td></td></tr>
					<tr><td></td><td></td><td></td><td></td></tr>
					<tr><td><label>No. of Tickets :</label></td>
					<td><select id="tickets" name="tickets">
					<option value="select">Select</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					</select><span class="req">*</span>
					</td>
					<td><label>Ticket Class :</label></td><td>
					<select id="tclass" name="tclass">
					<option value="select">Select</option>
					<option value="b_c">Business Class</option>
					<option value="f_c">First Class</option>
					<option value="e_c">Economy Class</option>
					</select><span class="req">*</span></td></tr>
					<tr><td></td><td></td><td></td><td></td></tr>
					<tr><td></td><td></td><td><input type="button" name="search" id="search" value="SEARCH"/></td><td></td></tr>
				</table>
				<br/><br/><br/><br/>
				<div id="AjaxDiv">

				</div>
				</div>
				
		</div>
	</div>
</body>
</html>