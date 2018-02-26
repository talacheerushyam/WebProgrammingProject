<%@page import="java.sql.ResultSet"%>
<%@page import="db.cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/customerHome.css" />
<script type="text/javascript" src="js/customerReg.js"></script>
<script type="text/javascript">
function verifycheckedFields(){
	var checked = 0;
	var elements = document.getElementsByName('checkbox');
	for(var i = 0; i < elements.length; i++)
	{
	    if (elements[i].checked) {
	        checked = 1;
	    }
	}
	
	if (checked == 0)
	{
		alert("Please Select the items to buy, Atleast one item !!!!!")
		return false;
	}
	else{
		return true;
	}
    
}
</script>
<title>Cart</title>
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
 <form action="cartServlet" method="post">
	<div id ="cmainDiv">
		<div class="sidebar">
			<a class="sideLink" href=<%out.print("mycart.jsp?username="+userID);%> target="_self"><%out.print("My Cart("+No_cart+")"); %></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		
		<div class="menuBar"> 
			<ul>
			  <li><a href="customerHome.jsp">Home</a></li>
			  <li><a href="flightBooking.jsp">Flight Booking</a></li>
			  <li><a href="rentalCar.jsp">Rental Car</a></li>
			  <li><a href="PayParking.jsp">Pre-Pay Parking</a></li>
			  <li><a href="deals.jsp">Deals/Offers</a></li>
			  <li><a href="orderHistory.jsp">Order History</a></li>
			  <li><a href="profile.jsp">Account/Profile</a></li>
			  <li style="float:right"><a href="index.jsp">Sign out</a></li>
			  
			</ul>
		</div>	
		 <div style="height:1500px;">
				<h1>Cart Details</h1>
				
				<%
				 c = new cart();
				c.MysqlOpenConnection();
				ResultSet rs = c.GetAllCart((String)session.getAttribute("username"));
				int n = 1;
				if (rs!=null)
				{
					out.print("<div id=cartDiv><table id=cartTable><tr><th>Sl. No</th><th>Flight No.</th><th>Ticket No.</th><th>Ticket Class</th><th>Final Cost</th><th>Buy</th></tr>");
					while(rs.next()){
						String id = rs.getString("id");
						String flight_no = rs.getString("flight_no");
						String ticket_no = rs.getString("ticket_no");
						String ticket_class = rs.getString("ticket_class");
						String ticket_cost = rs.getString("ticket_cost");
						String final_cost = rs.getString("final_cost");
						out.print("<tr><td>"+n+"</td><td>"+flight_no+"</td><td>"+ticket_no+"</td><td>"+ticket_class+"</td><td>$"+final_cost+"</td><td><input type=\"checkbox\" name=\"checkbox\"  value="+id+" /></td></td></tr>");
						n = n + 1;
					}
					out.print("</table><br/><input id=\"buycart\" name=\"buycart\" type=\"submit\"  value=\"Buy Items\" onclick=\"return verifycheckedFields()\"/></div>");
				} else{
					out.print("<h2>There is no items in the cart</h2>");
				}
				c.MysqlCloseConnection();
				%>
				<input id="cartcount" name="cartcount" type="hidden" value=<%out.println(No_cart); %>/>
				<label id="AllMsg">${param.message}</label>
		</div>
	</div>
	</form>
</body>
</html>