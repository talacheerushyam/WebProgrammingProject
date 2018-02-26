<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/customercss.css" />
<script type="text/javascript" src="js/customerReg.js"></script>
<title>Customer Registration Page</title>
</head>
<body>
	<div id ="cmainDiv">
	<h1>Customer Registration</h1>
	<hr/>
		<form action="Reg_Servlet" method="post">
			<div class="mainDiv">
				<table id="crTable">
					<tr><td class="crtdL"><label> Username : </label></td><td class="crtdR"><input type="text" id="uname" name="uname" maxlength="7"/><span class="requierd">*</span></td></tr>
					<tr><td></td><td class="crtdR"><label id="usernameMsg"></label></td></tr>
					
					<tr><td class="crtdL"><label> New Password : </label></td><td class="crtdR"><input type="password"  id="npass" name="npass" maxlength="7"/><span class="requierd">*</span></td></tr>
					<tr><td></td><td class="crtdR"><label id="npasswordMsg"></label></td></tr>
					
					<tr><td class="crtdL"><label> Confirm Password : </label></td><td class="crtdR"><input type="password"  id="cpass" name="cpass" maxlength="7"/><span class="requierd">*</span></td></tr>
					<tr><td></td><td class="crtdR"><label id="cpasswordMsg"></label></td></tr>
					
					<tr><td class="crtdL"><label> Name : </label></td><td class="crtdR"><input type="text" id="name" name="name" /><span class="requierd">*</span></td></tr>
					<tr><td></td><td class="crtdR"><label id="nameMsg"></label></td></tr>
					
					<tr><td class="crtdL"><label> Email : </label></td><td class="crtdR"><input type="text" id="email" name="email" /><span class="requierd">*</span></td></tr>
					<tr><td></td><td class="crtdR"><label id="emailMsg"></label></td></tr>
					
					<tr><td class="crtdL"><label> Phone Number : </label></td><td class="crtdR"><input type="text" id="ph" name="ph" /><span class="requierd">*</span></td></tr>
					<tr><td></td><td class="crtdR"><label id="phMsg"></label></td></tr>
					
					<tr><td></td><td class="crtdR"><label id="AllMsg">${param.message}</label></td></tr>
					<tr><td class="crtdL"></td><td class="crtdR"><input type="submit" name ="Register" value="Register" onclick="return checkFields()"/></td></tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>