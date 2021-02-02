//별점 컴포넌트
function Rate(ratingElement){
	this.ratingElement = ratingElement;
	this.registRatingEvents();
}

Rate.prototype = {
	//별점 체크박스 각각 이벤트 등록
	registRatingEvents : function(){
		for(let i = 0; i < this.ratingElement.length; i++){
			this.ratingElement[i].addEventListener("click", function(evt){
				this.fillingStars(evt);
			}.bind(this));
		}	
	},
	
	//체크한 별의 value를 기준으로 value까지 checked, value + 1 부터 checked를 뺌
	fillingStars : function(evt){
		
		document.querySelector(".star_rank").innerHTML = evt.target.value;	//별점 값으로 변경
		document.querySelector(".star_rank").setAttribute("class", "star_rank");	//점수 색 변경
		
		for(let i = 0; i < evt.target.value; i++){
			//document.getElementsByName("rating" + i)[0].setAttribute("class", "rating_rdo checked");
			document.querySelectorAll(".rating_rdo")[i].setAttribute("class", "rating_rdo checked");
		}
		for(let j = evt.target.value; j < 5; j++){
			//document.getElementsByName("rating" + j)[0].setAttribute("class", "rating_rdo");
			document.querySelectorAll(".rating_rdo")[j].setAttribute("class", "rating_rdo");
		}
	}
}

let ratingElement = document.querySelectorAll(".rating_rdo");	//.rating_rdo가 들어간 체크박스 모두 선택
let ratingObject = new Rate(ratingElement);	//별점 컴포넌트 객체 생성