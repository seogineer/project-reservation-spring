function init(){
	
}

let agreeBtnFlag1 = 0;
let agreeBtnFlag2 = 0;
let agreeAllBtnFlag = 0;

function agreementBtn1(){
	let agreeDetails = document.querySelector(".useragreement_details_1");
	
	if(agreeBtnFlag1 == 0){
		agreeDetails.setAttribute('class', 'useragreement_details useragreement_details_1 open');
		agreeBtnFlag1 = 1;
	} else if(agreeBtnFlag1 == 1){
		agreeDetails.setAttribute('class', 'useragreement_details useragreement_details_1');
		agreeBtnFlag1 = 0;
	}
}

function agreementBtn2(){
	let agreeDetails = document.querySelector(".useragreement_details_2");
	
	if(agreeBtnFlag2 == 0){
		agreeDetails.setAttribute('class', 'useragreement_details useragreement_details_2 open');
		agreeBtnFlag2 = 1;
	} else if(agreeBtnFlag2 == 1){
		agreeDetails.setAttribute('class', 'useragreement_details useragreement_details_2');
		agreeBtnFlag2 = 0;
	}
}

function agreementAllBtn(){
	let reserveBtn = document.querySelector(".bk_btn_wrap");
	
	if(agreeAllBtnFlag == 0){
		reserveBtn.setAttribute('class', 'bk_btn_wrap');
		reserveBtn.firstChild.nextElementSibling.disabled = false;
		agreeAllBtnFlag = 1;
	} else if(agreeAllBtnFlag == 1){
		reserveBtn.setAttribute('class', 'bk_btn_wrap disable');
		reserveBtn.firstChild.nextElementSibling.setAttribute('disabled', 'disabled');
		agreeAllBtnFlag = 0;
	}
}

function plusBtn(e){
	let productPriceId = e.nextSibling.nextElementSibling.innerHTML;
	let price = document.querySelector(".price"+productPriceId).innerHTML;
	let totalPrice = document.querySelector(".total_price"+productPriceId);
	let totalCount = document.querySelector("#totalCount");
	
	e.previousSibling.previousElementSibling.value = (e.previousSibling.previousElementSibling.value * 1) + 1;	//수량 value
	totalCount.innerHTML = (totalCount.innerHTML*1) + 1;
	
	totalPrice.innerHTML = price * e.previousSibling.previousElementSibling.value;

	e.previousSibling.previousSibling.previousSibling.previousElementSibling.setAttribute('class', 'btn_plus_minus spr_book2 ico_minus3');
}

function minusBtn(e){
	let productPriceId = e.nextSibling.nextSibling.nextSibling.nextSibling.nextElementSibling.innerHTML;
	let price = document.querySelector(".price"+productPriceId).innerHTML;
	let totalPrice = document.querySelector(".total_price"+productPriceId);
	let totalCount = document.querySelector("#totalCount");
	
	if(e.nextSibling.nextElementSibling.value > 0){
		e.nextSibling.nextElementSibling.value = (e.nextSibling.nextElementSibling.value * 1) - 1;	//수량 value		
		totalCount.innerHTML = (totalCount.innerHTML*1) - 1;
		totalPrice.innerHTML = price * e.nextSibling.nextElementSibling.value;
		
		if(e.nextSibling.nextElementSibling.value == 0){
			e.setAttribute('class', 'btn_plus_minus spr_book2 ico_minus3 disabled');
		}
	}
}

//뒤로가기
function goback(){
	history.back();
}

// Load
document.addEventListener("DOMContentLoaded", () => {
	init();
});