package site.wmblog.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "/nav", method = RequestMethod.GET)
	public Result nav() {
		try {
			List<Category> categories = categoryService.nav();
			return new Result().success(categories);
		} catch (Exception e) {
			logger.error("select category error:{}", e);
			return new Result().error();
		}

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Result save(@RequestBody Category category) {
		category = categoryService.save(category);
		return new Result().success(category);
	}
}
