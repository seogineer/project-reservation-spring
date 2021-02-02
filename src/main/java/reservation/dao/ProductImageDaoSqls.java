package reservation.dao;

public class ProductImageDaoSqls {
	public static final String SELECT_BY_DISPLAY_INFO_ID = "SELECT C.content_type contentType, A.create_date createDate, C.delete_flag deleteFlag, B.file_id fileInfoId, C.file_name fileName, A.modify_date modifyDate, A.id productId, B.id productImageId, C.save_file_name saveFileName, B.`type`\r\n"
			+ "FROM product A, product_image B, file_info C, display_info D\r\n"
			+ "WHERE A.id = B.product_id\r\n"
			+ "AND B.file_id = C.id\r\n"
			+ "AND A.id = D.product_id\r\n"
			+ "AND B.`type` = 'ma'\r\n"
			+ "AND D.id = :displayInfoId\r\n"
			+ "LIMIT 0, 1";
	
	public static final String SELECT_ETC_IMAGE_BY_DISPLAY_INFO_ID = "SELECT C.content_type contentType, A.create_date createDate, C.delete_flag deleteFlag, B.file_id fileInfoId, C.file_name fileName, A.modify_date modifyDate, A.id productId, B.id productImageId, C.save_file_name saveFileName, B.`type`\r\n"
			+ "FROM product A, product_image B, file_info C, display_info D\r\n"
			+ "WHERE A.id = B.product_id\r\n"
			+ "AND B.file_id = C.id\r\n"
			+ "AND A.id = D.product_id\r\n"
			+ "AND B.`type` = 'et'\r\n"
			+ "AND D.id = :displayInfoId\r\n"
			+ "LIMIT 0, 1";
}
