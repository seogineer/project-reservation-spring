package reservation.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import reservation.dto.Comment;
import reservation.dto.CommentImage;
import reservation.dto.DisplayInfo;
import reservation.dto.DisplayInfoImage;
import reservation.dto.ProductImage;
import reservation.dto.ProductPrice;
import reservation.service.CommentImageService;
import reservation.service.CommentService;
import reservation.service.DisplayInfoImageService;
import reservation.service.DisplayInfoService;
import reservation.service.ProductImageService;
import reservation.service.ProductPriceService;

@Controller
public class DetailController {
	
	@Autowired ProductImageService productImageService;
	
	@Autowired DisplayInfoService displayInfoService;
	
	@Autowired DisplayInfoImageService displayInfoImageService;
	
	@Autowired CommentService commentService;
	
	@Autowired ProductPriceService productPriceService;
	
	@Autowired CommentImageService commentImageService;
	
	@RequestMapping("/detail/{displayInfoId}")
	public String load(
			@PathVariable(name = "displayInfoId", required = true) int displayInfoId, 
			@RequestParam(name = "productId", required = true) int productId,
			ModelMap modelMap
	) {
		List<ProductImage> productImageList = productImageService.selectByDisplayInfoId(displayInfoId);
		DisplayInfo displayInfo = displayInfoService.selectByDisplayInfoId(displayInfoId);
		DisplayInfoImage displayInfoImage = displayInfoImageService.selectByDisplayInfoId(displayInfoId);
		List<Comment> commentList = commentService.selectByProductId(productId);
		List<CommentImage> commentImageList = commentImageService.selectByProductId(productId);
		int commentTotalCount = commentService.selectCount(displayInfoId);
		double commentAvgScore = commentService.selectAvgScore(displayInfoId);
		
		modelMap.addAttribute("productImageList", productImageList);
		modelMap.addAttribute("displayInfo", displayInfo);
		modelMap.addAttribute("displayInfoImage", displayInfoImage);
		modelMap.addAttribute("commentList", commentList);
		modelMap.addAttribute("commentTotalCount", commentTotalCount);
		modelMap.addAttribute("commentAvgScore", commentAvgScore);
		modelMap.addAttribute("commentImageList", commentImageList);
		
		return "detail";
	}
	
	@RequestMapping("/detail/reserve/{displayInfoId}")
	public String reserveLoad(@PathVariable(name = "displayInfoId", required = true) int displayInfoId, ModelMap modelMap, HttpSession session) {
		
		//if(session.getAttribute("isLogin") != null) {	//로그인이 되어있는 경우 예약 화면 호출
			List<ProductImage> productImageList = productImageService.selectByDisplayInfoId(displayInfoId);
			DisplayInfo displayInfo = displayInfoService.selectByDisplayInfoId(displayInfoId);
			List<ProductPrice> productPriceList = productPriceService.select(displayInfoId);
			
			modelMap.addAttribute("productImageList", productImageList);
			modelMap.addAttribute("displayInfo", displayInfo);
			modelMap.addAttribute("productPriceList", productPriceList);
			modelMap.addAttribute("randomDate", randomDate());	//전시 날짜는 임의의 날짜
			
			return "reserve";
		//} else {	//로그인이 안 되어있는 경우 로그인 화면 호출
			//return "redirect:../../bookinglogin";
		//}
		
	}
	
	// 현재 날짜에서 1~5일 사이의 임의 날짜
	public String randomDate() {
		Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        cal.add(Calendar.DATE, (int)(Math.random() * 5) + 1);
        String randomDate = df.format(cal.getTime());
        return randomDate;
	}
}
