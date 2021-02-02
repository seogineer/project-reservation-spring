package reservation.service;

import java.util.List;

import reservation.dto.Product;

public interface ProductService {
	public static final Integer LIMIT = 4;
	public List<Product> select(int categoryId, int start);
	public int selectCount();
	public int selectCountByCategoryId(int categoryId);
	public Product selectByProductId(int productId);
}
