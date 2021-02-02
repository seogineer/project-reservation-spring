let indexCount;
let totalCount;
let selectedCategoryId;

function init(){
	indexCount = 4;
	selectedCategoryId = 0;
	playSlide();
}

function productLoad(json, requestMode){
	indexCount += json.length;
	
	let itemHTML = document.querySelector("#itemList").innerHTML;
	
	let item = "";
	let item2 = "";
	for(let i = 0; i < json.length; i++){
		if(i%2 > 0){
			item += itemHTML.replace("{displayInfoId}", json[i].displayInfoId)
							.replace("{productId}", json[i].productId)
							.replace("{description}", json[i].productDescription)
							.replace("{description}", json[i].productDescription)
							.replace("{placeName}", json[i].placeName)
							.replace("{content}", json[i].productContent)
							.replace("{imageUrl}", json[i].productImageUrl);
		}
		
		if(i%2 == 0){
			item2 += itemHTML.replace("{displayInfoId}", json[i].displayInfoId)
							.replace("{productId}", json[i].productId)
							.replace("{description}", json[i].productDescription)
							.replace("{description}", json[i].productDescription)
							.replace("{placeName}", json[i].placeName)
							.replace("{content}", json[i].productContent)
							.replace("{imageUrl}", json[i].productImageUrl);
		}
	}
	
	if(requestMode == 1){	//requestMode = 1 : 더보기 버튼으로 상품 목록을 추가로 Load할 경우
		document.querySelector(".lst_event_box").innerHTML += item;
		document.querySelector(".lst_event_box").nextElementSibling.innerHTML += item2;		
	} else if (requestMode == 2) { //requestMode = 2 : 탭 버튼 변경으로 상품 목록을 4개만 Load할 경우
		document.querySelector(".lst_event_box").innerHTML = item;
		document.querySelector(".lst_event_box").nextElementSibling.innerHTML = item2;
	}
	
	if(indexCount >= totalCount){
		document.getElementById("moreBtn").style.display = "none";
	} else {
		document.getElementById("moreBtn").style.display = "block";
	}
	
}

//상품 개수 load
function countLoad(value){
	totalCount = value;
	
	let countHTML = document.querySelector(".pink");
	countHTML.innerHTML = value + "개";
}

//category 클릭 시 동작
function tabClick(e){
	// tab 모양 변경
	let target = e;
	let categoryList = document.querySelectorAll(".anchor");
	for(let i = 0; i < categoryList.length; i++){
		categoryList[i].setAttribute('class', 'anchor');
	}
	target.parentElement.setAttribute('class', 'anchor active');
	
	// 상품 목록 ajax 요청
	if(target.parentElement.parentElement.getAttribute("data-category") == 0) {
		indexCount = 0;
		selectedCategoryId = 0;
		ajaxRequest(2, 0);
	} else if(target.parentElement.parentElement.getAttribute("data-category") == 1){
		indexCount = 0;
		selectedCategoryId = 1;
		ajaxRequest(2, 1);
	} else if(target.parentElement.parentElement.getAttribute("data-category") == 2){
		indexCount = 0;
		selectedCategoryId = 2;
		ajaxRequest(2, 2);
	} else if(target.parentElement.parentElement.getAttribute("data-category") == 3){
		indexCount = 0;
		selectedCategoryId = 3;
		ajaxRequest(2, 3);
	} else if(target.parentElement.parentElement.getAttribute("data-category") == 4){
		indexCount = 0;
		selectedCategoryId = 4;
		ajaxRequest(2, 4);
	} else if(target.parentElement.parentElement.getAttribute("data-category") == 5){
		indexCount = 0;
		selectedCategoryId = 5;
		ajaxRequest(2, 5);
	}
}

//더보기 버튼 클릭시 동작
function moreBtn(){
	ajaxRequest(1, selectedCategoryId);
}

// ajax 요청 처리
// requestMode = 1 : 더보기
// requestMode = 2 : 탭 버튼
function ajaxRequest(requestMode, categoryId){
	var xhr = new XMLHttpRequest();
	xhr.onload = function () {
	    if (xhr.status == "200") {
	        let json = JSON.parse(xhr.responseText);
			if(requestMode == 1){
				productLoad(json.productList, requestMode);
			} else if(requestMode == 2){
				productLoad(json.productList, requestMode);
				countLoad(json.count);
			}
	    }
	}
	
	if(requestMode == 1){
		xhr.open("GET", "main?start=" + indexCount + "&categoryId=" + categoryId);
	} else if(requestMode == 2){		
		xhr.open("GET", "main?categoryId=" + categoryId);
	}
	
	xhr.send();
}

// Slides start
function playSlide(){
	let slideWrapper = document.querySelector('.slide_container');
	let slides = document.querySelectorAll(".promotionItem");
	let totalSlides = slides.length; // item의 갯수

	let sliderWidth = slideWrapper.clientWidth; // container의 width
	let slideIndex = 0;
	let slider = document.querySelector('.visual_img');
	
	slider.style.width = sliderWidth * totalSlides + 'px';
	
	showSlides();
	
	function showSlides() {
	    for(let i=0;i<slides.length;i++){
	        slider.style.left = -(sliderWidth * slideIndex) + 'px';    
	    }
	    slideIndex++;
	    if (slideIndex === totalSlides) {
	        slideIndex = 0;
	    }
	    setTimeout(showSlides, 2000); 
	}
}
// Slides end

// Load
document.addEventListener("DOMContentLoaded", () => {
	init();
});