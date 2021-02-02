package reservation.dao;

public class CategoryDaoSqls {
	public static final String SELECT = "SELECT COUNT(*) count, category.id id, category.name name FROM category, product WHERE category.id = product.category_id GROUP BY category_id";
}
