function init() {
	bkMore();
	nvBtn();
	tabBtn();
}

//Etc Image Load
function loadEtcImage(etcImage) {

	if (etcImage.length > 0) {
		$(".pagination").show();
		$(".prev").show();
		$(".nxt").show();

		let etcImageItemHtml = document.querySelector("#productEtcImageItem").innerHTML;
		let item = "";
		item += etcImageItemHtml.replace("{saveFileName}", etcImage[0].saveFileName);

		document.querySelector(".visual_img").innerHTML += item;
	} else {
		$(".pagination").hide();
		$(".prev").hide();
		$(".nxt").hide();
	}
}

//Etc Image Request
function etcImageChk(displayInfoId) {
	var xhr = new XMLHttpRequest();
	xhr.onload = function() {
		if (xhr.status == "200") {
			let json = JSON.parse(xhr.responseText);
			loadEtcImage(json.productEtcImageList);
		}
	}

	xhr.open("GET", "etcImgChk/" + displayInfoId);
	xhr.send();
}

//상세정보/오시는길 탭
function tabBtn() {
	$("._detail").click(function() {
		$("._detail").removeClass().addClass("item active _detail");
		$("._path").removeClass().addClass("item _path");

		$("._detail").children().removeClass().addClass("anchor active");
		$("._path").children().removeClass().addClass("anchor");

		$(".detail_area_wrap").removeClass().addClass("detail_area_wrap");
		$(".detail_location").removeClass().addClass("detail_location hide");
	})

	$("._path").click(function() {
		$("._path").removeClass().addClass("item active _path");
		$("._detail").removeClass().addClass("item _detail");

		$("._path").children().removeClass().addClass("anchor active");
		$("._detail").children().removeClass().addClass("anchor");

		$(".detail_area_wrap").removeClass().addClass("detail_area_wrap hide");
		$(".detail_location").removeClass().addClass("detail_location");
	})
}

//navi 버튼
function nvBtn() {
	if (document.querySelector(".nxt_inn") != null) {
		document.querySelector(".nxt_inn").addEventListener("click", () => {
			let slideWrapper = document.querySelector(".container_visual");
			let sliderWidth = slideWrapper.clientWidth;	//414px

			let slider = document.querySelector(".visual_img");
			slider.style.left = -(sliderWidth) + 'px';

			let nvIndex = document.querySelector(".nvIndex");
			nvIndex.innerText = 2;
		});

		document.querySelector(".prev_inn").addEventListener("click", () => {
			let slider = document.querySelector(".visual_img");
			slider.style.left = 0 + 'px';

			let nvIndex = document.querySelector(".nvIndex");
			nvIndex.innerHTML = 1;
		});
	}
}

//펼쳐보기
function bkMore() {
	$(".bk_more").click(function() {
		if ($("._open").is(":visible")) {
			$("._open").css("display", "none");
			$("._close").css("display", "block");
			$(".store_details").removeClass().addClass("store_details");
		} else {
			$("._open").css("display", "block");
			$("._close").css("display", "none");
			$(".store_details").removeClass().addClass("store_details close3");
		}
	})
}

// Load
document.addEventListener("DOMContentLoaded", () => {
	init();
});


function pop(img) {
	var win = window.open('', 'Detail', 'width=0, height=0, menubar=0, toolbar=0, directories=0, scrollbars=1, status=0, location=0, resizable=1');
	op = "<html><head><title>크게 보기</title></head>";
	op += "<body leftmargin='0' topmargin='0'>";
	op += "<img src='" + img.src + "' border='0' style='cursor:pointer' onclick='window.close();' onload='window.resizeTo(this.width+30, this.height+90); window.moveTo( (screen.width-this.width)/2 ,  (screen.height-this.height)/2-50 )'>";
	op += "</body></html>";

	win.document.write(op);
}