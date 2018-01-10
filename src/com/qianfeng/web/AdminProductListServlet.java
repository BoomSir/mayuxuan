package com.qianfeng.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.domain.Category;
import com.qianfeng.domain.Product;
import com.qianfeng.service.AdminCategoryService;
import com.qianfeng.service.AdminProductService;

public class AdminProductListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.查询所有商品的数据--由service层来完成
		AdminProductService service = new AdminProductService();
		List<Product> productList = null;
		try {
			productList = service.findAllProduct();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AdminCategoryService service1 = new AdminCategoryService();
		List<Category> categoryList = null;
		try {
			categoryList = service1.findAllCategory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.封装数据到域对象中
		request.setAttribute("productList", productList);
		request.setAttribute("categoryList", categoryList);
		//3.传递给前端页面
		request.getRequestDispatcher("/admin/showProductList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
