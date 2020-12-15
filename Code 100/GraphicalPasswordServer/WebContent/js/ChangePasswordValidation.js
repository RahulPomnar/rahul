function validate(form) {


	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	if (form.password.value == "") {
		alert("Error: Please Enter Password !");
		form.password.focus();
		return false;
	}
	
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
