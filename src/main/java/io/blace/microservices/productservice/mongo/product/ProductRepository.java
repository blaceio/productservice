package io.blace.microservices.productservice.mongo.product;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String>, ProductRepositoryCustom {

	List<Product> findAll();
	
	Product findById(String id);
	
}
