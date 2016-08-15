package site.wmblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.wmblog.entity.Category;

/**
 * Created by wangjunling on 2016/8/15.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
