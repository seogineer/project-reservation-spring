package reservation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import reservation.dto.ReservationInfo;
import reservation.service.ReservationInfoService;

//로그인 화면
@Controller
public class BookingLoginController {
	
	@Autowired
	ReservationInfoService reservationInfoService;
	
	//로그인 화면 load
	@GetMapping("/bookinglogin")
	public String load() {
		return "bookinglogin";
	}
	
	// 로그인 동작
	@PostMapping("/myreservation")
	public String list(@RequestParam(name="resrv_email", required=true) String resrvEmail,
			HttpSession session, ModelMap modelMap){
		
		List<ReservationInfo> list = reservationInfoService.selectByReservationEmail(resrvEmail);
		
		if(list != null) {	//email로 예약 정보를 조회한 다음 예약 정보가 존재할 경우 로그인 후 메인 화면으로 redirect
			session.setAttribute("isLogin", true);
			session.setAttribute("email", resrvEmail);
			return "redirect:/";
			//return "redirect:myreservation?email=" + resrvEmail;
		} else {	//email이 존재하지 않는 경우
			modelMap.addAttribute("result", "존재하지 않는 이메일입니다.");
			return "bookinglogin";
		}
		
	}
}
