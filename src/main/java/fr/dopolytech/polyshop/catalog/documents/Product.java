package fr.dopolytech.polyshop.catalog.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	@Id
	public String id;
	public String productId;
	public String name;
	public String description;
	public double price;

	public Product() {

	}

	public Product(String productId, String name, String description, double price) {
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
	}
}
