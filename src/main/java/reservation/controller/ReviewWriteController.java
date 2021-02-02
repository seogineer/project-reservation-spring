package reservation.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import reservation.dto.Comment;
import reservation.dto.CommentImage;
import reservation.service.CommentImageService;
import reservation.service.CommentService;
import reservation.service.FileInfoService;
@Controller
public class ReviewWriteController {
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	CommentImageService commentImageService;
	
	@Autowired
	FileInfoService fileInfoService;
	
	//리뷰 등록 버튼 클릭 처리
	@PostMapping("/myreservation/upload")
	public String upload(
			@RequestParam Map<String, String> param, 
			@RequestParam("imageFile") MultipartFile file, 
			HttpSession session, ModelMap modelMap
	) {
		int reservationInfoId = Integer.parseInt(param.get("reservationInfoId"));
		int productId = Integer.parseInt(param.get("productId"));
		int rating = Integer.parseInt(param.get("rating"));
		String reviewTextarea = param.get("reviewTextarea");
		
		Comment comment = new Comment();
		comment.setProductId(productId);
		comment.setReservationInfoId(reservationInfoId);
		comment.setScore(rating);
		comment.setComment(reviewTextarea);
		comment.setCreateDate(new Date());
		comment.setModifyDate(new Date());
		
		commentService.insertComment(comment);	//reservation_user_comment 테이블에 INSERT
		
		int lastCommentId = commentService.selectLastComment();	// 바로 위에서 INSERT한 reservation_user_comment 데이터의 id값을 가져온다.
		
		//첨부한 사진이 있는 경우 file_info 테이블에 INSERT
		if(!file.isEmpty()) {
			SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMddHHmmss");
			Date time = new Date();
			String now = format1.format(time);
			
			CommentImage commentImage = new CommentImage();
			commentImage.setFileName(file.getOriginalFilename() + now);
			commentImage.setSaveFileName("uploadImage/" + file.getOriginalFilename() + now);
			commentImage.setContentType("image/" + file.getOriginalFilename().substring(file.getOriginalFilename().length()-3, file.getOriginalFilename().length()));
			commentImage.setDeleteFlag(0);
			commentImage.setCreateDate(new Date());
			commentImage.setModifyDate(new Date());
			commentImage.setFileSize((int) file.getSize());
			
			fileInfoService.insertFileInfo(commentImage);	//file_info 테이블에 INSERT
			
			int lastFileId = commentImageService.selectLastFileInfo();	//바로 위에서 INSERT한 file_info 데이터의 id값을 가져온다.
			
			//reservation_user_comment에 INSERT한 데이터의 id값과 file_info의 id값을 가져와서
			commentImage.setReservationInfoId(reservationInfoId);
			commentImage.setReservationUserCommentId(lastCommentId);
			commentImage.setFileId(lastFileId);
			
			//reservation_user_comment_image에 INSERT
			commentImageService.insertCommentImage(commentImage);
			
			// 파일 업로드
			try (FileOutputStream fos = new FileOutputStream("c:/uploadImage/" + file.getOriginalFilename() + now);
					InputStream is = file.getInputStream();) {
				int readCount = 0;
				byte[] buffer = new byte[1024];
				while ((readCount = is.read(buffer)) != -1) {
					fos.write(buffer, 0, readCount);
				}
			} catch (Exception ex) {
				throw new RuntimeException("file Save Error");
			}
			
		}
		
		String email = (String) session.getAttribute("email");
		
		return "redirect:../myreservation?email=" + email;
	}
}
