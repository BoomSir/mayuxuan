package com.qianfeng.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qianfeng.domain.Product;
import com.qianfeng.service.DelectCarProductService;

public class DelectCarProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//拿到表单
		String pid=request.getParameter("pid");
		System.out.println("拿到表单");
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Product> pList = (List<Product>) session.getAttribute("listCarOneProduct");

		//传业务
		DelectCarProductService service=new DelectCarProductService();
		List<Product> listCarOneProduct=service.delectCarProduct(pid,pList);
		//重定向
		session.setAttribute("listCarOneProduct", listCarOneProduct);
		response.sendRedirect(request.getContextPath()+"/shopcar/shopcar.jsp");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}