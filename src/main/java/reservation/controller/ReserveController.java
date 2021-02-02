package reservation.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import reservation.dto.ProductPrice;
import reservation.dto.ReservationInfo;
import reservation.dto.ReservationInfoPrice;
import reservation.service.ProductPriceService;
import reservation.service.ReservationInfoPriceService;
import reservation.service.ReservationInfoService;

//예약 기능
@Controller
public class ReserveController {
	
	@Autowired
	ProductPriceService productPriceService;
	
	@Autowired
	ReservationInfoService reservationInfoService;
	
	@Autowired
	ReservationInfoPriceService reservationInfoPriceService;
	
	//예약버튼 클릭시 동작
	@PostMapping("/detail/reserve")
	public String reserve(@RequestParam Map<String, String> param, HttpSession session) {
		String loginEmail = (String) session.getAttribute("email");
		
		int productId = Integer.parseInt(param.get("productId"));	//productId
		int displayInfoId = Integer.parseInt(param.get("displayInfoId"));	//displayInfoId
		String name = param.get("name");	//예약자 name
		String tel = param.get("tel");	//예약자 tel
		String email = param.get("email");	//예약자 email
		
		ReservationInfo reservationInfo = new ReservationInfo();
		reservationInfo.setProductId(productId);
		reservationInfo.setDisplayInfoId(displayInfoId);
		reservationInfo.setReservationName(name);
		reservationInfo.setReservationTel(tel);
		reservationInfo.setReservationEmail(email);
		reservationInfo.setReservationDate(new Date());
		reservationInfo.setCancelFlag(0);
		reservationInfo.setCreateDate(new Date());
		reservationInfo.setModifyDate(new Date());
		
		reservationInfoService.insertReservation(reservationInfo);	//reservation_info 테이블에 INSERT 한다.
		
		int lastReservationInfoId = reservationInfoService.selectLastInfo();	//reservation_info 테이블에서 가장 최근에 INSERT한 데이터의 ReservationInfoId를 추출
		
		List<ProductPrice> productPriceList = productPriceService.select(productId);	//product_price 테이블에서 productId로 상품의 가격표를 가져온다.
		for(int i = 0; i < productPriceList.size(); i++) {
			int productPriceId = productPriceList.get(i).getProductPriceId();
			int count = Integer.parseInt(param.get(""+ productPriceId +""));	//productPriceId를 키값으로 예약 페이지에서 넘어온 표의 개수를 추출한다.
			
			ReservationInfoPrice reservationInfoPrice = new ReservationInfoPrice();
			reservationInfoPrice.setReservationInfoId(lastReservationInfoId);
			reservationInfoPrice.setProductPriceId(productPriceId);
			reservationInfoPrice.setCount(count);
			
			reservationInfoPriceService.insertReservationInfoPrice(reservationInfoPrice);	//reservation_info_price 테이블에 표의 개수를 INSERT한다.
		}
		
		return "redirect:/myreservation?email=" + loginEmail;	//예약 조회 화면으로 redirect
	}
}
