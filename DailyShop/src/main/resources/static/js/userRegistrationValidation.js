/**
 * userValidation.js
 */

$(document).ready(function(){
	$("#firstNameError").hide();
	$("#lastNameError").hide();
	$("#emailError").hide();
	$("#phoneNoError").hide();
	$("#passwordError").hide();
	$("#confirmPasswordError").hide();
	$("#captchaError").hide();

	var firstNameError = false;
	var lastNameError = false;
	var emailError = false;
	var phoneNoError = false;
	var passwordError = false;
	var confirmPasswordError = false;
	var captchaError = false;

	$("#firstName").focusout(function(){
		validate_firstName();
	});

	$("#lastName").focusout(function(){
		validate_lastName();
	});

	$("#email").focusout(function(){
		validate_email();
	});

	$("#phoneNo").focusout(function(){
		validate_phoneNo();
	});

	$("#password").focusout(function(){
		validate_password();
	});
	
	$("#confirmPassword").focusout(function(){
		validate_confirmPassword();
	});
	
	$("#captcha").focusout(function(){
		validate_captcha();
	});


	//----------Function-----------------
	function validate_firstName(){
		var val = $("#firstName").val();
		var isNumber = $.isNumeric($("#firstName").val())

		if(val == ''){
			$("#firstNameError").html("First name is required");
			$("#firstNameError").css("color", "red");
			$("#firstNameError").show();
			firstNameError = true;
		}
		else if(isNumber) {

			$("#firstNameError").html("Only charecters are allowed ");
			$("#firstNameError").css("color", "red");
			$("#firstNameError").show();
			firstNameError = true;
		}
		else {
			$("#firstNameError").hide();
			firstNameError = false;
		}

		return firstNameError;

	}//validate_firstName() end

	function validate_lastName(){
		var val = $("#lastName").val();
		var isNumber = $.isNumeric($("#lastName").val())

		if(val == ''){
			$("#lastNameError").html("Last name is required");
			$("#lastNameError").css("color", "red");
			$("#lastNameError").show();
			lastNameError = true;
		}
		else if (isNumber) {
			$("#lastNameError").html("Only charecters are allowed ");
			$("#lastNameError").css("color", "red");
			$("#lastNameError").show();
			lastNameError = true;
		}
		else {
			$("#lastNameError").hide();
			lastNameError = false;
		}
		return lastNameError;
	}//validate_lastName() end


	function validate_email(){
		var val = $("#email").val();
		var exp = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;

		if(val == ''){
			$("#emailError").html("E-mail is required");
			$("#emailError").css("color","red");
			$("#emailError").show();

			emailError = true;
		}
		else if(!exp.test(val)){
			$("#emailError").html("Invalid e-mail ");
			$("#emailError").css("color","red");
			$("#emailError").show();

			emailError = true;
		}
		else{
			/*		var loc = 'validateEmail';
			var id = 0;
			if ($("#id").val() !== undefined) {
				// edit page
				loc = '../validateEmail';
				id = $("#id").val();
			}

			//ajax start
			$.ajax({
				url : loc,
				data : {
					"mail" : val,
					"id" : id
				},
				success : function(resTxt) {
					if (resTxt != '') {
						$("#emailError").html(resTxt);
						$("#emailError").css("color", "red");
						$("#emailError").show();
						emailError = true;
					} 
					else {
						$("#emailError").hide();
						emailError = false;
					}
				}
			});
			 */
			$("#emailError").hide();
			emailError = false;
		}
		return emailError;
	}//end

	function validate_phoneNo(){
		var val = $("#phoneNo").val();
		var isNumber = $.isNumeric($("#phoneNo").val())

		if(val == '' || val.length < 10){
			$("#phoneNoError").html("Please fill valid Mobile No");
			$("#phoneNoError").css("color", "red");
			$("#phoneNoError").show();
			phoneNoError = true;
		}
		else if(!isNumber){
			$("#phoneNoError").html("Mobile No. must be numeric value");
			$("#phoneNoError").css("color", "red");
			$("#phoneNoError").show();
			phoneNoError = true;
		}
		else{
			$("#phoneNoError").hide();
			phoneNoError = false;
		}
		return phoneNoError;
	}

	function validate_password(){
		var val = $("#password").val();

		if(val == ''){
			$("#passwordError").html("Password must be required.");
			$("#passwordError").css("color", "red");
			$("#passwordError").show();
			passwordError = true;
		}
		else if(val.length < 8){
			$("#passwordError").html("Password must be between 8 to 20 charector only");
			$("#passwordError").css("color", "red");
			$("#passwordError").show();
			passwordError = true;
		}
		else{
			$("#passwordError").hide();
			passwordError = false;
		}
	}

/*	
	function validate_confirmPassword(){
		var password = $("#password").val();
		var confirmPwd = $("#confirmPassword").val();
		
		if(password != confirmPwd){
			$("#confirmPasswordError").html("Password not match");
			$("#confirmPasswordError").css("color", "red");
			$("#confirmPasswordError").show();
			
			confirmPasswordError = true;
		}
		else if(password == ''){
			$("#confirmPasswordError").html("Please confirm password");
			$("#confirmPasswordError").css("color", "red");
			$("#confirmPasswordError").show();
			
			confirmPasswordError = true;
		}
		else{
			$("#confirmPasswordError").hide();
			confirmPasswordError = false;
		}
		return confirmPasswordError;
	}
*/
	
	function validate_confirmPassword(){
		var pwd = $("#password").val();
		var cPwd = $("#confirmPassword").val();

		if(cPwd == ''){
			$("#confirmPasswordError").html("Confirm password must required");
			$("#confirmPasswordError").css("color", "red");
			$("#confirmPasswordError").show();
			
			confirmPasswordError = true;
			
		}else if(cPwd != pwd ){
			$("#confirmPasswordError").html("Password not match");
			$("#confirmPasswordError").css("color", "red");
			$("#confirmPasswordError").show();
			
			confirmPasswordError = true;
			
		}else{
			$("#confirmPasswordError").hide();
			confirmPasswordError = false;
		}
		
		return confirmPasswordError;
	}
	
	function validate_captcha(){
		var hidden = $(user.hidden).val();
		var captcha = $("#captcha").val();
		
		if(captcha == ''){
			$("#captchaError").html("Please enter captcha");
			$("#captchaError").css("color", "red");
			$("#captchaError").show();
			
			captchaError = true;
			
		}else if(captcha != hidden){
			$("#captchaError").html("Captcha does not match");
			$("#captchaError").css("color", "red");
			$("#captchaError").show();
			
			captchaError = true;
		}
		else{
			$("#captchaError").hide();
			captchaError = false;
		}
		
		return captchaError;
	}

	//On-submit
	$("#userRegstrationForm").submit( function(){

		validate_firstName();
		validate_lastName();
		validate_email();
		validate_phoneNo();
		validate_password();
		validate_confirmPassword();
		validate_captcha();

		if(firstNameError == false && 
				lastNameError == false && 
				emailError == false && 	
				phoneNoError == false && 
				passwordError == false &&
				confirmPassword == false &&
				captchaError == false)
			return true; 
		else
			return false;
	}); 
});
