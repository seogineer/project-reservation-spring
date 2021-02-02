package reservation.dao;

public class DisplayInfoImageDaoSqls {
	public static final String SELECT_BY_DISPLAY_INFO_ID = "SELECT C.content_type contentType, C.create_date createDate, C.delete_flag deleteFlag, A.id displayInfoId, B.id displayInfoImageId, C.id fileId, C.file_name fileName, C.modify_date modifyDate, C.save_file_name saveFileName\r\n"
			+ "FROM display_info A, display_info_image B, file_info C\r\n"
			+ "WHERE A.id = B.display_info_id\r\n"
			+ "AND B.file_id = C.id\r\n"
			+ "AND A.id = :displayInfoId";
}
