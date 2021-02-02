package reservation.dao;

import static reservation.dao.CommentDaoSqls.*;

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

import reservation.dto.Comment;

@Repository
public class CommentDao {
	private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<Comment> rowMapper = BeanPropertyRowMapper.newInstance(Comment.class);

    public CommentDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("reservation_user_comment").usingGeneratedKeyColumns("id");
    }
    
    public List<Comment> selectAllByProductId(int productId) {
    	Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);
        return jdbc.query(SELECT_ALL_BY_PRODUCT_ID, params, rowMapper);
    }
    
    public List<Comment> selectByProductId(int productId) {
    	Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);
        return jdbc.query(SELECT_BY_PRODUCT_ID_LIMIT, params, rowMapper);
    }
    
    public int selectCount(int productId) {
    	Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);
        return jdbc.queryForObject(SELECT_COUNT, params, Integer.class);
    }
    
    public double selectAvgScore(int productId) {
    	Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);
		double avgScore = 0;
		try {
			avgScore = jdbc.queryForObject(SELECT_AVG_SCORE, params, Double.class);			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return avgScore;
    }
    
    public Long insert(Comment comment) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(comment);
		return insertAction.executeAndReturnKey(params).longValue();
	}
    
    public int selectLastComment() {
    	Map<String, String> params = new HashMap<>();
		return jdbc.queryForObject(SELECT_LAST_COMMENT, params, Integer.class);
    }
}
