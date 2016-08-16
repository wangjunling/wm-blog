package site.wmblog.service.impl;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.wmblog.entity.User;
import site.wmblog.repository.UserRepository;
import site.wmblog.service.UserService;
import site.wmblog.session.UserSession;
import site.wmblog.session.UserSessionFactory;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * Created by wangjunling on 2016/8/15.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private UserRepository userRepository;

	@Override
	public UserSession login(String username, String password) throws Exception {
		User user = userRepository.findByUsernameAndPassword(username, password);
		Objects.requireNonNull(user);
		UserSession userSession = new UserSession();
		BeanUtils.copyProperties(userSession, user);
		UserSessionFactory.update(userSession);
		return userSession;
	}
}
