package com.qianfeng.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qianfeng.domain.Admin;
import com.qianfeng.service.UserLoginServer;

public class UserLoginServlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
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
			response.sendRedirect(request.getContextPath()+"/admin/index.jsp");
		}else {
			response.getWriter().write("请输入正确的商家名和密码");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}