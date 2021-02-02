package reservation.dao;

import static reservation.dao.DisplayInfoImageDaoSqls.SELECT_BY_DISPLAY_INFO_ID;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import reservation.dto.DisplayInfoImage;

@Repository
public class DisplayInfoImageDao {
	private NamedParameterJdbcTemplate jdbc;
    //private SimpleJdbcInsert insertAction;
    private RowMapper<DisplayInfoImage> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImage.class);
    
    public DisplayInfoImageDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        //this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("category");
    }
    
    public DisplayInfoImage selectByDisplayInfoId(Integer displayInfoId) {
    	Map<String, Integer> params = new HashMap<>();
		params.put("displayInfoId", displayInfoId);
        return  jdbc.queryForObject(SELECT_BY_DISPLAY_INFO_ID, params, rowMapper);
    }
}
