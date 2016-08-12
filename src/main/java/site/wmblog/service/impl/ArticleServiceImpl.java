package site.wmblog.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.wmblog.entity.Article;
import site.wmblog.repository.ArticleRepository;
import site.wmblog.service.ArticleService;

import javax.annotation.Resource;

/**
 * Created by wangjunling on 2016/8/9.
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
	@Resource
	private ArticleRepository articleRepository;

	@Override
	public Article findById(Long id) throws Exception {

		return articleRepository.findOne(id);

	}

	@Override
	public Page<Article> list() {
		Pageable pageable = new PageRequest(0,10);
		return articleRepository.findAll(pageable);
	}
}
