package site.wmblog.service;

import org.springframework.data.domain.Page;
import site.wmblog.entity.Article;

import java.io.IOException;
import java.util.List;

/**
 * Created by wangjunling on 2016/8/9.
 */
public interface ArticleService {
	Article findById(Long id) throws Exception;

	Page<Article> list();

	Article save(Article article);
}
