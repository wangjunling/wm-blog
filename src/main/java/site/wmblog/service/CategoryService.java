package site.wmblog.service;

import site.wmblog.entity.Category;

import java.util.List;

/**
 * Created by wangjunling on 2016/8/15.
 */
public interface CategoryService {
	List<Category> nav();

	Category save(Category category);
}
