package com.qianfeng.service;

import java.sql.SQLException;
import java.util.List;

import com.qianfeng.dao.AdminCategoryDao;
import com.qianfeng.domain.Category;

public class AdminCategoryService {
	//查询所有分类
	public List<Category> findAllCategory() throws SQLException {
		AdminCategoryDao dao = new AdminCategoryDao();
		return dao.findAllCategory();
	}

}
