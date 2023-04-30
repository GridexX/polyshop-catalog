package fr.dopolytech.polyshop.catalog.exceptions;

public class ProductNotFound extends RuntimeException {
  public ProductNotFound(String id) {
    super("Could not find product " + id);
  }
}