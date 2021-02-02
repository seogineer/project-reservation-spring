package reservation.dao;

public class DisplayInfoDaoSqls {
	public static final String SELECT_BY_DISPLAY_INFO_ID = "SELECT P.id productId, C.id categoryId, I.id displayInfoId, C.name categoryName, P.description productDescription, P.content productContent, P.event productEvent, I.opening_hours, I.place_name placeName, I.place_lot placeLot, I.place_street placeStreet, I.tel telephone, I.homepage, I.email, P.create_date createDate, P.modify_date modifyDate\r\n"
			+ "FROM product P, display_info I, category C\r\n"
			+ "WHERE I.id = :displayInfoId\r\n"
			+ "AND P.id = I.product_id\r\n"
			+ "AND P.category_id = C.id";
}
