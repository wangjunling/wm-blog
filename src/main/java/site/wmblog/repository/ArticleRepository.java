package site.wmblog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import site.wmblog.entity.Article;

/**
 * Created by wangjunling on 2016/8/8.
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
	Page<Article> findByAuthorId(Long userId, Pageable pageable);
}
