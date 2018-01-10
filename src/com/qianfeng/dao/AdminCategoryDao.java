package com.qianfeng.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qianfeng.domain.Category;
import com.qianfeng.utils.C3P0Utils;

public class AdminCategoryDao {
	//查询所有分类
	public List<Category> findAllCategory() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from category";
		return qr.query(sql, new BeanListHandler<Category>(Category.class));
	}

}
