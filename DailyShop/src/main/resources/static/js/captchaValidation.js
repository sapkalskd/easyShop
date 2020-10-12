/**
 * Captcha Validation.js
 */

$(document).ready(function(){
	$("#confirmPasswordError").hide();
	$("#captchaError").hide();
	
	var confirmPasswordError = false;
	var captchaError = false;

	
	$("#password").focusout(function(){
		validate_confirmPassword();
	});
	
	$("#password").focusout(function(){
		validate_captcha();
	});

	function validate_confirmPassword(){
		
	}
});