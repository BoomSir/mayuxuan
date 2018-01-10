package com.qianfeng.service;

import java.util.Iterator;
import java.util.List;

import com.qianfeng.domain.Product;

public class DelectCarProductService {

	public List<Product> delectCarProduct(String pid, List<Product> pList) {
		Iterator<Product> iterator = pList.iterator();
		while (iterator.hasNext()) {
			Product product = iterator.next();
			if(product.getPid().equals(pid)) {
				iterator.remove();
				break;
			}
		}
		return pList;
	}


}
