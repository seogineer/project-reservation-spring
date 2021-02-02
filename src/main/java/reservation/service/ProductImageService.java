package reservation.service;

import java.util.List;

import reservation.dto.ProductImage;

public interface ProductImageService {
	public List<ProductImage> selectByDisplayInfoId(int displayInfoId);
	public List<ProductImage> selectEtcImageByDisplayInfoId(int displayInfoId);
}
