package reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import reservation.dto.Product;
import reservation.dto.ReservationInfo;
import reservation.service.ProductService;
import reservation.service.ReservationInfoService;

@Controller
public class ReservationInfoController {
	
	@Autowired
	ReservationInfoService reservationInfoService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/myreservation")
	public String list(@RequestParam(name = "email", required = true) String email, ModelMap modelMap) {
		
		int totalCount = reservationInfoService.selectTotalCount(email);
		int validCount = reservationInfoService.selectValidCount(email);
		int invalidCount = reservationInfoService.selectInvalidCount(email);
		int cancelCount = reservationInfoService.selectCancelCount(email);
		List<ReservationInfo> list = reservationInfoService.selectByReservationEmail(email);
		
		modelMap.addAttribute("totalCount", totalCount);
		modelMap.addAttribute("validCount", validCount);
		modelMap.addAttribute("invalidCount", invalidCount);
		modelMap.addAttribute("cancelCount", cancelCount);
		modelMap.addAttribute("reservationList", list);
		
		return "myreservation";
	}
	
	// 내 예약 목록에서 버튼 동작 처리
	@GetMapping("/myreservation/{reservationInfoId}")
	public String complete(
			@PathVariable(name = "reservationInfoId", required = true) int reservationInfoId,
			@RequestParam(name = "cancelYn", required = true) int cancelYn,
			@RequestParam(name = "email", required = true) String email,
			@RequestParam(name = "productId", required = true) int productId,
			ModelMap modelMap) {
		
		if(cancelYn == 1) {	//취소 버튼 처리
			reservationInfoService.updateByReservationInfoId(reservationInfoId, cancelYn);
			return "redirect:/myreservation?email=" + email;			
		} else {	// 이용 완료 및 리뷰 남기기 버튼 처리
			reservationInfoService.updateByReservationInfoId(reservationInfoId, cancelYn);
			Product product = productService.selectByProductId(productId);
			
			modelMap.addAttribute("product", product);
			modelMap.addAttribute("reservationInfoId", reservationInfoId);
			modelMap.addAttribute("productId", productId);
			
			return "reviewWrite";
		}
	}
}
