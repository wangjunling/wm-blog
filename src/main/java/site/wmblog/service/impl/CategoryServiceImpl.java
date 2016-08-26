package site.wmblog.service.impl;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.wmblog.constant.Constant;
import site.wmblog.entity.Category;
import site.wmblog.repository.CategoryRepository;
import site.wmblog.service.CategoryService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangjunling on 2016/8/15.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Resource
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> nav() {
		return categoryRepository.findAll(new PageRequest(0, Constant.NAV_SIZE)).getContent();
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}
}
