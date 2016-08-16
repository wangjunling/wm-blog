package site.wmblog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import site.wmblog.result.Result;
import site.wmblog.session.UserSessionFactory;

/**
 * Created by wangjunling on 2016/8/16.
 */
@RestController
@RequestMapping("user")
public class UserController {


	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public Result logout() {
		UserSessionFactory.clear();
		return new Result().success();
	}
}
