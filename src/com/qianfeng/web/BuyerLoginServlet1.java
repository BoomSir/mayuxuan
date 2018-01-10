package com.qianfeng.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qianfeng.domain.Admin;
import com.qianfeng.service.BuyerLoginServer;

public class BuyerLoginServlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String check=request.getParameter("checked");
		BuyerLoginServer server=new BuyerLoginServer();
		Admin admin=null;
		try {
			admin=server.findUser(username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(admin!=null) {//登入成功
			if(check!=null&&!"".equals(check)) {
				Cookie cookie_username=new Cookie("username", admin.getUsername());
				Cookie cookie_password=new Cookie("password", admin.getPassword());
				cookie_username.setMaxAge(60*60*24*7);
				cookie_password.setMaxAge(60*60*24*7);
				response.addCookie(cookie_username);
				response.addCookie(cookie_password);
			}
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			response.sendRedirect(request.getContextPath()+"/admin/index.jsp");
		}else {
			response.getWriter().write("请输入正确的用户名和密码");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}