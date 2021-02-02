package reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import reservation.dto.Comment;
import reservation.dto.CommentImage;
import reservation.dto.DisplayInfo;
import reservation.service.CommentImageService;
import reservation.service.CommentService;
import reservation.service.DisplayInfoService;
@Controller
public class ReviewController {
	
	@Autowired DisplayInfoService displayInfoService;
	
	@Autowired CommentService commentService;
	
	@Autowired CommentImageService commentImageService;
	
	@RequestMapping("/review/{displayInfoId}")
	public String load(
		@PathVariable(name = "displayInfoId", required = true) int displayInfoId, 
		@RequestParam(name = "productId", required = true) int productId,
		ModelMap modelMap
	) {
		DisplayInfo displayInfo = displayInfoService.selectByDisplayInfoId(displayInfoId);
		List<Comment> commentList = commentService.selectAllByProductId(displayInfoId);
		int commentTotalCount = commentService.selectCount(displayInfoId);
		double commentAvgScore = commentService.selectAvgScore(displayInfoId);
		List<CommentImage> commentImageList = commentImageService.selectByProductId(productId);
		
		modelMap.addAttribute("displayInfo", displayInfo);
		modelMap.addAttribute("commentList", commentList);
		modelMap.addAttribute("commentTotalCount", commentTotalCount);
		modelMap.addAttribute("commentAvgScore", commentAvgScore);
		modelMap.addAttribute("commentImageList", commentImageList);
		
		return "review";
	}
}
