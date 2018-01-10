package com.qianfeng.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.domain.Product;
import com.qianfeng.domain.vo.PageBean;
import com.qianfeng.service.AdminProductService;

public class ShowAllProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 要想实现分页的功能，就必须获得这五项数据:这五项数据将被封装进pagebaen对象中，在各层间传递
		 * 当前页	   currentPage 该数据从客户端获得 //1表示第一页
		 * 每页显示的条数    currentCount  该数据也从客户端获得  目前我们在这写死  12条
		 * 数据总条数	totalCount
		 * 总页数		totalPage
		 * 当前页上的数据     PageData 
		 *   
		 */
		String currentPage = request.getParameter("currentPage");
		int currentPageInt = 1;
		if(currentPage!=null&&!"".equals(currentPage)){
			currentPageInt = Integer.parseInt(request.getParameter("currentPage"));
		}
		int currentCount = 12;
		//要想封装pagebean对象，会涉及到具体的业务，那么此时这项工作由service来完成
		AdminProductService service = new AdminProductService();
		PageBean<Product> pageBean = null;
		try {
			pageBean = service.findProductsByPageBean(currentPageInt,currentCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//封装数据集合进域对象中
		request.setAttribute("pageBean", pageBean);
		//转发
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
//		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
