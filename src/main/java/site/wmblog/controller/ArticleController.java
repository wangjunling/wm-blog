package site.wmblog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import site.wmblog.entity.Article;
import site.wmblog.result.Result;
import site.wmblog.service.ArticleService;

import javax.annotation.Resource;
import java.util.List;

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
}
