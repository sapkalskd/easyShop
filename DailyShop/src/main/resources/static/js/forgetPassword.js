/**
 * forgatePassword.js 
 */

$(document).ready(function(){

	$("#forgetPasswordError").hide();
	
	var forgetPasswordError = false;
	
	$("#forgetPassword").focusout(function(){
		validate_email();
	})
	
	function validate_email(){
		var val = $("#forgetPassword").val();
		var exp = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
		
		if(val == ''){
			$("#forgetPasswordError").html("E-mail is required !");
			$("#forgetPasswordError").css("color","red");
			$("#forgetPasswordError").show();
			
			forgetPasswordError = true;
		}
		else if(!exp.test(val)){
			$("#forgetPasswordError").html("Please enter valid e-mail id !");
			$("#forgetPasswordError").css("color","red");
			$("#forgetPasswordError").show();
			
			forgetPasswordError = true;
		}
		else{
			$("#forgetPasswordError").hide();
			forgetPasswordError = false;
			
		}
			return forgetPasswordError;
	}
	
	$("#forgetPasswordForm").submit(function(){
		validate_email();
		
		if(forgetPasswordError == false)
			return true;
		else
			return false;
			
	});
	
});