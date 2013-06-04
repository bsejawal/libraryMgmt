package controllers.edu.smude;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class SecurityFilter
 */
public class SecurityFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public SecurityFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@SuppressWarnings("unused")
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpReponse = (HttpServletResponse) response;
		String requestURL = httpRequest.getRequestURL().toString();
		String requestURI = httpRequest.getRequestURI().toString();
		String contextPath = httpRequest.getContextPath();
		if (requestURI.endsWith("/user")) {
			if (httpRequest.getSession().getAttribute("isLogin") == null
					|| httpRequest.getSession().getAttribute("isLogin") != "true") {
				httpReponse.sendRedirect("login");
				return;
			}
		}
		System.out.println("Uri :" + requestURI + " Url ::" + requestURL);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
