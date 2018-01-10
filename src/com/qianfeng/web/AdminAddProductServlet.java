package com.qianfeng.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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

public class AdminAddProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		request.setCharacterEncoding("utf-8");
		//1.获得表单数据，使用BeanUtils封装表单数据到javabean中，然后在各层之间传递该装着表单数据的javabean对象即可
		Product product = new Product();
		Map map = request.getParameterMap();
		try {
			//自动封装表单数据到javabean中，如果表单中没有的数据则需要手动封装
			BeanUtils.populate(product, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * `pid` VARCHAR(50) NOT NULL,
	  `pname` VARCHAR(50) DEFAULT NULL,
	  `market_price` DOUBLE DEFAULT NULL,category
	  `shop_price` DOUBLE DEFAULT NULL,
	  `pimage` VARCHAR(200) DEFAULT NULL,
	  `pdate` DATE DEFAULT NULL,
	  `is_hot` INT(11) DEFAULT NULL,
	  `pdesc` VARCHAR(255) DEFAULT NULL,
	  `pflag` INT(11) DEFAULT NULL,
	  `cid` VARCHAR(32) DEFAULT NULL,
		 */
		//2.手动封装表单数据
		product.setPid(UUID.randomUUID().toString());
		product.setPimage("products/1/c_0014.jpg");//因为图片上传之后会用专用的框架工具，所以这里先写死
		//2015-11-02
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());*/
		product.setPdate(new Date());//上架时间
		product.setPflag(1);//上架状态
		
		//2.传递业务
		AdminProductService service = new AdminProductService();
		
		try {
			service.addProduct(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//转向
		response.sendRedirect(request.getContextPath()+"/adminProductListServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
