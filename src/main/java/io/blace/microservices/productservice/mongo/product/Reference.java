package io.blace.microservices.productservice.mongo.product;

public class Reference {
	
	private String ref;

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	@Override
	public String toString() {
		return "Reference [ref=" + ref + "]";
	}
	
}
