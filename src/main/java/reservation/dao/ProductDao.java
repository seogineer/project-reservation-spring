package reservation.dao;

import static reservation.dao.ProductDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import reservation.dto.Product;

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc;
    //private SimpleJdbcInsert insertAction;
    private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);

    public ProductDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        //this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("product");
    }
    
    public int selectCount() {
        return jdbc.queryForObject(SELECT_COUNT, Collections.emptyMap(), Integer.class);
    }
    
    public int selectCountByCategoryId(Integer categoryId) {
    	Map<String, Integer> params = new HashMap<>();
    	params.put("categoryId", categoryId);
    	return jdbc.queryForObject(SELECT_COUNT_BY_CATEGORY_ID, params, Integer.class);
    }
    
    public List<Product> select(Integer categoryId, Integer start, Integer limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("limit", limit);
		if(categoryId > 0) {
			return jdbc.query(SELECT_BY_CATEGORY_ID, params, rowMapper);
		} else {
			return jdbc.query(SELECT, params, rowMapper);
		}
		
    }
    
    public Product selectByProductId(Integer productId){
    	Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);
		return jdbc.queryForObject(SELECT_BY_PRODUCT_ID, params, rowMapper);
    }
}
