package reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reservation.dao.CategoryDao;
import reservation.dto.Category;
import reservation.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDao categoryDao;
	
	@Override
	@Transactional
	public List<Category> select() {
		List<Category> list = categoryDao.select();
		return list;
	}

}
