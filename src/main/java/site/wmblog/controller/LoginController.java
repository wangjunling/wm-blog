package site.wmblog.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import site.wmblog.entity.User;
import site.wmblog.filter.WebContext;
import site.wmblog.result.Result;
import site.wmblog.service.UserService;
import site.wmblog.session.UserSession;
import site.wmblog.session.UserSessionFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * Created by wangjunling on 2016/8/15.
 */
@RestController
public class LoginController extends BaseController {

	@Resource
	private UserService userService;

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public Result login(@RequestBody  User userReq) {
		logger.info(WebContext.getRequest().getRequestURI());
		UserSession user = null;
		try {
			user = userService.login(userReq.getUsername(), userReq.getPassword());
		} catch (Exception e) {
			logger.error("login error! e:{}", e);
		}
		if (Objects.nonNull(user)) {
			return new Result().success(user);
		}
		return new Result().error("登录失败");
	}

	@RequestMapping(value = "/check/login",method = RequestMethod.GET)
	public Result checkLogin() {
		UserSession userSession = UserSessionFactory.getUserSession();
		return new Result().success(userSession);
	}
}
