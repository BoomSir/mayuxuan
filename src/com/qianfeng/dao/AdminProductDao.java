package com.qianfeng.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.qianfeng.domain.Product;
import com.qianfeng.domain.vo.Condition;
import com.qianfeng.utils.C3P0Utils;

public class AdminProductDao {
	//查询所有商品:dbutils c3p0
	public List<Product> findAllProduct() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product";
		List<Product> productList = qr.query(sql,new BeanListHandler<Product>(Product.class));
		return productList;
	}
	//根据id删除商品
	public void deleteProductById(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "delete from product where pid=?";
		qr.update(sql,pid);
	}
	
	//添加商品
	public void addProduct(Product p) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?)";
		qr.update(sql,p.getPid(),p.getPname(),p.getMarket_price(),p.getShop_price(),
				p.getPimage(),p.getPdate(),p.getIs_hot(),p.getPdesc(),p.getPflag(),p.getCid());
	}
	//根据id查询商品
	public Product findProductById(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product where pid=?";
		Product product = qr.query(sql,new BeanHandler<Product>(Product.class),pid);
		return product;
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
	//跟新商品
	public void updateProduct(Product p) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "update product set pname=?,market_price=?,shop_price=?,"
				+ "pimage=?,pdate=?,is_hot=?,pdesc=?,pflag=?,cid=? where pid=?";
		qr.update(sql,p.getPname(),p.getMarket_price(),p.getShop_price(),
				p.getPimage(),p.getPdate(),p.getIs_hot(),p.getPdesc(),p.getPflag(),p.getCid(),p.getPid());
	
	}
	//搜索商品
	public List<Product> findProductListBySearch(Condition condition) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		//要组织的sql语句
		String sql = "select * from product where 1=1";
		//有的参数存入集合中
		List<String> params = new ArrayList<>();
		if(condition.getPname()!=null&&!"".equals(condition.getPname().trim())){
			sql += " and pname like ? ";
			params.add("%"+condition.getPname().trim()+"%");
		}
		if(condition.getIs_hot()!=null&&!"".equals(condition.getIs_hot().trim())){
			sql += " and is_hot=? ";
			params.add(condition.getIs_hot().trim());
		}
		if(condition.getCid()!=null&&!"".equals(condition.getCid().trim())){
			sql += " and cid=? ";
			params.add(condition.getCid().trim());
		}
		//参数集合变成数组，作为可变参数
		return qr.query(sql, new BeanListHandler<Product>(Product.class),params.toArray());
		
		
	}
	//获得所有商品的总数
	public Object findProducttotalCount() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select count(*) from product";
		return qr.query(sql, new ScalarHandler());
	}
	//获得pageBean中的数据
	public List<Product> findPageBeanData(int productIndex, int currentCount) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product limit ?,?";
		return qr.query(sql, new BeanListHandler<Product>(Product.class),productIndex,currentCount);
	}

}
