package com.qianfeng.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.domain.Category;
import com.qianfeng.service.AdminCategoryService;
/**
 * 为了来到添加商品页时，该页内的分类下拉选空间已经有数据，该servlet就是获得该数据的。
 */
public class AdminShowAddProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获得所有分类信息
		AdminCategoryService service = new AdminCategoryService();
		List<Category> categoryList = null;
		try {
			categoryList = service.findAllCategory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2.封装到域对象中
		request.setAttribute("categoryList", categoryList);
		// 3.转向
		request.getRequestDispatcher("/admin/addProduct.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}