package reservation.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import reservation.dto.ReservationInfo;
import reservation.dto.ReservationInfoPrice;

@Repository
public class ReservationInfoPriceDao {
	private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<ReservationInfo> rowMapper = BeanPropertyRowMapper.newInstance(ReservationInfo.class);

    public ReservationInfoPriceDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("reservation_info_price").usingGeneratedKeyColumns("id");
    }
    
    public Long insert(ReservationInfoPrice reservationInfoPrice) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfoPrice);
		return insertAction.executeAndReturnKey(params).longValue();
	}
}
