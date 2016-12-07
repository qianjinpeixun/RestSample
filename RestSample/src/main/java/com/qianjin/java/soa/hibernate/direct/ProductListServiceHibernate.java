package com.qianjin.java.soa.hibernate.direct;

import java.util.*;

import org.springframework.stereotype.Service;

import com.qianjin.java.soa.model.ProductList;

@Service
public class ProductListServiceHibernate {

	public List<ProductList> getListByGroupId(String groupId){
		
		List<ProductList> ret= new ArrayList<ProductList>();
		List<ProductList> list=ProductListDAOHibernate.getInstance().getAll();
		if(list ==null) return null;
		for(ProductList data : list){
			
			if(data.getGroup_id().equals(groupId)){
				ret.add(data);
			}
		}
		return ret;
		
		
		
	}
}
