package reservation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import reservation.dto.Category;
import reservation.dto.Product;
import reservation.dto.Promotion;
import reservation.service.CategoryService;
import reservation.service.ProductService;
import reservation.service.PromotionService;

@Controller
public class MainController {
	
	@Autowired
	PromotionService promotionService;
	
	@Autowired
	CategoryService categoryServise;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/")
	public String load(
		@RequestParam(name = "categoryId", required = false, defaultValue = "0") int categoryId,
		@RequestParam(name = "start", required = false, defaultValue = "0") int start,
		ModelMap modelMap
	) {
		List<Promotion> promotionList = promotionService.select();
		List<Category> categoryList = categoryServise.select();
		List<Product> productList = productService.select(categoryId, start);
		
		int count;
		if(categoryId > 0) {
			count = productService.selectCountByCategoryId(categoryId);
		} else {
			count = productService.selectCount();
		}
		
		modelMap.addAttribute("promotionList", promotionList);
		modelMap.addAttribute("categoryList", categoryList);
		modelMap.addAttribute("productList", productList);
		modelMap.addAttribute("count", count);
		
		return "main";
	}
}
