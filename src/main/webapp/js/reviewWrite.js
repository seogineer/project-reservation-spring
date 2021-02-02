function init(){
	hiddenReviewWriteInfo();
	reviewValidCheck();
	imageThumb();
	imageDel();
	registSubmitEvent();
}

function registSubmitEvent(){
	document.querySelector(".box_bk_btn").addEventListener("click", function(event){
		event.preventDefault()
	});
	
}

//제출
function submit(){
	let ratingsIsOk = false;	//별점 검사
	let reviewTxtAreaIsOk = false;	//리뷰 글자수 검사
	
	let ratings = document.querySelectorAll(".rating_rdo");	//별점
	let txtAreaValue = document.querySelector(".review_textarea").value;	//리뷰 내용
	let re = /^.{5,400}$/;	//5~400자 허용
	
	//별점을 입력했는지 검사
	for(let i = 0; i < ratings.length; i++){
		if(ratings[i].checked){
			ratingsIsOk = true;
		}
	}
	
	//리뷰 내용 값 검사
	if(re.test(txtAreaValue)){
		reviewTxtAreaIsOk = true;
	}
	
	//별점이 입력되어 있지 않은 경우
	if(ratingsIsOk == false){
		document.querySelector(".warning_div").style = "";
		document.querySelector(".warning_space").innerHTML = "별점을 입력해주세요.";	//경고창 출력
		return;
	}
	
	//리뷰 내용이 5글자 미만인 경우
	if(reviewTxtAreaIsOk == false){
		document.querySelector(".warning_div").style = "";
		document.querySelector(".warning_space").innerHTML = "리뷰 내용을 최소 5글자 이상 입력해주세요.";	//경고창 출력
		return;
	}
	
	if(ratingsIsOk == true && reviewTxtAreaIsOk == true){
		document.querySelector("#review_form").submit();
	}
}

// 이미지 삭제
function imageDel(){
	let delBtn = document.querySelector(".spr_book");	// [x]버튼
	let thumbItem = document.querySelector(".item");	// 썸네일
	let elImage = document.querySelector(".item_thumb");	//이미지 태그
	delBtn.addEventListener("click", function(){
		document.getElementById("reviewImageFileOpenInput").value = "";	//업로드 파일 경로 초기화
        elImage.src = "";	//이미지 태그 src 경로 초기화
		thumbItem.style.display = "none";	// 썸네일 숨기기
	});
}

// 이미지 썸네일 처리
function imageThumb(){
	let elImage = document.querySelector("#reviewImageFileOpenInput");
	let thumbItem = document.querySelector(".item");
	elImage.addEventListener("change", function(evt){
		thumbItem.style = "";
		let image = evt.target.files[0];
		let elImage = document.querySelector(".item_thumb");
        elImage.src = window.URL.createObjectURL(image);
	});
}

// 글자수 점검
function reviewValidCheck(){
	let reviewTextarea = document.querySelector(".review_textarea");	//text_area
	let contentLength = document.querySelector(".content_length");		//글자수
	
	reviewTextarea.addEventListener("keyup", function(){	// keyup:키보드 버튼 누를 때마다
		if(reviewTextarea.value.length <= 400){	//400자 이하일 경우 글자수 업데이트
			contentLength.innerHTML = reviewTextarea.value.length;						
		}
		
		if(reviewTextarea.value.length > 400){	//400자 초과인 경우 0-400자까지 잘라서 더이상 입력 불가
			reviewTextarea.value = reviewTextarea.value.substring(0, 400);
		}
	});
}

// 리뷰 정보 숨기기
function hiddenReviewWriteInfo(){
	let reviewTextarea = document.querySelector(".review_textarea");	//text_area
	
	let reviewWriteInfo = document.querySelector(".review_write_info");	//write_info
	
	reviewWriteInfo.addEventListener("click", function(){
		reviewWriteInfo.style.display = "none";
	});
	
	reviewTextarea.addEventListener("blur", function(){	// blur: 포커싱이 없어질 때
		if(reviewTextarea.value == ""){
			reviewWriteInfo.style.display = "block";
		}
	});
}

//뒤로가기
function goback(){
	history.back();
}

// Load
document.addEventListener("DOMContentLoaded", () => {
	init();
});