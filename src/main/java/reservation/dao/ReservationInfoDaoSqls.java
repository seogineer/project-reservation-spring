package reservation.dao;

public class ReservationInfoDaoSqls {
	public static final String SELECT_BY_RESERVATION_EMAIL = "SELECT A.cancel_flag, A.create_date createDate, A.display_info_id displayInfoId, A.modify_date modifyDate, A.product_id productId, A.reservation_date reservationDate, A.reservation_email, A.id reservationInfoId, A.reservation_name, A.reservation_tel, sum(C.count*(D.price-(D.price*(D.discount_rate/100)))) totalPrice, B.place_name, E.description, B.opening_hours \r\n"
			+ "FROM reservation_info A, display_info B, reservation_info_price C, product_price D, product E\r\n"
			+ "WHERE A.display_info_id = B.id\r\n"
			+ "AND A.id = C.reservation_info_id\r\n"
			+ "AND A.product_id = E.id\r\n"
			+ "AND C.product_price_id = D.id\r\n"
			+ "AND A.reservation_email like :resrvEmail\r\n"
			+ "GROUP BY A.id";
	
	public static final String SELECT_TOTAL_COUNT = "SELECT COUNT(*) \r\n"
			+ "FROM reservation_info A\r\n"
			+ "WHERE A.reservation_email like :resrvEmail";
	
	public static final String SELECT_VALID_COUNT = "SELECT COUNT(*) \r\n"
			+ "FROM reservation_info A\r\n"
			+ "WHERE A.reservation_email like :resrvEmail\r\n"
			+ "AND A.cancel_flag = 0";
	
	public static final String SELECT_INVALID_COUNT = "SELECT COUNT(*) \r\n"
			+ "FROM reservation_info A\r\n"
			+ "WHERE A.reservation_email like :resrvEmail\r\n"
			+ "AND A.cancel_flag = 2";
	
	public static final String SELECT_CANCEL_COUNT = "SELECT COUNT(*) \r\n"
			+ "FROM reservation_info A\r\n"
			+ "WHERE A.reservation_email like :resrvEmail\r\n"
			+ "AND A.cancel_flag = 1";
	
	public static final String UPDATE_BY_RESERVATION_INFO_ID = "UPDATE reservation_info SET cancel_flag = :cancelYn WHERE id = :reservationInfoId";
	
	public static final String SELECT_LAST_INFO = "SELECT MAX(id) FROM reservation_info";
}
