function validateRegistration(form) {

	// alert(form.username);

	if (form.firstname.value == "") {
		alert("Error: Please Enter Firstname !");
		form.firstname.focus();
		return false;
	}
	
	
	if (form.address.value == "") {
		alert("Error: Please Enter Address !");
		form.address.focus();
		return false;
	}
	
	if (form.email.value == "") {
		alert("Error: Please Enter Email !");
		form.email.focus();
		return false;
	}
	
	if (form.mobileno.value == "") {
		alert("Error: Please Enter Mobileno !");
		form.mobileno.focus();
		return false;
	}
	
	/*var phoneno = /^\d{10}$/;
	if (form.mobileno.value.match(phoneno)) 
		return true;
	else{
		alert("Error: Please Enter the valid mobile number!");
		form.mobileno.focus();
		return false;
	}*/

	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	if (form.password.value == "") {
		alert("Error: Please Enter Password !");
		form.password.focus();
		return false;
	}
	
	//var re = /^(?=.*\d)(?=.*[@*])[a-f1-8]{6,}$/;
	var re = new RegExp("^(?=.*[a-f])(?=.*[1-8])(?=.*[!@#])(?=.{8,12})");
	var result=re.test(form.password.value);
	//alert(result);
	if(result==false){
		alert('enter valid password');
		form.password.focus();
		return false;
	}
	
	var e = document.getElementById("color");
	var type = e.options[e.selectedIndex].value;
	if (type == 0) {
		alert("Please select Password Color");
		return false;
	}

	
	return true;
}
