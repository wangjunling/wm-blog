package site.wmblog.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangjunling on 2016/8/15.
 */
@WebFilter(filterName = "webContextFilter", urlPatterns = "/*")
public class WebContextFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		WebContext.init(request, response);
		try {
			filterChain.doFilter(request, response);
		} finally {
			WebContext.destroy();
		}
	}

	@Override
	public void destroy() {

	}
}
