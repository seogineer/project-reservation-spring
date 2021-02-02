package reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reservation.dao.ProductDao;
import reservation.dto.Product;
import reservation.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	
	@Override
	@Transactional
	public int selectCount() {
		return productDao.selectCount();
	}

	@Override
	@Transactional
	public List<Product> select(int categoryId, int start) {
		List<Product> list = productDao.select(categoryId, start, ProductService.LIMIT);
		return list;
	}

	@Override
	@Transactional
	public int selectCountByCategoryId(int categoryId) {
		return productDao.selectCountByCategoryId(categoryId);
	}

	@Override
	@Transactional
	public Product selectByProductId(int productId) {
		Product product = productDao.selectByProductId(productId);
		return product;
	}
	
}
