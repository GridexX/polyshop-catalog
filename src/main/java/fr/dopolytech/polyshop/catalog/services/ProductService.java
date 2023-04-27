package fr.dopolytech.polyshop.catalog.services;

import org.springframework.stereotype.Service;

import fr.dopolytech.polyshop.catalog.documents.Product;
import fr.dopolytech.polyshop.catalog.repositories.ProductRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
  private final ProductRepository repository;

  public ProductService(ProductRepository repository) {
    this.repository = repository;
  }

  public Flux<Product> getProducts() {
      return repository.findAll();
  }

  public Mono<Product> getProduct(String productId) {
      return repository.findByProductId(productId);
  }

  public Mono<Product> createProduct(Product product) {
      return repository.save(product);
  }

  public Mono<Void> deleteProduct(String productId) {
    return repository.deleteByProductId(productId);
  }
}