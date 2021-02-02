// Load
document.addEventListener("DOMContentLoaded", () => {
	init();
});

function init(){
	
}

function login(){
	document.querySelector("#form1").addEventListener("submit", function(evt){
		evt.preventDefault();
		var result = document.querySelector(".result");
		var emailValue = document.querySelector("[name='resrv_email']").value;
	    var bValid = (/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i).test(emailValue);
	    if(!bValid)  { 
	      result.innerHTML = "올바르지 않은 이메일입니다.";
	    } else {
    	  document.querySelector("#form1").submit();
	    }
	});
}