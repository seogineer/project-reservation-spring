package reservation.dao;

import static reservation.dao.CommentImageDaoSqls.SELECT_BY_COMMENT_ID;
import static reservation.dao.CommentImageDaoSqls.SELECT_BY_PRODUCT_ID;
import static reservation.dao.CommentImageDaoSqls.SELECT_LAST_FILE_INFO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import reservation.dto.CommentImage;
@Repository
public class CommentImageDao {
	private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<CommentImage> rowMapper = BeanPropertyRowMapper.newInstance(CommentImage.class);

    public CommentImageDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("reservation_user_comment_image").usingGeneratedKeyColumns("id");
    }
    
    public Long insert(CommentImage commentImage) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(commentImage);
		return insertAction.executeAndReturnKey(params).longValue();
	}
    
    public int selectLastFileInfo() {
    	Map<String, String> params = new HashMap<>();
		return jdbc.queryForObject(SELECT_LAST_FILE_INFO, params, Integer.class);
    }
    
    public List<CommentImage> selectByProductId(int productId) {
    	Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);
		return jdbc.query(SELECT_BY_PRODUCT_ID, params, rowMapper);
    }
    
    public CommentImage selectByCommentId(Integer commentId) {
    	Map<String, Integer> params = new HashMap<>();
		params.put("commentId", commentId);
        return  jdbc.queryForObject(SELECT_BY_COMMENT_ID, params, rowMapper);
    }
}
