package Coffee.info.author;

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

import org.apache.log4j.Logger;

import Coffee.info.control.LoginAction;
import Coffee.info.dao.User;

public class AuthorFilter implements Filter{
	private static final Logger log = Logger.getLogger(LoginAction.class);
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse rep = (HttpServletResponse)response;
		
		String webPath = req.getContextPath();
		String uri = req.getRequestURI();
		
		if(uri.equals(webPath + "/index.jsp") || uri.equals(webPath + "/")){
			chain.doFilter(req, rep);
		}else if(uri.equals(webPath + "/login.action")){
			chain.doFilter(req, rep);
		}else{
			HttpSession session = req.getSession();
			User user = (User)session.getAttribute("user");
		
			if(user == null){
				log.info("非法访问路径"+uri);
				rep.sendRedirect(webPath +"/index.jsp");
				return;
			}else{
				String type = user.getRole();
				if (type.equals("admin")&&uri.equals(webPath + "/user.jsp")) {
					log.info("非法访问路径"+uri);
					rep.sendRedirect(webPath +"/index.jsp");
					return;
				}else if (type.equals("user")&&uri.equals(webPath + "/admin.jsp")) {
					log.info("非法访问路径"+uri);
					rep.sendRedirect(webPath +"/index.jsp");
					return;
				}
				chain.doFilter(req, rep);
			}
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
