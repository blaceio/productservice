package io.blace.microservices.productservice.mongo.product;

import java.util.List;

public interface ProductRepositoryCustom {

	List<Product> findProduct(String id, String type, String category, String division, String region);
}
