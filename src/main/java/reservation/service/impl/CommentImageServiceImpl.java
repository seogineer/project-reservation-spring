package reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reservation.dao.CommentImageDao;
import reservation.dto.CommentImage;
import reservation.service.CommentImageService;
@Service
public class CommentImageServiceImpl implements CommentImageService {

	@Autowired
	CommentImageDao commentImageDao;
	
	@Override
	@Transactional(readOnly=false)
	public Long insertCommentImage(CommentImage commentImage) {
		return commentImageDao.insert(commentImage);
	}

	@Override
	@Transactional
	public int selectLastFileInfo() {
		return commentImageDao.selectLastFileInfo();
	}

	@Override
	@Transactional
	public List<CommentImage> selectByProductId(int productId) {
		return commentImageDao.selectByProductId(productId);
	}

	@Override
	@Transactional
	public CommentImage selectByCommentId(int commentId) {
		return commentImageDao.selectByCommentId(commentId);
	}

}
