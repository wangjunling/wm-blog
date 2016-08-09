package com.wmblog.service.impl;

import com.wmblog.entity.Article;
import com.wmblog.repository.ArticleRepository;
import com.wmblog.service.ArticleService;
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
