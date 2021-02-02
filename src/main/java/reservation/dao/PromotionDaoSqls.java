package reservation.dao;

public class PromotionDaoSqls {
	public static final String SELECT = "SELECT P.id, P.product_id, CONCAT(I.product_id, \"_th_\", I.id, \".png\") productImageUrl\r\n"
			+ "FROM product_image I, promotion P\r\n"
			+ "WHERE 1=1\r\n"
			+ "AND P.product_id = I.product_id\r\n"
			+ "AND I.type like 'th'\r\n"
			+ ";";
}
