package com.zufe.filter;

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

import com.zufe.utils.Constant;

public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest rq = (HttpServletRequest) request;
		HttpServletResponse rp = (HttpServletResponse) response;

		String path = rq.getServletPath();
		String p = path.substring(path.length() - 3, path.length());
		
		if (path.equals("/admin/login.jsp")||p.equals(".js")) {
			filterChain.doFilter(request, response);
		} else {
			HttpSession session = rq.getSession();
			String userName = (String) session.getAttribute("loginName");
			// 验证用户登录
			if (null == userName) {
				String basePath = rq.getScheme()+"://"+rq.getServerName()+":"+rq.getServerPort()+rq.getContextPath()+"/";
				rp.sendRedirect(basePath+Constant.LOGIN_URL);
			} else {
				filterChain.doFilter(request, response);
			}
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
