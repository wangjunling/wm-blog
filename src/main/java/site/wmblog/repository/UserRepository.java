package site.wmblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.wmblog.entity.User;

/**
 * Created by wangjunling on 2016/8/15.
 */
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsernameAndPassword(String username, String password);
}
