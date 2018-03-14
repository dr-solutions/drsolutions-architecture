package at.drsolutions.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {

	private static final String METHOD_OPTIONS = "OPTIONS";

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpServletRequest request = (HttpServletRequest) servletRequest;

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, OPTIONS, POST, PUT");
		response.setHeader("Access-Control-Allow-Headers",
				"Origin, Accept, X-Requested-With, content-type, Access-Control-Request-Method, Access-Control-Request-Headers");
		response.setHeader("Access-Control-Allow-Request-Headers", "content-type");
		response.setHeader("Access-Control-Max-Age", "86400");

		if (METHOD_OPTIONS.equals(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
			return;
		}

		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
