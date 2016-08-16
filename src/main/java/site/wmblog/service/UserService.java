package site.wmblog.service;

import site.wmblog.entity.User;
import site.wmblog.session.UserSession;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by wangjunling on 2016/8/15.
 */
public interface UserService {
	UserSession login(String username, String password) throws Exception;
}
