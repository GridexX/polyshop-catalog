package fr.dopolytech.polyshop.catalog.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	@Id
	public String id;
	public String name;
	public String description;
	public double price;
}
