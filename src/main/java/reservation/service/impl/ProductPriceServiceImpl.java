package reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reservation.dao.ProductPriceDao;
import reservation.dto.ProductPrice;
import reservation.service.ProductPriceService;
@Service
public class ProductPriceServiceImpl implements ProductPriceService {

	@Autowired
	ProductPriceDao productPriceDao;
	
	@Override
	@Transactional
	public List<ProductPrice> select(int productId) {
		List<ProductPrice> list = productPriceDao.select(productId);
		return list;
	}

}
