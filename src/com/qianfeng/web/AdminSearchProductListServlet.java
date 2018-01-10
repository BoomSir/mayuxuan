package com.qianfeng.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.qianfeng.domain.Category;
import com.qianfeng.domain.Product;
import com.qianfeng.domain.vo.Condition;
import com.qianfeng.service.AdminCategoryService;
import com.qianfeng.service.AdminProductService;

public class AdminSearchProductListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//1.获得表单数据
		Condition condition = new Condition();
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(condition,map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.传递业务
		AdminProductService service = new AdminProductService();
		List<Product> productList = null;
		try {
			productList = service.findProductListBySearch(condition);
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
		//3.封装数据到域对象中
		request.setAttribute("productList", productList);
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("condition", condition);
		//4.转发
		request.getRequestDispatcher("/admin/showProductList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}