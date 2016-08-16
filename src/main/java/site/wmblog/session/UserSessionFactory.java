package site.wmblog.session;

import site.wmblog.filter.WebContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by wangjunling on 2016/8/15.
 */
public class UserSessionFactory {
	public static final String SESSION_NAME = "xUser";

	public static void update(UserSession userSession) {
		HttpServletRequest request = WebContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute(SESSION_NAME, userSession);
	}

	public static void clear() {
		WebContext.getRequest().getSession().invalidate();
	}

	public static UserSession getUserSession() {
		return (UserSession) WebContext.getRequest().getSession().getAttribute(SESSION_NAME);
	}
}
