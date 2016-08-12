package site.wmblog.service;

import site.wmblog.entity.Article;

import java.io.IOException;

/**
 * Created by wangjunling on 2016/8/9.
 */
public interface ArticleService {
	Article findById(Long id) throws Exception;
}
