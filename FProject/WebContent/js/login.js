/**
 * 
 */

function adminverify() {
	alert("");
	alert(document.getElementById("auid").value);
	var uname = document.getElementById("auid").value;
	var pass = document.getElementById("apwd").value;
	alert(uname+"-"+pass);
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