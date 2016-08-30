package site.wmblog.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import site.wmblog.entity.Article;
import site.wmblog.result.Result;
import site.wmblog.service.ArticleService;

import javax.annotation.Resource;

/**
 * Created by wangjunling on 2016/8/5.
 */
@RestController
@RequestMapping("article")
public class ArticleController extends BaseController {
	@Resource
	private ArticleService articleService;

	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public Result detail(@PathVariable Long id) {
		try {
			Article article = articleService.findById(id);
			return new Result().success(article);
		} catch (Exception e) {
			logger.error("select article error!", e);
			return new Result().error();
		}
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result list() {
		try {
			Page<Article> articlePage = articleService.list();
			return new Result().success(articlePage);
		} catch (Exception e) {
			logger.error("select article error!", e);
			return new Result().error();
		}
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Result save(@RequestBody Article article) {
		try {
			 articleService.save(article);
			return new Result().success();
		} catch (Exception e) {
			logger.error("select article error!", e);
			return new Result().error();
		}
	}

	@RequestMapping(value = "/list/{username}", method = RequestMethod.GET)
	public Result listByUserId(@PathVariable String username) {
		try {
			Page<Article> articlePage = articleService.list(username);
			return new Result().success(articlePage);
		} catch (Exception e) {
			logger.error("select user article error!", e);
			return new Result().error();
		}
	}
}
