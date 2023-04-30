package fr.dopolytech.polyshop.catalog.dto;

public class CreateProductDto {
  public String id;
  public String name;
  public String description;
  public double price;
  
  public CreateProductDto() {
  }

  public CreateProductDto(String id, String name, String description, double price) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
  }
}