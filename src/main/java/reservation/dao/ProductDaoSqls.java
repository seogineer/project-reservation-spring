package reservation.dao;

public class ProductDaoSqls {
	public static final String SELECT_COUNT = "SELECT COUNT(*) FROM product P, display_info D, product_image I WHERE P.id = D.product_id AND D.product_id = I.product_id AND I.type LIKE 'th'";
	
	public static final String SELECT_COUNT_BY_CATEGORY_ID = "SELECT COUNT(*) FROM product P, display_info D, product_image I WHERE P.id = D.product_id AND D.product_id = I.product_id AND I.type LIKE 'th' AND P.category_id = :categoryId";
	
	public static final String SELECT = "SELECT D.id displayInfoId, P.id productId, CONCAT(I.product_id, \"_th_\", I.id, \".png\") productImageUrl, P.description productDescription, P.content productContent, D.place_name placeName\r\n"
			+ "FROM product P, display_info D, product_image I\r\n"
			+ "WHERE P.id = D.product_id\r\n"
			+ "AND D.product_id = I.product_id\r\n"
			+ "AND I.type LIKE 'th'"
			+ "LIMIT :start, :limit";
	public static final String SELECT_BY_CATEGORY_ID = "SELECT D.id displayInfoId, P.id productId, CONCAT(I.product_id, \"_th_\", I.id, \".png\") productImageUrl, P.description productDescription, P.content productContent, D.place_name placeName\r\n"
			+ "FROM product P, display_info D, product_image I\r\n"
			+ "WHERE P.id = D.product_id\r\n"
			+ "AND D.product_id = I.product_id\r\n"
			+ "AND I.type LIKE 'th'\r\n"
			+ "AND P.category_id = :categoryId\r\n"
			+ "LIMIT :start, :limit";
	
	public static final String SELECT_BY_PRODUCT_ID = "SELECT D.id displayInfoId, P.id productId, P.description productDescription, P.content productContent, D.place_name placeName\r\n"
			+ "FROM product P, display_info D\r\n"
			+ "WHERE P.id = D.product_id\r\n"
			+ "AND P.id = :productId\r\n"
			+ ";";
}
