package fr.dopolytech.polyshop.catalog.dto;

public class PutProductDto {
  public String name;
  public String description;
  public double price;
  
  public PutProductDto() {
  }

  public PutProductDto( String name, String description, double price) {
    this.name = name;
    this.description = description;
    this.price = price;
  }
}