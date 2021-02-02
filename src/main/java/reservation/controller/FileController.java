package reservation.controller;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import reservation.dto.CommentImage;
import reservation.service.CommentImageService;

@Controller
public class FileController {
	
	@Autowired CommentImageService commentImageService;
	
	@GetMapping("/detail/download")
	public void download(@RequestParam(name = "commentId", required = true) int commentId, HttpServletResponse response) {
		
		// commentId로 commentImage 조회
		CommentImage commentImage = commentImageService.selectByCommentId(commentId);
		
		// 직접 파일 정보를 변수에 저장해 놨지만, 이 부분이 db에서 읽어왔다고 가정한다.
		String fileName = commentImage.getFileName();
		String saveFileName = "c:/" + commentImage.getSaveFileName(); // 맥일 경우 "/tmp/connect.png" 로 수정
		String contentType = commentImage.getContentType();
		int fileLength = commentImage.getFileSize();

		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Content-Type", contentType);
		response.setHeader("Content-Length", "" + fileLength);
		response.setHeader("Pragma", "no-cache;");
		response.setHeader("Expires", "-1;");

		try (FileInputStream fis = new FileInputStream(saveFileName);
				OutputStream out = response.getOutputStream();) {
			int readCount = 0;
			byte[] buffer = new byte[1024];
			while ((readCount = fis.read(buffer)) != -1) {
				out.write(buffer, 0, readCount);
			}
		} catch (Exception ex) {
			throw new RuntimeException("file Save Error");
		}
	}
}
