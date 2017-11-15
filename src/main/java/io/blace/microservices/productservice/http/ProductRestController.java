package io.blace.microservices.productservice.http;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.blace.microservices.productservice.mongo.product.Product;
import io.blace.microservices.productservice.mongo.product.ProductRepository;

@RestController
public class ProductRestController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductRepository productrepo;
	
    @CrossOrigin
    @RequestMapping(value = "product")
    public ResponseEntity<List<Product>> getbyoptional(
    		@RequestParam(value = "id", defaultValue = "") String id,
    		@RequestParam(value = "type", defaultValue = "") String type, 
    		@RequestParam(value = "category", defaultValue = "") String category, 
    		@RequestParam(value = "division", defaultValue = "") String division, 
    		@RequestParam(value = "region", defaultValue = "") String region
    		){
    		logger.info("getbyoptional optional requested for " +  id + " " + type + " " + category + " " + division + " " + region);
    		return new ResponseEntity<List<Product>>(productrepo.findProduct(id, type, category, division, region), HttpStatus.OK);
    }
    
    @CrossOrigin
    @PostMapping("/product")
    public ResponseEntity<Product> createproduct(@RequestBody Product product) {
    		logger.info("createproduct requested for " +  product.toString());
    		productrepo.save(product);
        return new ResponseEntity<Product>(HttpStatus.CREATED);
    }
    
    @CrossOrigin
    @PostMapping("/products")
    public ResponseEntity<Product> createproducts(@RequestBody List<Product> products) {
    		logger.info("createproducts requested");
    		
    		for( Product region : products) {
    			productrepo.save(region);
    		}
    		
        return new ResponseEntity<Product>(HttpStatus.CREATED);
    }
    
    @CrossOrigin
    @DeleteMapping(value = "/product")
    public ResponseEntity<Product> deleteproduct(@RequestParam("deleteid") String deleteid) {
		logger.info("deleteproduct requested for " +  deleteid);
    		Product product = productrepo.findById(deleteid);
    		productrepo.delete(product);
    		return new ResponseEntity<Product>(HttpStatus.ACCEPTED);
    }
	
}
