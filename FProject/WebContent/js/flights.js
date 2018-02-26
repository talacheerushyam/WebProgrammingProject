/**
 * 
 */

function verifyFields(){
	
	var e = document.getElementById("AName");
	var AName = e.options[e.selectedIndex].value;
	
	e = document.getElementById("fromPlace");
	var fromPlace = e.options[e.selectedIndex].value;
	
	e = document.getElementById("toPlace");
	var toPlace =e.options[e.selectedIndex].value; 
	
	
	e = document.getElementById("Ftime");
	var Ftime =e.options[e.selectedIndex].value; 
	
	e = document.getElementById("Ttime");
	var Ttime =e.options[e.selectedIndex].value; 

	var d1 = new Date("1970-01-01 "+Ftime);
    var d2 = new Date("1970-01-01 "+Ttime);
	
  //  alert(d1>d2);
	
	var seats = document.getElementById('seats').value;
	var Bseats = document.getElementById('Bseats').value;
	var Fseats = document.getElementById('Fseats').value;
	var Eseats = document.getElementById('Eseats').value;
	var bcosts = document.getElementById('bcosts').value;
	var fcosts = document.getElementById('fcosts').value;
	var ecosts = document.getElementById('ecosts').value;
	
	
		
	if (AName == "select"){
		alert("Please Select Airlines !!");
		document.getElementById("AName").focus();
		document.getElementById("ANameMsg").innerHTML = "Please Select Airlines !!";
		document.getElementById("FromPlaceMsg").innerHTML = "";
		document.getElementById("ToPlaceMsg").innerHTML = "";
		document.getElementById("FTMsg").innerHTML = "";
		document.getElementById("SeatsMsg").innerHTML = "";
		document.getElementById("BSeatsMsg").innerHTML = "";
		document.getElementById("FSeatsMsg").innerHTML = "";
		document.getElementById("ESeatsMsg").innerHTML = "";
		document.getElementById("BCostsMsg").innerHTML = "";
		document.getElementById("FCostsMsg").innerHTML = "";
		document.getElementById("ECostsMsg").innerHTML = "";
		return false;
	} else if (fromPlace == "select"){
		alert("Please Select Starting Place !!");
		document.getElementById("fromPlace").focus();
		document.getElementById("FromPlaceMsg").innerHTML = "Please Select Starting Place !!";
		document.getElementById("ANameMsg").innerHTML = "";
		document.getElementById("ToPlaceMsg").innerHTML = "";
		document.getElementById("FTMsg").innerHTML = "";
		document.getElementById("SeatsMsg").innerHTML = "";
		document.getElementById("BSeatsMsg").innerHTML = "";
		document.getElementById("FSeatsMsg").innerHTML = "";
		document.getElementById("ESeatsMsg").innerHTML = "";
		document.getElementById("BCostsMsg").innerHTML = "";
		document.getElementById("FCostsMsg").innerHTML = "";
		document.getElementById("ECostsMsg").innerHTML = "";
		return false;
	} else if (toPlace == "select"){
		alert("Please Select Destination Place !!");
		document.getElementById("toPlace").focus();
		document.getElementById("ToPlaceMsg").innerHTML = "Please Select Destination Place !!";
		document.getElementById("ANameMsg").innerHTML = "";
		document.getElementById("FromPlaceMsg").innerHTML = "";
		document.getElementById("FTMsg").innerHTML = "";
		document.getElementById("SeatsMsg").innerHTML = "";
		document.getElementById("BSeatsMsg").innerHTML = "";
		document.getElementById("FSeatsMsg").innerHTML = "";
		document.getElementById("ESeatsMsg").innerHTML = "";
		document.getElementById("BCostsMsg").innerHTML = "";
		document.getElementById("FCostsMsg").innerHTML = "";
		document.getElementById("ECostsMsg").innerHTML = "";
		return false;
	}else if (toPlace == fromPlace){
		alert("Please Select Different Place Starting and Destination !!");
		document.getElementById("fromPlace").focus();
		document.getElementById("FromPlaceMsg").innerHTML = "Please Select Different Place Starting and Destination !!";
		document.getElementById("ANameMsg").innerHTML = "";
		document.getElementById("ToPlaceMsg").innerHTML = "";
		document.getElementById("FTMsg").innerHTML = "";
		document.getElementById("SeatsMsg").innerHTML = "";
		document.getElementById("BSeatsMsg").innerHTML = "";
		document.getElementById("FSeatsMsg").innerHTML = "";
		document.getElementById("ESeatsMsg").innerHTML = "";
		document.getElementById("BCostsMsg").innerHTML = "";
		document.getElementById("FCostsMsg").innerHTML = "";
		document.getElementById("ECostsMsg").innerHTML = "";
		return false;
	}else if (Ftime == "select"){
		alert("Please Select Starting Time !!");
		document.getElementById("Ftime").focus();
		document.getElementById("FTMsg").innerHTML = "Please Select Starting Time !!";
		document.getElementById("ANameMsg").innerHTML = "";
		document.getElementById("FromPlaceMsg").innerHTML = "";
		document.getElementById("ToPlaceMsg").innerHTML = "";
		document.getElementById("SeatsMsg").innerHTML = "";
		document.getElementById("BSeatsMsg").innerHTML = "";
		document.getElementById("FSeatsMsg").innerHTML = "";
		document.getElementById("ESeatsMsg").innerHTML = "";
		document.getElementById("BCostsMsg").innerHTML = "";
		document.getElementById("FCostsMsg").innerHTML = "";
		document.getElementById("ECostsMsg").innerHTML = "";
		return false;
	} else if (Ttime == "select"){
		alert("Please Select Reaching Time !!");
		document.getElementById("Ttime").focus();
		document.getElementById("FTMsg").innerHTML = "Please Select Reaching Time !!";
		document.getElementById("ANameMsg").innerHTML = "";
		document.getElementById("FromPlaceMsg").innerHTML = "";
		document.getElementById("ToPlaceMsg").innerHTML = "";
		document.getElementById("SeatsMsg").innerHTML = "";
		document.getElementById("BSeatsMsg").innerHTML = "";
		document.getElementById("FSeatsMsg").innerHTML = "";
		document.getElementById("ESeatsMsg").innerHTML = "";
		document.getElementById("BCostsMsg").innerHTML = "";
		document.getElementById("FCostsMsg").innerHTML = "";
		document.getElementById("ECostsMsg").innerHTML = "";
		return false;
	} else if (d1>d2){
		alert("Starting time cannot be greater than Reaching Time !!");
		document.getElementById("Ftime").focus();
		document.getElementById("FTMsg").innerHTML = "Starting time cannot be greater than Reaching Time !!";
		document.getElementById("ANameMsg").innerHTML = "";
		document.getElementById("FromPlaceMsg").innerHTML = "";
		document.getElementById("ToPlaceMsg").innerHTML = "";
		document.getElementById("SeatsMsg").innerHTML = "";
		document.getElementById("BSeatsMsg").innerHTML = "";
		document.getElementById("FSeatsMsg").innerHTML = "";
		document.getElementById("ESeatsMsg").innerHTML = "";
		document.getElementById("BCostsMsg").innerHTML = "";
		document.getElementById("FCostsMsg").innerHTML = "";
		document.getElementById("ECostsMsg").innerHTML = "";
		return false;
	}else if (seats.length == 0){
		alert("Please Enter Total No. of Seats in this flight!!");
		document.getElementById("seats").focus();
		document.getElementById("SeatsMsg").innerHTML = "Please Enter Total No. of Seats in this flight!!";
		document.getElementById("ANameMsg").innerHTML = "";
		document.getElementById("FromPlaceMsg").innerHTML = "";
		document.getElementById("ToPlaceMsg").innerHTML = "";
		document.getElementById("FTMsg").innerHTML = "";
		document.getElementById("BSeatsMsg").innerHTML = "";
		document.getElementById("FSeatsMsg").innerHTML = "";
		document.getElementById("ESeatsMsg").innerHTML = "";
		document.getElementById("BCostsMsg").innerHTML = "";
		document.getElementById("FCostsMsg").innerHTML = "";
		document.getElementById("ECostsMsg").innerHTML = "";
		return false;
	}else if (isNaN(seats)){
		alert("Please Enter Only numbers for Total no. of seats !!");
		document.getElementById("seats").focus();
		document.getElementById("SeatsMsg").innerHTML = "Please Enter Only numbers for Total no. of seats !!";
		document.getElementById("ANameMsg").innerHTML = "";
		document.getElementById("FromPlaceMsg").innerHTML = "";
		document.getElementById("ToPlaceMsg").innerHTML = "";
		document.getElementById("FTMsg").innerHTML = "";
		document.getElementById("BSeatsMsg").innerHTML = "";
		document.getElementById("FSeatsMsg").innerHTML = "";
		document.getElementById("ESeatsMsg").innerHTML = "";
		document.getElementById("BCostsMsg").innerHTML = "";
		document.getElementById("FCostsMsg").innerHTML = "";
		document.getElementById("ECostsMsg").innerHTML = "";
		return false;
	}else if (Bseats.length == 0){
		alert("Please Enter Total No. of Business Class Seats in this flight!!");
		document.getElementById("Bseats").focus();
		document.getElementById("BSeatsMsg").innerHTML = "Please Enter Total No. of Seats in this flight!!";
		document.getElementById("ANameMsg").innerHTML = "";
		document.getElementById("FromPlaceMsg").innerHTML = "";
		document.getElementById("ToPlaceMsg").innerHTML = "";
		document.getElementById("FTMsg").innerHTML = "";
		document.getElementById("SeatsMsg").innerHTML = "";
		document.getElementById("FSeatsMsg").innerHTML = "";
		document.getElementById("ESeatsMsg").innerHTML = "";
		document.getElementById("BCostsMsg").innerHTML = "";
		document.getElementById("FCostsMsg").innerHTML = "";
		document.getElementById("ECostsMsg").innerHTML = "";
		return false;
	}else if (isNaN(Bseats)){
		alert("Please Enter Only numbers  !!");
		document.getElementById("seats").focus();
		document.getElementById("BSeatsMsg").innerHTML = "Please Enter Only numbers !!";
		document.getElementById("ANameMsg").innerHTML = "";
		document.getElementById("FromPlaceMsg").innerHTML = "";
		document.getElementById("ToPlaceMsg").innerHTML = "";
		document.getElementById("FTMsg").innerHTML = "";
		document.getElementById("SeatsMsg").innerHTML = "";
		document.getElementById("FSeatsMsg").innerHTML = "";
		document.getElementById("ESeatsMsg").innerHTML = "";
		document.getElementById("BCostsMsg").innerHTML = "";
		document.getElementById("FCostsMsg").innerHTML = "";
		document.getElementById("ECostsMsg").innerHTML = "";
		return false;
	}else if (Fseats.length == 0){
		alert("Please Enter Total No. of First Class Seats in this flight!!");
		document.getElementById("Fseats").focus();
		document.getElementById("FSeatsMsg").innerHTML = "Please Enter Total No. of First Class Seats in this flight!!";
		document.getElementById("ANameMsg").innerHTML = "";
		document.getElementById("FromPlaceMsg").innerHTML = "";
		document.getElementById("ToPlaceMsg").innerHTML = "";
		document.getElementById("FTMsg").innerHTML = "";
		document.getElementById("SeatsMsg").innerHTML = "";
		document.getElementById("BSeatsMsg").innerHTML = "";
		document.getElementById("ESeatsMsg").innerHTML = "";
		document.getElementById("BCostsMsg").innerHTML = "";
		document.getElementById("FCostsMsg").innerHTML = "";
		document.getElementById("ECostsMsg").innerHTML = "";
		return false;
	}else if (isNaN(Fseats)){
		alert("Please Enter Only numbers  !!");
		document.getElementById("Fseats").focus();
		document.getElementById("FSeatsMsg").innerHTML = "Please Enter Only numbers  !!";
		document.getElementById("ANameMsg").innerHTML = "";
		document.getElementById("FromPlaceMsg").innerHTML = "";
		document.getElementById("ToPlaceMsg").innerHTML = "";
		document.getElementById("FTMsg").innerHTML = "";
		document.getElementById("SeatsMsg").innerHTML = "";
		document.getElementById("BSeatsMsg").innerHTML = "";
		document.getElementById("ESeatsMsg").innerHTML = "";
		document.getElementById("BCostsMsg").innerHTML = "";
		document.getElementById("FCostsMsg").innerHTML = "";
		document.getElementById("ECostsMsg").innerHTML = "";
		return false;
	}else if (Eseats.length == 0){
		alert("Please Enter Total No. of Economy Class Seats in this flight!!");
		document.getElementById("Eseats").focus();
		document.getElementById("ESeatsMsg").innerHTML = "Please Enter Total No. of Economy Class Seats in this flight!!";
		document.getElementById("ANameMsg").innerHTML = "";
		document.getElementById("FromPlaceMsg").innerHTML = "";
		document.getElementById("ToPlaceMsg").innerHTML = "";
		document.getElementById("FTMsg").innerHTML = "";
		document.getElementById("SeatsMsg").innerHTML = "";
		document.getElementById("BSeatsMsg").innerHTML = "";
		document.getElementById("FSeatsMsg").innerHTML = "";
		document.getElementById("BCostsMsg").innerHTML = "";
		document.getElementById("FCostsMsg").innerHTML = "";
		document.getElementById("ECostsMsg").innerHTML = "";
		return false;
	}else if (((parseInt(Eseats)+parseInt(Fseats)+parseInt(Bseats)) > parseInt(seats)) 
			|| ((parseInt(Eseats)+parseInt(Fseats)+parseInt(Bseats)) !== parseInt(seats))){
		alert(" Business, First and Economy total seats should be less total number of seats !!");
		document.getElementById("Eseats").focus();
		document.getElementById("ESeatsMsg").innerHTML = " Business, First and Economy total seats should be less total number of seats !!";
		document.getElementById("ANameMsg").innerHTML = "";
		document.getElementById("FromPlaceMsg").innerHTML = "";
		document.getElementById("ToPlaceMsg").innerHTML = "";
		document.getElementById("FTMsg").innerHTML = "";
		document.getElementById("SeatsMsg").innerHTML = "";
		document.getElementById("BSeatsMsg").innerHTML = "";
		document.getElementById("FSeatsMsg").innerHTML = "";
		document.getElementById("BCostsMsg").innerHTML = "";
		document.getElementById("FCostsMsg").innerHTML = "";
		document.getElementById("ECostsMsg").innerHTML = "";
		return false;
	}else if (isNaN(Eseats)){
		alert("Please Enter Only numbers  !!");
		document.getElementById("Eseats").focus();
		document.getElementById("ESeatsMsg").innerHTML = "Please Enter Only numbers  !!";
		document.getElementById("ANameMsg").innerHTML = "";
		document.getElementById("FromPlaceMsg").innerHTML = "";
		document.getElementById("ToPlaceMsg").innerHTML = "";
		document.getElementById("FTMsg").innerHTML = "";
		document.getElementById("SeatsMsg").innerHTML = "";
		document.getElementById("BSeatsMsg").innerHTML = "";
		document.getElementById("FSeatsMsg").innerHTML = "";
		document.getElementById("BCostsMsg").innerHTML = "";
		document.getElementById("FCostsMsg").innerHTML = "";
		document.getElementById("ECostsMsg").innerHTML = "";
		return false;
	}else if (bcosts.length == 0){
		alert("Please Enter Cost for Each Busniess Class Seats  !!");
		document.getElementById("bcosts").focus();
		document.getElementById("BCostsMsg").innerHTML = "Please Enter Cost for Each Busniess Class Seats  !!";
		document.getElementById("ANameMsg").innerHTML = "";
		document.getElementById("FromPlaceMsg").innerHTML = "";
		document.getElementById("ToPlaceMsg").innerHTML = "";
		document.getElementById("FTMsg").innerHTML = "";
		document.getElementById("SeatsMsg").innerHTML = "";
		document.getElementById("BSeatsMsg").innerHTML = "";
		document.getElementById("FSeatsMsg").innerHTML = "";
		document.getElementById("ESeatsMsg").innerHTML = "";
		document.getElementById("FCostsMsg").innerHTML = "";
		document.getElementById("ECostsMsg").innerHTML = "";
		return false;
	}else if (isNaN(bcosts)){
		alert("Please Enter Only numbers  !!");
		document.getElementById("bcosts").focus();
		document.getElementById("BCostsMsg").innerHTML = "Please Enter Only numbers  !!";
		document.getElementById("ANameMsg").innerHTML = "";
		document.getElementById("FromPlaceMsg").innerHTML = "";
		document.getElementById("ToPlaceMsg").innerHTML = "";
		document.getElementById("FTMsg").innerHTML = "";
		document.getElementById("SeatsMsg").innerHTML = "";
		document.getElementById("BSeatsMsg").innerHTML = "";
		document.getElementById("FSeatsMsg").innerHTML = "";
		document.getElementById("ESeatsMsg").innerHTML = "";
		document.getElementById("FCostsMsg").innerHTML = "";
		document.getElementById("ECostsMsg").innerHTML = "";
		return false;
	}else if (fcosts.length == 0){
		alert("Please Enter Cost for Each First Class Seats  !!");
		document.getElementById("fcosts").focus();
		document.getElementById("FCostsMsg").innerHTML = "Please Enter Cost for Each First Class Seats  !!";
		document.getElementById("ANameMsg").innerHTML = "";
		document.getElementById("FromPlaceMsg").innerHTML = "";
		document.getElementById("ToPlaceMsg").innerHTML = "";
		document.getElementById("DaysMsg").innerHTML = "";
		document.getElementById("SeatsMsg").innerHTML = "";
		document.getElementById("BSeatsMsg").innerHTML = "";
		document.getElementById("FSeatsMsg").innerHTML = "";
		document.getElementById("ESeatsMsg").innerHTML = "";
		document.getElementById("BCostsMsg").innerHTML = "";
		document.getElementById("ECostsMsg").innerHTML = "";
		return false;
	}else if (isNaN(fcosts)){
		alert("Please Enter Only numbers  !!");
		document.getElementById("fcosts").focus();
		document.getElementById("FCostsMsg").innerHTML = "Please Enter Only numbers  !!";
		document.getElementById("ANameMsg").innerHTML = "";
		document.getElementById("FromPlaceMsg").innerHTML = "";
		document.getElementById("ToPlaceMsg").innerHTML = "";
		document.getElementById("FTMsg").innerHTML = "";
		document.getElementById("SeatsMsg").innerHTML = "";
		document.getElementById("BSeatsMsg").innerHTML = "";
		document.getElementById("FSeatsMsg").innerHTML = "";
		document.getElementById("ESeatsMsg").innerHTML = "";
		document.getElementById("BCostsMsg").innerHTML = "";
		document.getElementById("ECostsMsg").innerHTML = "";
		return false;
	}else if (ecosts.length == 0){
		alert("Please Enter Cost for Each Economy Class Seats  !!");
		document.getElementById("ecosts").focus();
		document.getElementById("ECostsMsg").innerHTML = "Please Enter Cost for Each Economy Class Seats  !!";
		document.getElementById("ANameMsg").innerHTML = "";
		document.getElementById("FromPlaceMsg").innerHTML = "";
		document.getElementById("ToPlaceMsg").innerHTML = "";
		document.getElementById("FTMsg").innerHTML = "";
		document.getElementById("SeatsMsg").innerHTML = "";
		document.getElementById("BSeatsMsg").innerHTML = "";
		document.getElementById("FSeatsMsg").innerHTML = "";
		document.getElementById("ESeatsMsg").innerHTML = "";
		document.getElementById("BCostsMsg").innerHTML = "";
		document.getElementById("FCostsMsg").innerHTML = "";
		return false;
	}else if (isNaN(ecosts)){
		alert("Please Enter Only numbers  !!");
		document.getElementById("ecosts").focus();
		document.getElementById("ECostsMsg").innerHTML = "Please Enter Only numbers  !!";
		document.getElementById("ANameMsg").innerHTML = "";
		document.getElementById("FromPlaceMsg").innerHTML = "";
		document.getElementById("ToPlaceMsg").innerHTML = "";
		document.getElementById("FTMsg").innerHTML = "";
		document.getElementById("SeatsMsg").innerHTML = "";
		document.getElementById("BSeatsMsg").innerHTML = "";
		document.getElementById("FSeatsMsg").innerHTML = "";
		document.getElementById("ESeatsMsg").innerHTML = "";
		document.getElementById("BCostsMsg").innerHTML = "";
		document.getElementById("FCostsMsg").innerHTML = "";
		return false;
	} else{
		document.getElementById("ECostsMsg").innerHTML = "";
		document.getElementById("ANameMsg").innerHTML = "";
		document.getElementById("FromPlaceMsg").innerHTML = "";
		document.getElementById("ToPlaceMsg").innerHTML = "";
		document.getElementById("FTMsg").innerHTML = "";
		document.getElementById("SeatsMsg").innerHTML = "";
		document.getElementById("BSeatsMsg").innerHTML = "";
		document.getElementById("FSeatsMsg").innerHTML = "";
		document.getElementById("ESeatsMsg").innerHTML = "";
		document.getElementById("BCostsMsg").innerHTML = "";
		document.getElementById("FCostsMsg").innerHTML = "";
		return true;
	}
		
	return false;
}
