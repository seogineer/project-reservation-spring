package reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reservation.dao.DisplayInfoImageDao;
import reservation.dto.DisplayInfoImage;
import reservation.service.DisplayInfoImageService;

@Service
public class DisplayInfoImageServiceImpl implements DisplayInfoImageService {

	@Autowired
	DisplayInfoImageDao displayInfoImageDao;
	
	@Override
	@Transactional
	public DisplayInfoImage selectByDisplayInfoId(int displayInfoId) {
		DisplayInfoImage displayInfoImage = displayInfoImageDao.selectByDisplayInfoId(displayInfoId);
		return displayInfoImage;
	}

}
