package com.qianjin.java.soa.hibernate.springdata;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.qianjin.java.soa.model.ProductList;
import com.qianjin.java.soa.model.ProductListPOJO;

public interface PorductListRepository extends CrudRepository<ProductListPOJO,Integer> {
	public List<ProductListPOJO> findByGroupId(String  groupId);
}
