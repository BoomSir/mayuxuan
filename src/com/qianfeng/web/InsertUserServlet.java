package com.qianfeng.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.qianfeng.domain.User;
import com.qianfeng.service.InsertUserService;

public class InsertUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UUID uuid=UUID.randomUUID();
		String uid=uuid.toString();
		Map<String, String[]> map = request.getParameterMap();
		User u=new User();
		try {
			BeanUtils.populate(u, map);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(u.getUsername());
		InsertUserService service=new InsertUserService();
		try {
			service.InsertUser(uid,u.getUsername(),u.getUserpassword(),u.getRealname(),u.getEmail(),u.getTelephone());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect(request.getContextPath()+"/shoppinguserregistsuccess.jsp");
			
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}