package reservation.service;

import java.util.List;

import reservation.dto.Comment;

public interface CommentService {
	public List<Comment> selectAllByProductId(int productId);
	public List<Comment> selectByProductId(int productId);
	public int selectCount(int productId);
	public double selectAvgScore(int productId);
	public Long insertComment(Comment comment);
	public int selectLastComment();
}
