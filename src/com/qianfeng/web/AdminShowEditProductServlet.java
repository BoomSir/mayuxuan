package com.qianfeng.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.print.attribute.ResolutionSyntax;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.domain.Category;
import com.qianfeng.domain.Product;
import com.qianfeng.service.AdminCategoryService;
import com.qianfeng.service.AdminProductService;

public class AdminShowEditProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取表单数据
		String pid = request.getParameter("pid");
		//2.传递业务
		AdminProductService service = new AdminProductService();
		//3.获得结果
		Product product = null;
		try {
			product = service.findProductById(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//=====获得所有分类的信息====
		AdminCategoryService service1 = new AdminCategoryService();
		List<Category> categoryList = null;
		try {
			categoryList = service1.findAllCategory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//4.封装进域对象
		request.setAttribute("product", product);
		request.setAttribute("categoryList", categoryList);
		//5.转发
		request.getRequestDispatcher("/admin/editProduct.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
