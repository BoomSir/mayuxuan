package com.qianfeng.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import com.qianfeng.domain.Product;
import com.qianfeng.service.FindOneService;

public class FindOneServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String pid=request.getParameter("pid");
		FindOneService service=new FindOneService();
		Product carOneProduct=null;
		try {
			carOneProduct=service.findOneProduct(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			service.insertOneProduct(carOneProduct.getPid(),carOneProduct.getPimage(),carOneProduct.getPname(),carOneProduct.getShop_price());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		List<Product> listCarOneProduct= (List<Product>) session.getAttribute("listCarOneProduct");
		if(listCarOneProduct!=null) {
			listCarOneProduct.add(carOneProduct);
		}else {
			listCarOneProduct=new ArrayList<Product>();
			listCarOneProduct.add(carOneProduct);
		}
		
		
		session.setAttribute("listCarOneProduct", listCarOneProduct);
		response.sendRedirect(request.getContextPath()+"/carsuccess.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}