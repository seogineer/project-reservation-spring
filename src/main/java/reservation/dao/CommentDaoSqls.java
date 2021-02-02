package reservation.dao;

public class CommentDaoSqls {
	public static final String SELECT_ALL_BY_PRODUCT_ID = "SELECT A.comment, A.id commentId, A.create_date createDate, A.modify_date modifyDate, B.product_id productId, B.reservation_date reservationDate, B.reservation_email reservationEmail, A.reservation_info_id reservationInfoId, B.reservation_name reservationName, B.reservation_tel reservationTelephone, A.score\r\n"
			+ "FROM reservation_user_comment A, reservation_info B\r\n"
			+ "WHERE A.reservation_info_id = B.id\r\n"
			+ "AND A.product_id = :productId";
	
	public static final String SELECT_BY_PRODUCT_ID_LIMIT = "SELECT A.comment, A.id commentId, A.create_date createDate, A.modify_date modifyDate, B.product_id productId, B.reservation_date reservationDate, B.reservation_email reservationEmail, A.reservation_info_id reservationInfoId, B.reservation_name reservationName, B.reservation_tel reservationTelephone, A.score\r\n"
			+ "FROM reservation_user_comment A, reservation_info B\r\n"
			+ "WHERE A.reservation_info_id = B.id\r\n"
			+ "AND A.product_id = :productId\r\n"
			+ "LIMIT 0, 3";
	
	public static final String SELECT_COUNT = "SELECT COUNT(*) totalCount\r\n"
			+ "FROM reservation_user_comment A, reservation_info B\r\n"
			+ "WHERE A.reservation_info_id = B.id\r\n"
			+ "AND A.product_id = :productId";
	
	public static final String SELECT_AVG_SCORE = "SELECT AVG(A.score) averageScore\r\n"
			+ "FROM reservation_user_comment A, reservation_info B\r\n"
			+ "WHERE A.reservation_info_id = B.id\r\n"
			+ "AND A.product_id = :productId";
	
	public static final String SELECT_LAST_COMMENT = "SELECT MAX(id) FROM reservation_user_comment";
}
