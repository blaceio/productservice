package io.blace.microservices.productservice.mongo.product;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

	Product findById(String id);
	
	List<Product> findAll();
	
	List<Product> findByType(String type);
	
	List<Product> findByCategory(String category);
	
	List<Product> findByRegion(String category);
	
}
