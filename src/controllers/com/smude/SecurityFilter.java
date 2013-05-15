package controllers.com.smude;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("--In Security Filter--");
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		HttpServletResponse httpReponse=(HttpServletResponse) response;
//		HttpSession session=httpRequest.getSession();
		String requestURL = httpRequest.getRequestURL().toString();
		String requestURI = httpRequest.getRequestURI().toString();
		System.out.println("current Url :"+requestURL);
		System.out.println("current Uri :"+requestURI);		
//		String[] uriArray = requestURI.split("/");
//		System.out.println("length ::"+uriArray.length);
//		if(uriArray.length<=2){
//			System.out.println("This is true in array Length");
//			httpReponse.sendRedirect("index");
//		}
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
