package reservation.dao;

import static reservation.dao.DisplayInfoDaoSqls.SELECT_BY_DISPLAY_INFO_ID;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import reservation.dto.DisplayInfo;

@Repository
public class DisplayInfoDao {
	private NamedParameterJdbcTemplate jdbc;
    //private SimpleJdbcInsert insertAction;
    private RowMapper<DisplayInfo> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfo.class);
    
    public DisplayInfoDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        //this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("category");
    }
    
    public DisplayInfo selectByDisplayInfoId(Integer displayInfoId) {
    	Map<String, Integer> params = new HashMap<>();
		params.put("displayInfoId", displayInfoId);
        return  jdbc.queryForObject(SELECT_BY_DISPLAY_INFO_ID, params, rowMapper);
    }
}
