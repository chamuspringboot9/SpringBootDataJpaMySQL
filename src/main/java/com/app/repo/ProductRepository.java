package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	//List<Product> findByProdCode(String prodCode);
	//List<Product> findByProdCodeIs(String prodCode);
	//List<Product> findByProdCodeEquals(String prodCode);
	
	//List<Product> findByProdCostLessThan(Double prodCost);
	//List<Product> findByProdCostLessThanEqual(Double prodCost);
	
	//List<Product> findByProdCodeOrProdCostLessThan(String prodCode,Double prodCost);
	
	//List<Product> findByProdCodeNotNull(String prodCode);
	//List<Product> findByProdCodeIsNotNull(String prodCode);
	
	List<Product> findByProdCodeLike(String prodCode);
}
