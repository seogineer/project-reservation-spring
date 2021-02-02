package reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reservation.dao.ReservationInfoPriceDao;
import reservation.dto.ReservationInfoPrice;
import reservation.service.ReservationInfoPriceService;

@Service
public class ReservationInfoPriceServiceImpl implements ReservationInfoPriceService {
	
	@Autowired
	ReservationInfoPriceDao reservationInfoPriceDao;
	
	@Override
	@Transactional(readOnly=false)
	public Long insertReservationInfoPrice(ReservationInfoPrice reservationInfoPrice) {
		return reservationInfoPriceDao.insert(reservationInfoPrice);
	}
}
