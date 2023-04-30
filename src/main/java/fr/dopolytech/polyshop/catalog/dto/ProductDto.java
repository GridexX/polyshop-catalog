package fr.dopolytech.polyshop.catalog.dto;

import fr.dopolytech.polyshop.catalog.documents.Product;

public class ProductDto {
  public String id;
  public String name;
  public String description;
  public double price;
  
  public ProductDto() {
  }

  public ProductDto(Product product) {
    this.id = product.productId;
    this.name = product.name;
    this.description = product.description;
    this.price = product.price;
  }

}
