package reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reservation.dao.ProductImageDao;
import reservation.dto.ProductImage;
import reservation.service.ProductImageService;

@Service
public class ProductImageServiceImpl implements ProductImageService {

	@Autowired
	ProductImageDao productImageDao;
	
	@Override
	@Transactional
	public List<ProductImage> selectByDisplayInfoId(int displayInfoId) {
		return productImageDao.selectByDisplayInfoId(displayInfoId);
	}

	@Override
	@Transactional
	public List<ProductImage> selectEtcImageByDisplayInfoId(int displayInfoId) {
		return productImageDao.selectEtcImageByDisplayInfoId(displayInfoId);
	}

}
