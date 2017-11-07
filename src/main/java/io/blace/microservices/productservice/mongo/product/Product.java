package io.blace.microservices.productservice.mongo.product;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Product {
	
	@Id
	private String id;
	
	private String description;
	
	private List<Reference> types;
	private List<Reference> categories;
	private List<Reference> regions;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Reference> getTypes() {
		return types;
	}
	public void setTypes(List<Reference> types) {
		this.types = types;
	}
	public List<Reference> getCategories() {
		return categories;
	}
	public void setCategories(List<Reference> categories) {
		this.categories = categories;
	}
	public List<Reference> getRegions() {
		return regions;
	}
	public void setRegions(List<Reference> regions) {
		this.regions = regions;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", types=" + types + ", categories=" + categories
				+ ", regions=" + regions + "]";
	}

}
