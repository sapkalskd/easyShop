/**
 * LoginValidation.js
 */

$(document).ready(function(){

	$("#usernameError").hide();
	$("#passwordError").hide();

	var usernameError = false;
	var passwordError = false;

	$("#username").focusout(function(){
		validate_username();
	});

	$("#password").focusout(function(){
		validate_password();
	});


	function validate_username(){
		var val = $("#username").val();
		var exp = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;

		if(val == ''){
			$("#usernameError").html("Username must required.");
			$("#usernameError").css("color","red");
			$("#usernameError").show();

			usernameError = true;
		}
		else if(!exp.test(val)){
			$("#usernameError").html("Enter valid username");
			$("#usernameError").css("color","red");
			$("#usernameError").show();
			usernameError = true;
		}
		else{
			$("#usernameError").hide();
			usernameError = false;
		}
		return usernameError;
	}

	function validate_password(){
		var val = $("#password").val();

		if(val == ''){
			$("#passwordError").html("Password must be required.");
			$("#passwordError").css("color","red");
			$("#passwordError").show();

			passwordError = true;
		}
		else if(val.length < 8){
			$("#passwordError").html("Password must be between 8 to 20 charector");
			$("#passwordError").css("color","red");
			$("#passwordError").show();

			passwordError = true;
		}
		else{
			$("#passwordError").hide();
			passwordError = false;
		}
	}

	$("#loginForm").submit(function(){
		validate_username();
		validate_password();

		if(usernameError == false && passwordError == false)
			return true;
		else
			return false;
	});

});
