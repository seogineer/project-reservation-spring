package reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reservation.dao.CommentDao;
import reservation.dto.Comment;
import reservation.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentDao commentDao;
	
	@Override
	@Transactional
	public List<Comment> selectAllByProductId(int productId) {
		List<Comment> list = commentDao.selectAllByProductId(productId);
		return list;
	}
	
	@Override
	@Transactional
	public List<Comment> selectByProductId(int productId) {
		List<Comment> list = commentDao.selectByProductId(productId);
		return list;
	}

	@Override
	@Transactional
	public int selectCount(int productId) {
		return commentDao.selectCount(productId);
	}

	@Override
	@Transactional
	public double selectAvgScore(int productId) {
		return commentDao.selectAvgScore(productId);
	}

	@Override
	@Transactional(readOnly=false)
	public Long insertComment(Comment comment) {
		return commentDao.insert(comment);
	}

	@Override
	@Transactional
	public int selectLastComment() {
		return commentDao.selectLastComment();
	}
	
}
