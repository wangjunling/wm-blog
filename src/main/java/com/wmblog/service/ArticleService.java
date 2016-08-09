package com.wmblog.service;

import com.wmblog.entity.Article;

/**
 * Created by wangjunling on 2016/8/9.
 */
public interface ArticleService {
	Article findById(Long id);
}
