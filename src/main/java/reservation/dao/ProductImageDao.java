package reservation.dao;

import static reservation.dao.ProductImageDaoSqls.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import reservation.dto.ProductImage;
@Repository
public class ProductImageDao {
	private NamedParameterJdbcTemplate jdbc;
    //private SimpleJdbcInsert insertAction;
    private RowMapper<ProductImage> rowMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);

    public ProductImageDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        //this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("product");
    }
    
    public List<ProductImage> selectByDisplayInfoId(Integer displayInfoId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("displayInfoId", displayInfoId);
		return jdbc.query(SELECT_BY_DISPLAY_INFO_ID, params, rowMapper);
    }
    
    public List<ProductImage> selectEtcImageByDisplayInfoId(Integer displayInfoId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("displayInfoId", displayInfoId);
		return jdbc.query(SELECT_ETC_IMAGE_BY_DISPLAY_INFO_ID, params, rowMapper);
    }
    
}
