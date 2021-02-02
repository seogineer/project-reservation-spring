package reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reservation.dao.DisplayInfoDao;
import reservation.dto.DisplayInfo;
import reservation.service.DisplayInfoService;

@Service
public class DisplayInfoServiceImpl implements DisplayInfoService {
	
	@Autowired
	DisplayInfoDao displayInfoDao;
	
	@Override
	@Transactional
	public DisplayInfo selectByDisplayInfoId(int displayInfoId) {
		DisplayInfo displayInfo = displayInfoDao.selectByDisplayInfoId(displayInfoId);
		return displayInfo;
	}
	
}
