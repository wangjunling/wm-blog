package site.wmblog.service.impl;

import site.wmblog.entity.Article;
import site.wmblog.repository.ArticleRepository;
import site.wmblog.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wangjunling on 2016/8/9.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
	@Resource
	private ArticleRepository articleRepository;

	@Override
	public Article findById(Long id) {
		return articleRepository.findOne(id);
	}
}
