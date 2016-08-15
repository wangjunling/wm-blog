package site.wmblog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.wmblog.entity.Category;
import site.wmblog.result.Result;
import site.wmblog.service.CategoryService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangjunling on 2016/8/15.
 */
@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController {

	@Resource
	private CategoryService categoryService;

	@RequestMapping("/nav")
	public Result nav() {
		try {
			List<Category> categories = categoryService.nav();
			return new Result().success(categories);
		} catch (Exception e) {
			logger.error("select category error:{}", e);
			return new Result().error();
		}

	}
}
