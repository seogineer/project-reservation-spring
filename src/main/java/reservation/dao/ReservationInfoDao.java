package reservation.dao;

import static reservation.dao.ReservationInfoDaoSqls.*;
import static reservation.dao.ReservationInfoDaoSqls.SELECT_CANCEL_COUNT;
import static reservation.dao.ReservationInfoDaoSqls.SELECT_INVALID_COUNT;
import static reservation.dao.ReservationInfoDaoSqls.SELECT_TOTAL_COUNT;
import static reservation.dao.ReservationInfoDaoSqls.SELECT_VALID_COUNT;
import static reservation.dao.ReservationInfoDaoSqls.UPDATE_BY_RESERVATION_INFO_ID;

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

import reservation.dto.ReservationInfo;

@Repository
public class ReservationInfoDao {
	private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<ReservationInfo> rowMapper = BeanPropertyRowMapper.newInstance(ReservationInfo.class);

    public ReservationInfoDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("reservation_info").usingGeneratedKeyColumns("id");
    }
    
    public List<ReservationInfo> selectByReservationEmail(String resrvEmail) {
		Map<String, String> params = new HashMap<>();
		params.put("resrvEmail", resrvEmail);
		
		List<ReservationInfo> list = null;
		
		try {
			list = jdbc.query(SELECT_BY_RESERVATION_EMAIL, params, rowMapper);
			return list;	
		} catch (Exception e) {
			
		}
		return list;
		
    }
    
    public int selectTotalCount(String resrvEmail) {
    	Map<String, String> params = new HashMap<>();
		params.put("resrvEmail", resrvEmail);
        return jdbc.queryForObject(SELECT_TOTAL_COUNT, params, Integer.class);
    }
    
    public int selectValidCount(String resrvEmail) {
    	Map<String, String> params = new HashMap<>();
		params.put("resrvEmail", resrvEmail);
        return jdbc.queryForObject(SELECT_VALID_COUNT, params, Integer.class);
    }
    
    public int selectInvalidCount(String resrvEmail) {
    	Map<String, String> params = new HashMap<>();
		params.put("resrvEmail", resrvEmail);
        return jdbc.queryForObject(SELECT_INVALID_COUNT, params, Integer.class);
    }
    
    public int selectCancelCount(String resrvEmail) {
    	Map<String, String> params = new HashMap<>();
		params.put("resrvEmail", resrvEmail);
        return jdbc.queryForObject(SELECT_CANCEL_COUNT, params, Integer.class);
    }
    
    public int updateByReservationInfoId(int reservationInfoId, int cancelYn) {
		Map<String, Integer> params = new HashMap<>();
		params.put("reservationInfoId", reservationInfoId);
		params.put("cancelYn", cancelYn);
		return jdbc.update(UPDATE_BY_RESERVATION_INFO_ID, params);
	}
    
    public Long insert(ReservationInfo reservationInfo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo);
		return insertAction.executeAndReturnKey(params).longValue();
	}
    
    public int selectLastInfo() {
    	Map<String, String> params = new HashMap<>();
		return jdbc.queryForObject(SELECT_LAST_INFO, params, Integer.class);
    }
}
