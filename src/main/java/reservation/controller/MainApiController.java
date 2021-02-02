package reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reservation.dto.Product;
import reservation.service.CategoryService;
import reservation.service.ProductService;
import reservation.service.PromotionService;

@RestController
@RequestMapping(path="/main")
public class MainApiController {
	@Autowired
	PromotionService promotionService;
	
	@Autowired
	CategoryService categoryServise;
	
	@Autowired
	ProductService productService;
	
	@GetMapping
	public Map<String, Object> load(
		@RequestParam(name="categoryId", required=false, defaultValue="0") int categoryId,
		@RequestParam(name="start", required=false, defaultValue="0") int start
	) {
		List<Product> productList = productService.select(categoryId, start);
		
		int count;
		if(categoryId > 0) {
			count = productService.selectCountByCategoryId(categoryId);
		} else {
			count = productService.selectCount();
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("count", count);
		map.put("productList", productList);
		
		return map;
	}
}
