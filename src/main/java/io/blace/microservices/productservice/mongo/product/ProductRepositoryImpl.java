package io.blace.microservices.productservice.mongo.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;

public class ProductRepositoryImpl implements ProductRepositoryCustom {
	
	@Autowired
	private MongoTemplate mongotemplate;
	
	@Override
	public List<Product> findProduct(String id, String type, String category, String division, String region) {
		
		Criteria matchcriteria = new Criteria();
		
		if( !id.equals(""))
			matchcriteria = matchcriteria.and("_id").is(id);
		
		if( !type.equals(""))
			matchcriteria = matchcriteria.and("type").is(type);
		
		if( !category.equals(""))
			matchcriteria = matchcriteria.and("category").is(category);
		
		if( !division.equals(""))
			matchcriteria = matchcriteria.and("division").is(division);
		
		if( !region.equals(""))
			matchcriteria = matchcriteria.and("region").is(region);
		
		MatchOperation matchparams = Aggregation.match(matchcriteria);
		
		Aggregation aggregation = Aggregation.newAggregation(matchparams);
		
		AggregationResults<Product> output 
		  = mongotemplate.aggregate(aggregation, "product", Product.class);
		
		return output.getMappedResults();
	}
	
}
