package reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import reservation.dto.Comment;
import reservation.dto.DisplayInfo;
import reservation.service.CommentService;
import reservation.service.DisplayInfoService;
@Controller
public class ReviewController {
	
	@Autowired
	DisplayInfoService displayInfoService;
	
	@Autowired
	CommentService commentService;
	
	@RequestMapping("/review/{displayInfoId}")
	public String load(@PathVariable(name = "displayInfoId", required = true) int displayInfoId, ModelMap modelMap) {
		System.out.println("Review page load");
		DisplayInfo displayInfo = displayInfoService.selectByDisplayInfoId(displayInfoId);
		List<Comment> commentList = commentService.selectAllByProductId(displayInfoId);
		int commentTotalCount = commentService.selectCount(displayInfoId);
		double commentAvgScore = commentService.selectAvgScore(displayInfoId);
		
		modelMap.addAttribute("displayInfo", displayInfo);
		modelMap.addAttribute("commentList", commentList);
		modelMap.addAttribute("commentTotalCount", commentTotalCount);
		modelMap.addAttribute("commentAvgScore", commentAvgScore);
		return "review";
	}
}
