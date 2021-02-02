package reservation.dao;

import static reservation.dao.CategoryDaoSqls.SELECT;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import reservation.dto.Category;

@Repository
public class CategoryDao {
	private NamedParameterJdbcTemplate jdbc;
    //private SimpleJdbcInsert insertAction;
    private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);

    public CategoryDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        //this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("category");
    }
    
    public List<Category> select() {
        return  jdbc.query(SELECT, rowMapper);
    }
    
}
