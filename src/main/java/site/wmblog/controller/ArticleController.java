package site.wmblog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import site.wmblog.entity.Article;
import site.wmblog.result.Result;
import site.wmblog.service.ArticleService;

import javax.annotation.Resource;

/**
 * Created by wangjunling on 2016/8/5.
 */
@Controller("article")
public class ArticleController {
	private Logger logger = LoggerFactory.getLogger(ArticleController.class);
	@Resource
	private ArticleService articleService;

	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Result detail(@PathVariable Long id) {
		try {
			Article article = articleService.findById(id);
			return new Result().success(article);
		} catch (Exception e) {
			logger.error("select article error!", e);
			return new Result().error();
		}
	}

}
