package reservation.dao;

public class CommentImageDaoSqls {
	public static final String SELECT_LAST_FILE_INFO = "SELECT MAX(id) FROM file_info";
	
	public static final String SELECT_BY_PRODUCT_ID = "SELECT A.content_type contentType, A.create_date createDate, A.delete_flag deleteFlag, A.id fileId, A.file_name fileName, B.id imageId, A.modify_date, B.reservation_info_id, B.reservation_user_comment_id, A.save_file_name\r\n"
			+ "FROM file_info A, reservation_user_comment_image B, reservation_user_comment C\r\n"
			+ "WHERE A.id = B.file_id\r\n"
			+ "AND B.reservation_info_id = C.reservation_info_id\r\n"
			+ "AND C.product_id = :productId";
	
	public static final String SELECT_BY_COMMENT_ID = "SELECT A.content_type contentType, A.create_date createDate, A.delete_flag deleteFlag, A.id fileId, A.file_name fileName, B.id imageId, A.modify_date, B.reservation_info_id, B.reservation_user_comment_id, A.save_file_name, A.file_size\r\n"
			+ "FROM file_info A, reservation_user_comment_image B, reservation_user_comment C\r\n"
			+ "WHERE A.id = B.file_id\r\n"
			+ "AND B.reservation_user_comment_id = C.id\r\n"
			+ "AND C.id = :commentId";
}
