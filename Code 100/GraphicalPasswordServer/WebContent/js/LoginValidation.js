function validate(form) {
	if (form.email.value == "") {
		alert("Error: Please Enter Email !");
		form.email.focus();
		return false;
	}
	return true;
}
