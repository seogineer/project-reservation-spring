package reservation.service;

import java.util.List;

import reservation.dto.ReservationInfo;

public interface ReservationInfoService {
	public List<ReservationInfo> selectByReservationEmail(String resrvEmail);
	public int selectTotalCount(String resrvEmail);
	public int selectValidCount(String resrvEmail);
	public int selectInvalidCount(String resrvEmail);
	public int selectCancelCount(String resrvEmail);
	public int updateByReservationInfoId(int reservationInfoId, int cancelYn);
	public Long insertReservation(ReservationInfo reservationInfo);
	public int selectLastInfo();
}
