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
    public ResponseEntity<List<Product>> getallproducts() {
    		logger.info("getallproducts requested");
        return new ResponseEntity<List<Product>>(productrepo.findAll(), HttpStatus.OK);
    }
    
    @CrossOrigin
    @RequestMapping(value = "product", params = {"id"})
    public ResponseEntity<Product> getbyid(@RequestParam("id") String id){
    		logger.info("getbyid requested for " +  id);
        return new ResponseEntity<Product>(productrepo.findById(id), HttpStatus.OK);
    }   
    
    @CrossOrigin
    @RequestMapping(value = "product", params = {"type"})
    public ResponseEntity<List<Product>> getbytype(@RequestParam("type") String type){
    		logger.info("getbytype requested for " +  type);
        return new ResponseEntity<List<Product>>(productrepo.findByType(type), HttpStatus.OK);
    }   
    
    @CrossOrigin
    @RequestMapping(value = "product", params = {"category"})
    public ResponseEntity<List<Product>> getbycategory(@RequestParam("category") String category){
    		logger.info("getbycategory requested for " +  category);
        return new ResponseEntity<List<Product>>(productrepo.findByCategory(category), HttpStatus.OK);
    }   
    
    @CrossOrigin
    @RequestMapping(value = "product", params = {"region"})
    public ResponseEntity<List<Product>> getbyregion(@RequestParam("region") String region){
    		logger.info("getbyregion requested for " +  region);
        return new ResponseEntity<List<Product>>(productrepo.findByRegion(region), HttpStatus.OK);
    }   
    
    @CrossOrigin
    @PostMapping("/product")
    public ResponseEntity<Product> createproduct(@RequestBody Product product) {
    		logger.info("createproduct requested for " +  product.toString());
    		productrepo.save(product);
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
