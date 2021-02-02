package reservation.service;

import java.util.List;

import reservation.dto.ProductPrice;

public interface ProductPriceService {
	public List<ProductPrice> select(int displayInfoId);
}
