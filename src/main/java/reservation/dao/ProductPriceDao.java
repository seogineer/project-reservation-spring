package reservation.dao;

import static reservation.dao.ProductPriceDaoSqls.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import reservation.dto.ProductPrice;
@Repository
public class ProductPriceDao {
	private NamedParameterJdbcTemplate jdbc;
    //private SimpleJdbcInsert insertAction;
    private RowMapper<ProductPrice> rowMapper = BeanPropertyRowMapper.newInstance(ProductPrice.class);

    public ProductPriceDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        //this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("product");
    }
    
    public List<ProductPrice> select(Integer productId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);
		return jdbc.query(SELECT, params, rowMapper);
    }
}
