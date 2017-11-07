package io.blace.microservices.productservice.mongo.product;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

	Product findById(String id);
	
	List<Product> findAll();
	
	List<Product> findByTypesRef(String type);
	
	List<Product> findByCategoriesRef(String category);
	
	List<Product> findByRegionsRef(String category);
	
}
