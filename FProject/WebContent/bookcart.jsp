<%@page import="java.sql.ResultSet"%>
<%@page import="db.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/customerHome.css" />
<script type="text/javascript" src="js/customerReg.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){	
	$('#cn').keypress(function(){
		//alert("KeyPress");
		var starts = $('#cn').val();
		if (starts.startsWith("5155"))
		{
			$('#cctype').text("Master Card");
		} else if (starts.startsWith("4"))
		{
			$('#cctype').text("Visa Card");
		}else if ((starts.startsWith("34")) || (starts.startsWith("37")))
		{
			$('#cctype').text("American Express");
		}
	});
});


$(document).ready(function(){	
	$('#wireDiv').hide();
    $('#ccDiv').hide();
   $('#buyBtn').hide();
   $('#buyDiv').hide();
   $("input[type='radio']").click(function(){
          var result = checkWhichRadio(this);
     });
   
	$('#scart').click(function(){
		alert("On click");
		var flight_no = $('#flight_no').val();
		alert(flight_no);
		var ticket_no = $('#ticket_no').val();
		alert(ticket_no);
		var user = $('#user').val();
		alert(user);
		var ticket_class = $('#ticket_class').val();
		alert(ticket_class);
		var ticket_cost = $('#ticket_cost').val();
		alert(ticket_cost);
		var final_cost = $('#final_cost').val();
		alert(final_cost);
		$.ajax({
			type: 'POST',
			data:{
				flight_no: flight_no,
				ticket_no: ticket_no,
				ticket_class: ticket_class,
				ticket_cost: ticket_cost,
				final_cost: final_cost,
				user : user,
				action: 'ToCart'
			},
			url: 'AjaxController',
			success: function(result){
				$('#cart_link').innerHTML="My Cart("+result+")";
				alert("Successfully Added to the Cart !!!");
				document.location = "flightBooking.jsp";
			}
		});
	});
	
	$('#buy').click(function(){
		$('#buyDiv').show();
	});
	
	$("#buyBtn").click(function(){
	    // alert("Btn click");
	    if($("input:radio[name='c']").is(":checked")) {
	    	var type = $("input[name='c']:checked").val();
	    	var cn = type;
	    	var flight_no = $('#flight_no').val();
			//alert(flight_no);
			var ticket_no = $('#ticket_no').val();
			//alert(ticket_no);
			var user = $('#user').val();
			//alert(user);
			var ticket_class = $('#ticket_class').val();
			//alert(ticket_class);
			var cardno = $('#cardno').val();
			//alert(ticket_cost);
			var final_cost = $('#final_cost').val();
			
			 alert("AAJAX");
	    	 $.ajax({
	    		 type: 'POST',
	 			data:{
	 				cn: cn,
	 				flight_no: flight_no,
					ticket_no: ticket_no,
					ticket_class: ticket_class,
					cardno: cardno,
					final_cost: final_cost,
					user : user,
	 				action: 'BuyItems'
	 			},
	 			url: 'AjaxController1',
	 			success: function(result){
	 				if (result=="1")
 					{
	 					//$('#cart_link').innerHTML="My Cart("+result+")";
		 				alert(" Buying  Successfull !!!");
		 				document.location = "flightBooking.jsp";
 					} else{
 						alert(" Buying  successfull, Try again later !!!");
		 				document.location = "flightBooking.jsp";
 					}
	 			}
	    	 });
  		}
	    else{
		     var cn = $("#cn").val();
		     var mm = $("#mm").val();
		     var yy = $("#yy").val();
		     var sn = $("#sn").val();
		     var flight_no = $('#flight_no').val();
			//alert(flight_no);
			var ticket_no = $('#ticket_no').val();
			//alert(ticket_no);
			var user = $('#user').val();
			//alert(user);
			var ticket_class = $('#ticket_class').val();
			//alert(ticket_class);
			var ticket_cost = $('#ticket_cost').val();
			//alert(ticket_cost);
			var final_cost = $('#final_cost').val();
			//alert(final_cost);
			
		     if ( cn.length == 0)
		     {
		         alert("Please Enter 13 Digit Card Number  !!!!");
		         $("#cn").focus();
		     }else if (isNaN(cn))
		     {
		          alert("Please Enter only numbers  !!!!");
		          $("#cn").focus();   
		     } else if ( cn.length != 13)
		     {
		         alert("Please Enter 13 Digit Card Number  !!!!");
		         $("#cn").focus();
		     }else if ( mm.length == 0)
		     {
		         alert("Please Enter Month of your card Expiration  !!!!");
		         $("#mm").focus();
		     }else if (isNaN(mm))
		     {
		          alert("Please Enter only numbers for Month !!!!");
		          $("#mm").focus();   
		     } else if (mm < 0 || mm > 11)
		     {
		          alert("Please Enter numbers(Januaray - 00) through (December - 11) !!!!");
		          $("#mm").focus();   
		     }else if (yy.length == 0)
		     {
		         alert("Please Enter Year of your card Expirating  !!!!");
		         $("#yy").focus();
		     }else if (isNaN(yy))
		     {
		          alert("Please Enter only numbers for Years !!!!");
		          $("#cn").focus();   
		     }else if (yy.length !== 4)
		     {
		          alert("Enter year of your Card Expiring !!!! Example: 2017 or 2018");
		          $("#yy").focus();   
		     }else if (parseInt(yy) < 2017)
		     {
		          alert("Card Already Expired, Please use other card !!!");
		          $("#yy").focus();   
		     }else if ( sn.length == 0)
		     {
		         alert("Please Enter 3 Digit Security Number !!!!");
		         $("#sn").focus();
		     }else if (isNaN(sn))
		     {
		          alert("Please Enter only numbers !!!!");
		          $("#sn").focus();   
		     }
		     else if (sn.length !== 3)
		     {
		          alert("Please Enter exactly 3 digit numbers, Its in the back of your card !!");
		          $("#sn").focus();   
		     }else{
		    	 alert("AAJAX");
		    	 $.ajax({
		    		 type: 'POST',
		 			data:{
		 				cn: cn,
		 				mm: mm,
		 				yy: yy,
		 				sn: sn,
		 				flight_no: flight_no,
						ticket_no: ticket_no,
						ticket_class: ticket_class,
						ticket_cost: ticket_cost,
						final_cost: final_cost,
						user : user,
		 				action: 'BuyTicket'
		 			},
		 			url: 'AjaxController',
		 			success: function(result){
		 				if (result=="1")
	 					{
		 					//$('#cart_link').innerHTML="My Cart("+result+")";
			 				alert("Ticket Buying  Successfull !!!");
			 				document.location = "flightBooking.jsp";
	 					} else{
	 						alert("Ticket Buying  Unsuccessfull, Try again later !!!");
			 				document.location = "flightBooking.jsp";
	 					}
		 			}
		    	 });
		     }
		}
	 });
	
});

function checkWhichRadio(obj){
    //  alert("checking");
     // alert(obj.value);
      if (obj.value == "1")
      {
    	  $('#ccDiv').show();
          $('#wireDiv').hide();
          $('#buyBtn').show();
          return 1;
      }
      else if (obj.value == "2"){
          $('#wireDiv').show();
          $('#ccDiv').hide();
          $('#buyBtn').show();
          return 0;
      }
  }
  
$(document).ready(function(){	
	$("input[type='radio']").click(function() {
        var type = $("input[name='r']:checked").val();
        if (type == "1"){
        	//alert("AJAX");
      	  $.ajax({
    			type: 'POST',
    			data:{
    				user : user,
    				action: 'GetCC'
    			},
    			url: 'AjaxController1',
    			success: function(result){
    				alert(result);
    			}
    		});
        }
    });
});

</script>
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


String type = request.getParameter("name");
String fno = null;
String tickets = null;
String username = (String)session.getAttribute("username");
String tclass = null;

float finalCost =0;
float tax = 0;
float endCost = 0;
String cost = null;
String ticket = null;

String flightno[] =  new String[4];
String ticketno[]=  new String[4];
String ticketclass[]=  new String[4];
String finalcost[]=  new String[4];
String cardno[]=  new String[4];


if (type.equals("flight"))
{
	 fno = request.getParameter("fno");
	 tickets = request.getParameter("tickets");
	 username = request.getParameter("username");
	 tclass = request.getParameter("class");
	int t = Integer.parseInt(tickets);
	
	System.out.println(fno+","+tickets+","+username);
	
	flights f = new flights();
	f.MysqlOpenConnection();
	ResultSet rs = f.GetFlightsDetais(fno);
	if (rs.next())
	{
		if (tclass=="b_c"){
			cost = rs.getString("cost_b");
		}else if (tclass=="f_c"){
			cost = rs.getString("cost_f");
		}else{
			cost = rs.getString("cost_e");
		}
	}
	else
	{
		cost="0";
	}
	f.MysqlCloseConnection();
	 finalCost = t * Integer.parseInt(cost);
	 tax = (float)(finalCost * 0.20);
	 endCost = finalCost+tax;
	
	System.out.println(finalCost+"-"+tax+"-"+endCost);
}else if (type.equals("cart"))
{
	
	String cartId[] = request.getParameterValues("id");
	System.out.println(cartId.length);
	 c = new cart();
	c.MysqlOpenConnection();
	for (int i=0; i<cartId.length; i++){
		int j = 0;
		ResultSet r = c.GetCartItemByID(username, cartId[i]);
		if (r != null)
		{
			if (r.next())
			{
				String fc = r.getString("final_cost");
				String cartc = r.getString("id");
				String tn = r.getString("ticket_no");
				String tc = r.getString("ticket_class");
				String fn = r.getString("flight_no");
				System.out.println(fc+","+cartc+","+tn+","+tc+","+fn);
				 cardno[j] = cartc;
				 flightno[j] = fn;
				 ticketno[j] = tn;
				 ticketclass[j] = tc;
				 finalcost[j] = fc;
				
				finalCost = finalCost + Float.parseFloat(fc);
			}
		}
		j = j + 1;
	}
	System.out.println(ticket);
	c.MysqlCloseConnection();
	 tax = (float)(finalCost * 0.20);
	 endCost = finalCost+tax;
}
%>
<body>
	<div id ="cmainDiv">
		<div class="sidebar">
		<a class="sideLink" href=<%out.print("mycart.jsp?username="+userID);%> target="_self"><%out.print("My Cart("+No_cart+")"); %></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		
		<div class="menuBar"> 
			<ul>
			  <li><a href="customerHome.jsp">Home</a></li>
			  <li><a class="active" href="flightBooking.jsp">Flight Booking</a></li>
			  <li><a href="rentalCar.jsp">Rental Car</a></li>
			  <li><a href="PayParking.jsp">Pre-Pay Parking</a></li>
			  <li><a href="deals.jsp">Deals/Offers</a></li>
			  <li><a href="orderHistory.jsp">Order History</a></li>
			  <li><a href="profile.jsp">Account/Profile</a></li>
			  <li style="float:right"><a href="index.jsp">Sign out</a></li>
			  
			</ul>
		</div>	
		 <div style="height:1500px;">
			<h1>Book Tickets</h1>
			
			<input id="flight_no" name="flight_no" type="hidden" value=<%  out.println(flightno); %>/>
			<input id="ticket_no" name="ticket_no" type="hidden" value=<%  out.println(ticketno); %>/>
			<input id="user" name="user" type="hidden" value=<%  out.println(username); %>/>
			<input id="ticket_class" name="ticket_class" type="hidden" value=<%  out.println(ticketclass); %>/>
			<input id="ticket_cost" name="ticket_cost" type="hidden" value=<%  out.println(finalcost); %>/>
			<input id="cardno" name="cardno" type="hidden" value=<%  out.println(cardno); %>/>
			<div class="bookTickets">
				<table class="booktable">
				<%
				if (type.equals("flight"))
				{
					out.print("<tr><td>No. of Tickets :</td><td><label>"+tickets+"</label></td></tr>");
					out.print("<tr><td>Per Ticket :</td><td><label>"+cost+"</label></td></tr>");
					out.print("<tr><td>Tax :</td><td><label>"+tax+"</label></td></tr>");
					out.print("<tr><td>Final Cost :</td><td><label>"+endCost+"</label></td></tr>");
					out.print("<tr><td><input type=\"button\" name=\"scart\" id=\"scart\" value=\"Add To Cart\"/></td><td><input type=\"button\" name=\"buy\" id=\"buy\" value=\"Buy Tickets\"/></td></tr>");
				
				} else if (type.equals("cart")){
					out.print("<tr><td>Total Cost :</td><td><label>"+finalCost+"</label></td></tr>");
					out.print("<tr><td>Tax :</td><td><label>"+tax+"</label></td></tr>");
					out.print("<tr><td>Final Cost :</td><td><label>"+endCost+"</label></td></tr>");
					out.print("<tr><td></td><td><input type=\"button\" name=\"buy\" id=\"buy\" value=\"Buy Items\"/></td></tr>");
				}
				%>
				</table>
			</div>	
			<br/><br/>
			<div id= "buyDiv">
				<div id="payment">
	                <label id ="paymentLb">Payment : </label>
	                <div id="radio">
	                    <input type="radio" id="r2" name="r" value="1"/><label>Credit Card</label>
	                    <input type="radio" id="r1" name="r" value="2" onchange="check()"/><label>Wire</label>
	                </div>
	            </div><br/>
	            <div id="ccDiv">
	                <label id="cnLb">Card Number : </label> <input type="text" id="cn" name="cn" /><span id="cctype"></span> <br/>
	                <label id="ex">Expiration : (MM/YYYY)</label><input type="text" id="mm" maxlength="2" size="2"/><input type="text" id="yy" maxlength="4" size="4"/><br/>
	                <label id = "security">3 Digit Security Number</label><input type="text" id="sn" maxlength="3" size="3"/>
	                <%
	                card c1 = new card();
	    			c1.MysqlOpenConnection();
	    			ResultSet rs = c1.GetCard(username);
	    			if (rs != null)
	    			{
	    				out.print("<div id=ccdiv><table id=cctable><tr><th>Card Number</th><th>Expire Date</th><th>Security Number</th></tr>");
    					while (rs.next()){
    						String cc_no = rs.getString("cc_no");
    						String expire_date = rs.getString("expire_date");
    						String s_no = rs.getString("s_no");
    						out.print("<table><tr><td>"+cc_no+"</td><td>"+expire_date+"</td><td>"+s_no+"</td><td><input type=\"radio\" id=\"c2\" name=\"c\" value="+cc_no+"/></td></tr>");
    					}
    					out.print("</table></div>");
	    			}
	    			c1.MysqlCloseConnection();
	                %>
	            </div>
	           <br/> <div id="wireDiv">
	                <label id="wireLb">Transfer the Amount to :  $<%out.print(endCost); %>, to account 0009286322 </label> 
	            </div>
	            <br/>
	            <button id="buyBtn">BUY</button>
			</div>
		</div>
	</div>
</body>
</html>