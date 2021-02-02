package reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reservation.dto.ProductImage;
import reservation.service.ProductImageService;

@RestController
@RequestMapping(path="/detail/etcImgChk")
public class DetailApiController {
	
	@Autowired
	ProductImageService productImageService;
	
	@GetMapping("/{displayInfoId}")
	public Map<String, Object> load(@PathVariable(name = "displayInfoId", required=true) int displayInfoId) {
		
		List<ProductImage> productEtcImageList = productImageService.selectEtcImageByDisplayInfoId(displayInfoId);
		
		Map<String, Object> map = new HashMap<>();
		map.put("productEtcImageList", productEtcImageList);
		return map;
	}
}
