package reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reservation.dao.FileInfoDao;
import reservation.dto.CommentImage;
import reservation.service.FileInfoService;
@Service
public class FileInfoServiceImpl implements FileInfoService {
	
	@Autowired
	FileInfoDao fileInfoDao;
	
	@Override
	@Transactional(readOnly=false)
	public Long insertFileInfo(CommentImage commentImage) {
		return fileInfoDao.insert(commentImage);
	}
	
}
