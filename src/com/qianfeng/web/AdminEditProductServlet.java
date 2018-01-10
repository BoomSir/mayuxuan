package com.qianfeng.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.qianfeng.domain.Product;
import com.qianfeng.service.AdminProductService;
/**
 * 编辑商品后，将商品的信息存入数据库中 update
 * @author Administrator
 *
 */
public class AdminEditProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//1.获得表单数据
		Product product = new Product();
		Map map = request.getParameterMap();
		try {
			//自动封装
			BeanUtils.populate(product, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.手动封装表单数据update product set pid=?,pname=?,=?,=?...
		/*product.setPid(UUID.randomUUID().toString());已通过隐藏的input封装到表单数据内了*/
//		System.out.println(product.getPid());
		product.setPimage("products/1/c_0014.jpg");//因为图片上传之后会用专用的框架工具，所以这里先写死
		//2015-11-02
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());*/
		product.setPdate(new Date());//上架时间
		product.setPflag(1);//上架状态	
		//3.传递业务
		AdminProductService service = new AdminProductService();
		try {
			service.updateProduct(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3.重定向 到商品列表
		response.sendRedirect(request.getContextPath()+"/adminProductListServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}