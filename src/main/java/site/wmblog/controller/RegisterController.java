package site.wmblog.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.wmblog.entity.User;
import site.wmblog.result.Result;
import site.wmblog.service.UserService;

import javax.annotation.Resource;

/**
 * Created by wangjunling on 2016/8/16.
 */
@RestController
public class RegisterController extends BaseController {
	@Resource
	private UserService userService;

	@RequestMapping("/user/register")
	public Result register(@RequestBody User user) {
		try {
			userService.save(user);
			return new Result().success();
		} catch (Exception e) {
			logger.error("user register error!", e);
			return new Result().error();
		}
	}
}
