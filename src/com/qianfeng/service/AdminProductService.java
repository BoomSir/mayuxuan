package com.qianfeng.service;

import java.sql.SQLException;
import java.util.List;

import com.qianfeng.dao.AdminProductDao;
import com.qianfeng.domain.Product;
import com.qianfeng.domain.vo.Condition;
import com.qianfeng.domain.vo.PageBean;

public class AdminProductService {
	//查询所有商品
	public List<Product> findAllProduct() throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		return dao.findAllProduct();
		
	}
	//根据id删除商品
	public void deleteProductById(String pid) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		dao.deleteProductById(pid);
	}
	//添加商品
	public void addProduct(Product product) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		dao.addProduct(product);
		
	}
	//根据商品id获得商品
	public Product findProductById(String pid) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		return dao.findProductById(pid);
	}
	//跟新商品
	public void updateProduct(Product product) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		dao.updateProduct(product);
	}
	//搜索商品
	public List<Product> findProductListBySearch(Condition condition) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		return dao.findProductListBySearch(condition);
	}
	/*
	 * 要想实现分页的功能，就必须获得这五项数据:这五项数据将被封装进pagebaen对象中，在各层间传递
	 * 当前页	   currentPage 该数据从客户端获得 //0表示第一页
	 * 每页显示的条数    currentCount  该数据也从客户端获得  目前我们在这写死  12条
	 * 数据总条数	totalCount
	 * 总页数		totalPage
	 * 当前页上的数据     PageData    select * from product  limit ?,?
	 *   
	 */
	//获得一个PageBean对象
	public PageBean<Product> findProductsByPageBean(int currentPageInt, int currentCount) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		//商品总条数
		Long totalCountLong = (Long)dao.findProducttotalCount();
		int totalCount = totalCountLong.intValue();
		//总页数 = Math.ceil(商品总数/每页显式地商品数)     这是返回浮点数上一个整数
		int totalPage = (int) Math.ceil(totalCount/(currentCount*1.0));
		//select * from product  limit ?,?
		//起始索引 = （当前页-1）*12	
		int productIndex = (currentPageInt-1)*currentCount;
		List<Product> pageData = dao.findPageBeanData(productIndex,currentCount);
		//封装pageBean
		PageBean<Product> pageBean = new PageBean<>();
		pageBean.setCurrentPage(currentPageInt);
		pageBean.setCurrentCount(currentCount);
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage(totalPage);
		pageBean.setPageData(pageData);
		return pageBean;
	}
	public void deleteProductsByPid(String[] delBoxes) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		//遍历数组，根据数组中的pid删除商品
		for (String pid : delBoxes) {
			dao.deleteProductById(pid);
		}
		
	}

}
