function verifyCarFields(){
	
	var carno = document.getElementById('carno').value;
	
	var e = document.getElementById("cartype");
	var cartype = e.options[e.selectedIndex].value;
	
	
	e = document.getElementById("carmake");
	var carmake = e.options[e.selectedIndex].value;
	
	var cost = document.getElementById('cost').value;
	
	var reg = /[^\w]|_/g;
	
	if (carno.length == 0)
	{
		alert("Please Enter Car Number !!");
		document.getElementById('carno').focus();
		document.getElementById('carnoMsg').innerHTML="Please Enter Car Number !!";
		document.getElementById('cartypeMsg').innerHTML="";
		document.getElementById('carmakeMsg').innerHTML="";
		document.getElementById('costMsg').innerHTML="";
		document.getElementById('AllMsg').innerHTML="";
		return false;
	} else if (carno.match(reg))
	{
		alert("No Special Characters in the Car Number !!");
		document.getElementById('carno').focus();
		document.getElementById('carnoMsg').innerHTML="No Special Characters in the Car Number !!";
		document.getElementById('cartypeMsg').innerHTML="";
		document.getElementById('carmakeMsg').innerHTML="";
		document.getElementById('costMsg').innerHTML="";
		document.getElementById('AllMsg').innerHTML="";
		return false;
	}else if (cartype == "select"){
		alert("Please Select Car Type !!");
		document.getElementById('cartype').focus();
		document.getElementById('cartypeMsg').innerHTML = "Please Select Car Type !!";
		document.getElementById('carnoMsg').innerHTML="";
		document.getElementById('carmakeMsg').innerHTML="";
		document.getElementById('costMsg').innerHTML="";
		document.getElementById('AllMsg').innerHTML="";
		return false;
	} else if (carmake == "select"){
		alert("Please Select Car Make !!");
		document.getElementById('carmake').focus();
		document.getElementById('carmakeMsg').innerHTML = "Please Select Car Make !!";
		document.getElementById('carnoMsg').innerHTML="";
		document.getElementById('cartypeMsg').innerHTML="";
		document.getElementById('costMsg').innerHTML="";
		document.getElementById('AllMsg').innerHTML="";
		return false;
	} else if (cost.length == 0){
		alert("Please Enter Rent per day  !!");
		document.getElementById('cost').focus();
		document.getElementById('costMsg').innerHTML = "Please Enter Rent per day  !!";
		document.getElementById('carnoMsg').innerHTML="";
		document.getElementById('cartypeMsg').innerHTML="";
		document.getElementById('carmakeMsg').innerHTML="";
		document.getElementById('AllMsg').innerHTML="";
		return false;
	}else if (isNaN(cost)){
		alert("Please Enter Only numbers  !!");
		document.getElementById("cost").focus();
		document.getElementById("costMsg").innerHTML = "Please Enter Only numbers  !!";
		document.getElementById('carnoMsg').innerHTML="";
		document.getElementById('cartypeMsg').innerHTML="";
		document.getElementById('carmakeMsg').innerHTML="";
		document.getElementById('AllMsg').innerHTML="";
		return false;
	} else{
		document.getElementById("costMsg").innerHTML = "";
		document.getElementById('carnoMsg').innerHTML="";
		document.getElementById('cartypeMsg').innerHTML="";
		document.getElementById('carmakeMsg').innerHTML="";
		document.getElementById('AllMsg').innerHTML="";
		return true;
	}
}


/**
 * 
 */