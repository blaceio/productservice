package io.blace.microservices.productservice.mongo.product;

import org.springframework.data.annotation.Id;

public class Product {
	
	@Id
	private String id;
	
	private String description;
	private String type;
	private String category;
	private String region;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", type=" + type + ", category=" + category
				+ ", region=" + region + "]";
	}
	
}
