package reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reservation.dao.PromotionDao;
import reservation.dto.Promotion;
import reservation.service.PromotionService;
@Service
public class PromotionServiceImpl implements PromotionService {
	
	@Autowired
	PromotionDao promotionDao;
	
	@Override
	@Transactional
	public List<Promotion> select() {
		List<Promotion> list = promotionDao.select();
		return list;
	}
	
}
