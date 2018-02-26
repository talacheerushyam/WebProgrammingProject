/**
 * 
 */

function checkFields() {
	var uname = document.getElementById('uname').value;
	var npass = document.getElementById('npass').value;
	var cpass = document.getElementById('cpass').value;
	var name = document.getElementById('name').value;
	var email = document.getElementById('email').value;
	var ph = document.getElementById('ph').value;
	
	var name_reg = /^[a-zA-Z ]*$/;
	var re = /^[\w]+$/;
	
	var phoneno = /^\d{10}$/;
	
	var filter = /^[A-Za-z0-9]+$/;
	
	if (uname.length == 0)
	{
		alert("Please Enter Username !!");
		document.getElementById('uname').focus();
		document.getElementById('usernameMsg').innerHTML="Please Enter Username !!";
		document.getElementById('npasswordMsg').innerHTML="";
		document.getElementById('cpasswordMsg').innerHTML="";
		document.getElementById('nameMsg').innerHTML="";
		document.getElementById('emailMsg').innerHTML="";
		document.getElementById('phMsg').innerHTML="";
		document.getElementById('AllMsg').innerHTML="";
		return false;
	} else if (!uname.match(re))
	{
		alert("No Special Characters in the Username !!");
		document.getElementById('uname').focus();
		document.getElementById('usernameMsg').innerHTML="No Special Characters in the Username !!";
		document.getElementById('npasswordMsg').innerHTML="";
		document.getElementById('cpasswordMsg').innerHTML="";
		document.getElementById('nameMsg').innerHTML="";
		document.getElementById('emailMsg').innerHTML="";
		document.getElementById('phMsg').innerHTML="";
		document.getElementById('AllMsg').innerHTML="";
		return false;
	} else if(uname.match(/^\s+$/) !== null) {
		alert("No Space in the Username !!");
		document.getElementById('uname').focus();
		document.getElementById('usernameMsg').innerHTML="No Space in the Username !!";
		document.getElementById('npasswordMsg').innerHTML="";
		document.getElementById('cpasswordMsg').innerHTML="";
		document.getElementById('nameMsg').innerHTML="";
		document.getElementById('emailMsg').innerHTML="";
		document.getElementById('phMsg').innerHTML="";
		document.getElementById('AllMsg').innerHTML="";
		return false;
	} else if (npass.length == 0)
	{
		alert("Please Enter New Password !!");
		document.getElementById('npass').focus();
		document.getElementById('npasswordMsg').innerHTML="Please Enter New Password !!";
		document.getElementById('usernameMsg').innerHTML="";
		document.getElementById('cpasswordMsg').innerHTML="";
		document.getElementById('nameMsg').innerHTML="";
		document.getElementById('emailMsg').innerHTML="";
		document.getElementById('phMsg').innerHTML="";
		document.getElementById('AllMsg').innerHTML="";
		return false;
	} else if (!npass.match(re))
	{
		alert("No Special Characters Other than (@,_,-) in the New Password !!");
		document.getElementById('npass').focus();
		document.getElementById('npasswordMsg').innerHTML="No Special Characters Other than (@,_,-) in the New Password !!";
		document.getElementById('usernameMsg').innerHTML="";
		document.getElementById('cpasswordMsg').innerHTML="";
		document.getElementById('nameMsg').innerHTML="";
		document.getElementById('emailMsg').innerHTML="";
		document.getElementById('phMsg').innerHTML="";
		document.getElementById('AllMsg').innerHTML="";
		return false;
	}else if(npass.match(/^\s+$/) !== null) {
		alert("No Space in the New Password !!");
		document.getElementById('npass').focus();
		document.getElementById('npasswordMsg').innerHTML="No Space in the New Password !!";
		document.getElementById('usernameMsg').innerHTML="";
		document.getElementById('cpasswordMsg').innerHTML="";
		document.getElementById('nameMsg').innerHTML="";
		document.getElementById('emailMsg').innerHTML="";
		document.getElementById('phMsg').innerHTML="";
		document.getElementById('AllMsg').innerHTML="";
		return false;
	}else if (cpass.length == 0)
	{
		alert("Please Enter Confirm Password !!");
		document.getElementById('cpass').focus();
		document.getElementById('cpasswordMsg').innerHTML="Please Enter Confirm Password !!";
		document.getElementById('usernameMsg').innerHTML="";
		document.getElementById('npasswordMsg').innerHTML="";
		document.getElementById('nameMsg').innerHTML="";
		document.getElementById('emailMsg').innerHTML="";
		document.getElementById('phMsg').innerHTML="";
		document.getElementById('AllMsg').innerHTML="";
		return false;
	} else if (!cpass.match(re))
	{
		alert("No Special Characters Other than (@,_,-) in the Confirm Password !!");
		document.getElementById('cpass').focus();
		document.getElementById('cpasswordMsg').innerHTML="No Special Characters Other than (@,_,-) in the Confirm Password !!";
		document.getElementById('usernameMsg').innerHTML="";
		document.getElementById('npasswordMsg').innerHTML="";
		document.getElementById('nameMsg').innerHTML="";
		document.getElementById('emailMsg').innerHTML="";
		document.getElementById('phMsg').innerHTML="";
		document.getElementById('AllMsg').innerHTML="";
		return false;
	}else if(cpass.match(/^\s+$/) !== null) {
		alert("No Space in the Confirm Password !!");
		document.getElementById('cpass').focus();
		document.getElementById('cpasswordMsg').innerHTML="No Space in the Confirm Password !!";
		document.getElementById('usernameMsg').innerHTML="";
		document.getElementById('npasswordMsg').innerHTML="";
		document.getElementById('nameMsg').innerHTML="";
		document.getElementById('emailMsg').innerHTML="";
		document.getElementById('phMsg').innerHTML="";
		document.getElementById('AllMsg').innerHTML="";
		return false;
	}else if(npass !== cpass) {
		alert("New Password and Confirm Password is not matching !!");
		document.getElementById('npass').focus();
		document.getElementById('npasswordMsg').innerHTML="New Password and Confirm Password is not matching !!";
		document.getElementById('usernameMsg').innerHTML="";
		document.getElementById('cpasswordMsg').innerHTML="";
		document.getElementById('nameMsg').innerHTML="";
		document.getElementById('emailMsg').innerHTML="";
		document.getElementById('phMsg').innerHTML="";
		document.getElementById('AllMsg').innerHTML="";
		return false;
	}if (name.length == 0)
	{
		alert("Please Enter Name !!");
		document.getElementById('name').focus();
		document.getElementById('nameMsg').innerHTML="Please Enter Name !!";
		document.getElementById('usernameMsg').innerHTML="";
		document.getElementById('npasswordMsg').innerHTML="";
		document.getElementById('cpasswordMsg').innerHTML="";
		document.getElementById('emailMsg').innerHTML="";
		document.getElementById('phMsg').innerHTML="";
		document.getElementById('AllMsg').innerHTML="";
		return false;
	} else if (!name.match(name_reg))
	{
		alert("No Special Characters in the Name !!");
		document.getElementById('name').focus();
		document.getElementById('nameMsg').innerHTML="No Special Characters in the Name !!";
		document.getElementById('usernameMsg').innerHTML="";
		document.getElementById('npasswordMsg').innerHTML="";
		document.getElementById('cpasswordMsg').innerHTML="";
		document.getElementById('emailMsg').innerHTML="";
		document.getElementById('phMsg').innerHTML="";
		document.getElementById('AllMsg').innerHTML="";
		return false;
	}else if (email.length == 0)
	{
		alert("Please Enter Email !!");
		document.getElementById('email').focus();
		document.getElementById('emailMsg').innerHTML="Please Enter Email !!";
		document.getElementById('usernameMsg').innerHTML="";
		document.getElementById('cpasswordMsg').innerHTML="";
		document.getElementById('npasswordMsg').innerHTML="";
		document.getElementById('nameMsg').innerHTML="";
		document.getElementById('phMsg').innerHTML="";
		document.getElementById('AllMsg').innerHTML="";
		return false;
	} else if (!(Validate_Email(email))){
		alert("Please Enter Valid Email !!");
		document.getElementById('email').focus();
		document.getElementById('emailMsg').innerHTML="Please Enter Valid Email !!";
		document.getElementById('usernameMsg').innerHTML="";
		document.getElementById('cpasswordMsg').innerHTML="";
		document.getElementById('npasswordMsg').innerHTML="";
		document.getElementById('nameMsg').innerHTML="";
		document.getElementById('phMsg').innerHTML="";
		document.getElementById('AllMsg').innerHTML="";
		return false;
	}else if (ph.length == 0)
	{
		alert("Please Enter Phone Number !!");
		document.getElementById('ph').focus();
		document.getElementById('phMsg').innerHTML="Please Enter Phone Number !!";
		document.getElementById('usernameMsg').innerHTML="";
		document.getElementById('cpasswordMsg').innerHTML="";
		document.getElementById('npasswordMsg').innerHTML="";
		document.getElementById('nameMsg').innerHTML="";
		document.getElementById('emailMsg').innerHTML="";
		document.getElementById('AllMsg').innerHTML="";
		return false;
	} else if (!(ph.match(phoneno))){
		alert("Please Enter Valid Phone Number !!");
		document.getElementById('ph').focus();
		document.getElementById('phMsg').innerHTML="Please Enter Valid Phone Number !!";
		document.getElementById('usernameMsg').innerHTML="";
		document.getElementById('cpasswordMsg').innerHTML="";
		document.getElementById('npasswordMsg').innerHTML="";
		document.getElementById('nameMsg').innerHTML="";
		document.getElementById('emailMsg').innerHTML="";
		document.getElementById('AllMsg').innerHTML="";
		return false;
	} else{
		document.getElementById('AllMsg').innerHTML="";
		document.getElementById('usernameMsg').innerHTML="";
		document.getElementById('cpasswordMsg').innerHTML="";
		document.getElementById('npasswordMsg').innerHTML="";
		document.getElementById('nameMsg').innerHTML="";
		document.getElementById('emailMsg').innerHTML="";
		document.getElementById('phMsg').innerHTML="";
		alert("dsgjhgsdj");
		return true;
	}
	
	//return false;
}

function Validate_Email(x){
	var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
        return false;
    }
    return true;
}

function checkFromTo(){
	e = document.getElementById("from");
	var fromPlace = e.options[e.selectedIndex].value;
	
	e = document.getElementById("to");
	var toPlace =e.options[e.selectedIndex].value; 
	
	if (toPlace == "select"){
		alert("Please Select From Place !!!");
		document.getElementById("from").focus();
	}else if (fromPlace == toPlace){
		alert("From and To cant be same !!!");
		document.getElementById("from").focus();
	}
}

function checkFromSelect(){
	e = document.getElementById("from");
	var fromPlace = e.options[e.selectedIndex].value;
	
	if (fromPlace == "select"){
		alert("Please Select From Place !!!");
		document.getElementById("from").focus();
	}
}

function checkPPFields(){
	var pp_slots = document.getElementById('pp_slots').value;
	var vip_slots = document.getElementById('vip_slots').value;
	var normal_slots = document.getElementById('normal_slots').value;
	var vip_slots_cost = document.getElementById('vip_slots_cost').value;
	var normal_slots_cost = document.getElementById('normal_slots_cost').value;
	alert("pp");
	alert(pp_slots+","+vip_slots+","+normal_slots+","+vip_slots_cost+","+normal_slots_cost);
	
	
	if (vip_slots.length == 0)
	{
		alert("Please Enter No. of VIP Slots !!");
		document.getElementById('vip_slots').focus();
		document.getElementById('vip_slotsMsg').innerHTML="Please Enter No. of VIP Slots !!";
		document.getElementById('normal_slotsMsg').innerHTML="";
		document.getElementById('vip_slots_costMsg').innerHTML="";
		document.getElementById('normal_slots_costMsg').innerHTML="";
		return false;
	} else if (isNaN(vip_slots))
	{
		alert("Please Enter only Numbers for No. of VIP Slots !!");
		document.getElementById('vip_slots').focus();
		document.getElementById('vip_slotsMsg').innerHTML="Please Enter only Numbers for No. of VIP Slots !!";
		document.getElementById('normal_slotsMsg').innerHTML="";
		document.getElementById('vip_slots_costMsg').innerHTML="";
		document.getElementById('normal_slots_costMsg').innerHTML="";
		return false;
	}else if (parseInt(vip_slots) > parseInt(pp_slots))
	{
		alert("No. of VIP Slots cannot be greater than Total No. of slots !!");
		document.getElementById('vip_slots').focus();
		document.getElementById('vip_slotsMsg').innerHTML="No. of VIP Slots cannot be greater than Total No. of slots !!";
		document.getElementById('normal_slotsMsg').innerHTML="";
		document.getElementById('vip_slots_costMsg').innerHTML="";
		document.getElementById('normal_slots_costMsg').innerHTML="";
		return false;
	}else if (normal_slots.length == 0)
	{
		alert("Please Enter No. of Normal Slots !!");
		document.getElementById('vip_slots').focus();
		document.getElementById('vip_slotsMsg').innerHTML="";
		document.getElementById('normal_slotsMsg').innerHTML="Please Enter No. of Normal Slots !!";
		document.getElementById('vip_slots_costMsg').innerHTML="";
		document.getElementById('normal_slots_costMsg').innerHTML="";
		return false;
	} else if (isNaN(normal_slots))
	{
		alert("Please Enter only Numbers for No. of Normal Slots !!");
		document.getElementById('vip_slots').focus();
		document.getElementById('vip_slotsMsg').innerHTML="";
		document.getElementById('normal_slotsMsg').innerHTML="Please Enter only Numbers for No. of Normal Slots !!";
		document.getElementById('vip_slots_costMsg').innerHTML="";
		document.getElementById('normal_slots_costMsg').innerHTML="";
		return false;
	}else if (parseInt(normal_slots) > parseInt(pp_slots))
	{
		alert("No. of Normal Slots cannot be greater than Total No. of slots !!");
		document.getElementById('vip_slots').focus();
		document.getElementById('vip_slotsMsg').innerHTML="";
		document.getElementById('normal_slotsMsg').innerHTML="No. of Normal Slots cannot be greater than Total No. of slots !!";
		document.getElementById('vip_slots_costMsg').innerHTML="";
		document.getElementById('normal_slots_costMsg').innerHTML="";
		return false;
	}else if ((parseInt(vip_slots) + parseInt(normal_slots)) > parseInt(pp_slots))
	{
		alert("Sum of (VIP and Normal) Slots cant be greater than Total No. of Slots !!");
		document.getElementById('vip_slots').focus();
		document.getElementById('vip_slotsMsg').innerHTML="";
		document.getElementById('normal_slotsMsg').innerHTML="Sum of (VIP and Normal) Slots cant be greater than Total No. of Slots !!";
		document.getElementById('vip_slots_costMsg').innerHTML="";
		document.getElementById('normal_slots_costMsg').innerHTML="";
		return false;
	}else if (vip_slots_cost.length == 0)
	{
		alert("Please Enter the cost of VIP Slots !!");
		document.getElementById('vip_slots').focus();
		document.getElementById('vip_slotsMsg').innerHTML="";
		document.getElementById('normal_slotsMsg').innerHTML="";
		document.getElementById('vip_slots_costMsg').innerHTML="Please Enter the cost of VIP Slots !!";
		document.getElementById('normal_slots_costMsg').innerHTML="";
		return false;
	} else if (isNaN(vip_slots_cost))
	{
		alert("Please Enter only Numbers for No. of VIP Slots Cost !!");
		document.getElementById('vip_slots').focus();
		document.getElementById('vip_slotsMsg').innerHTML="";
		document.getElementById('normal_slotsMsg').innerHTML="";
		document.getElementById('vip_slots_costMsg').innerHTML="Please Enter only Numbers for No. of VIP Slots Cost !!";
		document.getElementById('normal_slots_costMsg').innerHTML="";
		return false;
	}else if (normal_slots_cost.length == 0)
	{
		alert("Please Enter No. of VIP Slots !!");
		document.getElementById('vip_slots').focus();
		document.getElementById('vip_slotsMsg').innerHTML="";
		document.getElementById('normal_slotsMsg').innerHTML="";
		document.getElementById('vip_slots_costMsg').innerHTML="";
		document.getElementById('normal_slots_costMsg').innerHTML="Please Enter No. of Normal Slots cost !!";
		return false;
	} else if (isNaN(normal_slots_cost))
	{
		alert("Please Enter only Numbers for No. of Normal Slots Cost !!");
		document.getElementById('vip_slots').focus();
		document.getElementById('vip_slotsMsg').innerHTML="";
		document.getElementById('normal_slotsMsg').innerHTML="";
		document.getElementById('vip_slots_costMsg').innerHTML="";
		document.getElementById('normal_slots_costMsg').innerHTML="Please Enter only Numbers for No. of Normal Slots cost !!";
		return false;
	} else{
		return true;
	}
}

