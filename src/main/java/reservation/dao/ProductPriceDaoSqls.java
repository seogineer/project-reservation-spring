package reservation.dao;

public class ProductPriceDaoSqls {
	public static final String SELECT = "SELECT B.id product_price_id, B.product_id, B.price_type_name, B.price, B.discount_rate, B.create_date, B.modify_date\r\n"
			+ "FROM product_price B\r\n"
			+ "WHERE B.product_id = :productId\r\n"
			+ ";";
}
