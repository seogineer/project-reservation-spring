package reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reservation.dao.ReservationInfoDao;
import reservation.dto.ReservationInfo;
import reservation.service.ReservationInfoService;

@Service
public class ReservationInfoServiceImpl implements ReservationInfoService {
	
	@Autowired
	ReservationInfoDao reservationInfoDao;
	
	@Override
	@Transactional
	public List<ReservationInfo> selectByReservationEmail(String resrvEmail) {
		List<ReservationInfo> list = reservationInfoDao.selectByReservationEmail(resrvEmail);
		return list;
	}

	@Override
	@Transactional
	public int selectTotalCount(String resrvEmail) {
		return reservationInfoDao.selectTotalCount(resrvEmail);
	}

	@Override
	@Transactional
	public int selectValidCount(String resrvEmail) {
		return reservationInfoDao.selectValidCount(resrvEmail);
	}

	@Override
	@Transactional
	public int selectInvalidCount(String resrvEmail) {
		return reservationInfoDao.selectInvalidCount(resrvEmail);
	}

	@Override
	@Transactional
	public int selectCancelCount(String resrvEmail) {
		return reservationInfoDao.selectCancelCount(resrvEmail);
	}

	@Override
	@Transactional(readOnly=false)
	public int updateByReservationInfoId(int reservationInfoId, int cancelYn) {
		int updateCount = reservationInfoDao.updateByReservationInfoId(reservationInfoId, cancelYn);
		return updateCount;
	}

	@Override
	@Transactional(readOnly=false)
	public Long insertReservation(ReservationInfo reservationInfo) {
		return reservationInfoDao.insert(reservationInfo);
	}

	@Override
	@Transactional
	public int selectLastInfo() {
		return reservationInfoDao.selectLastInfo();
	}
	
	

}
