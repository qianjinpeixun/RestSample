package com.qianjin.java.soa.hibernate.jpa2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.qianjin.java.soa.model.ProductList;

@Service
public class ProductListServiceHibernateJPA2 {

	@PersistenceContext private EntityManager entityManager;
	
	public List<ProductList> getListByGroupIdViaJPA(String groupId) {
		List<ProductList> list = new ArrayList<ProductList>();
		try{
			
			//entityManager.getTransaction().begin();
			list = entityManager.createQuery( "from ProductList", ProductList.class ).getResultList();
			//entityManager.getTransaction().commit();
			//entityManager.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
		
	}
}
