package site.wmblog.controller;

import site.wmblog.entity.Article;
import site.wmblog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by wangjunling on 2016/8/5.
 */
@Controller("article")
public class ArticleController {
	private Logger logger = LoggerFactory.getLogger(ArticleController.class);
	@Resource
	private ArticleService articleService;

	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable Long id, Model model) {
		try {
			Article article = articleService.findById(id);
			model.addAttribute("article", article);
		} catch (Exception e) {
			logger.error("select article error!", e);
		}

		return "article/detail";
	}

}
