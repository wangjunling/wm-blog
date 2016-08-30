package site.wmblog.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.wmblog.entity.Article;
import site.wmblog.entity.User;
import site.wmblog.repository.ArticleRepository;
import site.wmblog.repository.UserRepository;
import site.wmblog.service.ArticleService;
import site.wmblog.session.UserSessionFactory;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

/**
 * Created by wangjunling on 2016/8/9.
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
	@Resource
	private ArticleRepository articleRepository;

	@Resource
	private UserRepository userRepository;
	@Override
	public Article findById(Long id) throws Exception {

		return articleRepository.findOne(id);

	}

	@Override
	public Page<Article> list() {
		Pageable pageable = new PageRequest(0,10);
		return articleRepository.findAll(pageable);
	}

	@Override
	public Article save(Article article) {
		Date date = new Date();
		article.setCreateTime(date);
		article.setUpdateTime(date);
		article.setAuthorId(UserSessionFactory.getUserSession().getId());
		return articleRepository.save(article);
	}

	@Override
	public Page<Article> list(String username) throws Exception {
		Objects.requireNonNull(username);
		Pageable pageable = new PageRequest(0,10);
		User user = userRepository.findByUsername(username);
		Objects.requireNonNull(user);
		return articleRepository.findByAuthorId(user.getId(),pageable);
	}
}
