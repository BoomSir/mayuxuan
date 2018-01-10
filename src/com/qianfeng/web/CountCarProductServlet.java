package com.qianfeng.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.domain.CarProduct;
import com.qianfeng.service.CountCarProductService;

public class CountCarProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String str=request.getParameter("str1");
		System.out.println(str);
		String[] split=null;
		if(str!=null) {
			split = str.split(",");
		
		double count=0;
		for(int i = 0;i<split.length;i++) {
			CountCarProductService service =new CountCarProductService();
			CarProduct one=null;
			try {
				one = service.countCarProduct(split[i]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(one!=null) {
			double oneprice=one.getShop_price();
			count+=oneprice;
		}
	}
		request.setAttribute("count",count);
		request.getRequestDispatcher("/Count.jsp").forward(request, response);
	}
}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}