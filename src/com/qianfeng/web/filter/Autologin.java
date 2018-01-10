package com.qianfeng.web.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.qianfeng.domain.Admin;
import com.qianfeng.service.UserLoginServer;

/**
 * Servlet Filter implementation class Autologin
 */
public class Autologin implements Filter {

    /**
     * Default constructor. 
     */
    public Autologin() {
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
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		Cookie[] cookies = request.getCookies();
		String username=null;
		String password=null;
		if(cookies!=null) {
			for (Cookie cookie : cookies) {
				if("username".equals(cookie.getName())) {
					username = cookie.getValue();
				}
				if("password".equals(cookie.getName())) {
					password = cookie.getValue();
				}
			}
		}
		
		if(username!=null&&password!=null) {
			UserLoginServer server=new UserLoginServer();
			Admin admin=null;
			try {
				admin=server.findUser(username,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(admin!=null) {
				//这个地方用来验证右上角的状态：
				HttpSession session = request.getSession();
				session.setAttribute("admin", admin);
			}else {
			}
		}
		
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
