package site.wmblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.wmblog.entity.Article;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wangjunling on 2016/8/8.
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
