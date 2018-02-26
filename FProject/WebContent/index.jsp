<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fast Travel Booking</title>
<link rel="stylesheet" href="Users/Hemanth/Desktop/FProject/FProject/WebContent/WEB-INF/css/loginCSS.css" />
<script type="text/javascript" src="/login.js"></script>
<style type="text/css">
body{
    background-image: url("images/backg.jpg");
	text-align: center;
	vertical-align: middle;
	
}
#mainDiv{
	text-align: center;
	margin: 50px;
	padding: 50px;
	border-spacing: 10px 50px;
	
}
#adminLoginDiv{
	width:400px;
	height:200px;
	float: left;
}
#customerLoginDiv{	
	width:400px;
	height:200px;
	float: left;
}
#signUPDiv{	
	width:200px;
	height:200px;
	float: left;
}

.linkf{
	font-size: 15px;
	font-style: italic;
	text-decoration: underline;
}

.sty{
text-align: left;
font-family: sans-Serif;
font-weight: bold;
padding: 10px;
}

.new{
background-color: #EBF5FB  ;
}
.myBlueDiv {
   
    top:500px;
    bottom:300px;

    left:700px;
}
</style>
<script type="text/javascript">
function adminverify() {
	//alert("");
	//alert(document.getElementById("auid").value);
	var uname = document.getElementById("auid").value;
	var pass = document.getElementById("apwd").value;
	//alert(uname+"-"+pass);
	if (uname.length == 0){
		alert("Please Enter Username !");
		document.getElementById('auid').focus();
		return false;
	} else if (pass.length == 0){
		alert("Please Enter Password !");
		document.getElementById('apwd').focus();
		return false;
	} else {
		return true;
	}
}

function userverify() {
	//alert("");
	//alert(document.getElementById("auid").value);
	var uname = document.getElementById("cuid").value;
	var pass = document.getElementById("cpwd").value;
	//alert(uname+"-"+pass);
	if (uname.length == 0){
		alert("Please Enter Username !");
		document.getElementById('cuid').focus();
		return false;
	} else if (pass.length == 0){
		alert("Please Enter Password !");
		document.getElementById('cpwd').focus();
		return false;
	} else {
		return true;
	}
}
</script>
</head>
<body>
<form action="loginServlet" method="post">
	<div id="mainDiv">
		<div id="adminLoginDiv" align="left">
		<fieldset class="new">
	        <legend class="sty new">Admin Login</legend>
	        <br />
				<label class="sty">UserName:</label> <input type="text" name="auid" maxlength="7" /><br/><br/>
				<label class="sty">Password: </label><input type="password" name="apwd" maxlength="7" /><br/></br>
				<input  class="x" type="submit" name="submitBtn" value="Admin Login" onclick="return adminverify();" ><br/>
			<br />
    	</fieldset>
		</div>
		
		<div id="customerLoginDiv" >
		<fieldset  class="new">
	        <legend class="sty new">Customer Login</legend>
	        <br />
				<label class="sty ">UserName:</label> <input type="text" name="cuid" maxlength="7" /><br/><br/>
				<label class="sty ">Password:</label> <input type="password" name="cpwd" maxlength="7" /><br/><br/>
				<input  class="x" type="submit" name="submitBtn" value="Customer Login" onclick="return userverify();"><br/><br/>
			<br />
    	</fieldset>
		</div>
		<div></div>
		

		<div id="signUPDiv" >
		<fieldset class="new">
	        <legend class="sty new">Customer Login</legend>
	        <br />
				<input  class="x" type="submit" name="submitBtn" value="SIGN UP" width="100px" height="100px">
			<br />
    	</fieldset>
		</div>
	</div>

<div class="statusDiv">
	<%	HttpSession session1 = request.getSession();
		String status = (String) session1.getAttribute("statusMsg");
			System.out.println(status);
		if (status == null) {
			out.print("<label></label>");
		    //session1 = request.getSession();
		} else {
		    if(null != status){
		    	System.out.println(status);
		    	out.print("<label>"+status+"</label>");
		    }
		} %>
		<label></label>
	</div>
	
	</form>
</body>
</html>