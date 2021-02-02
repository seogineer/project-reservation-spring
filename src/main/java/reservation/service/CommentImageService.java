package reservation.service;

import java.util.List;

import reservation.dto.CommentImage;

public interface CommentImageService {
	public Long insertCommentImage(CommentImage commentImage);
	public int selectLastFileInfo();
	public List<CommentImage> selectByProductId(int productId);
	public CommentImage selectByCommentId(int commentId);
}
