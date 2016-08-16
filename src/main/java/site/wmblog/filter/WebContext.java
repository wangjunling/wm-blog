package site.wmblog.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangjunling on 2016/8/15.
 */
public class WebContext {
	public static ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<>();
	public static ThreadLocal<HttpServletResponse> responseHolder = new ThreadLocal<>();

	public static void init(HttpServletRequest request, HttpServletResponse response) {
		requestHolder.set(request);
		responseHolder.set(response);
	}

	public static void destroy() {
		requestHolder.remove();
		responseHolder.remove();
	}

	public static HttpServletRequest getRequest() {
		return requestHolder.get();
	}

	public static HttpServletResponse getResponse() {
		return responseHolder.get();
	}
}
