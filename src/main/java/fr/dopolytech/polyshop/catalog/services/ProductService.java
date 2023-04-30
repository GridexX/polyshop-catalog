package fr.dopolytech.polyshop.catalog.services;

import java.util.stream.Collectors;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;

import fr.dopolytech.polyshop.catalog.documents.Product;
import fr.dopolytech.polyshop.catalog.dto.CreateProductDto;
import fr.dopolytech.polyshop.catalog.dto.ProductDto;
import fr.dopolytech.polyshop.catalog.dto.PutProductDto;
import fr.dopolytech.polyshop.catalog.exceptions.ProductNotFound;
import fr.dopolytech.polyshop.catalog.repositories.ProductRepository;
import io.micrometer.common.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
  private final ProductRepository repository;

  public ProductService(ProductRepository repository) {
    this.repository = repository;
  }

  public Flux<ProductDto> getProducts() {
      return repository.findAll().map(ProductDto::new);
  }

  public Mono<ProductDto> getProduct(String productId) {
      return repository.findByProductId(productId).map(ProductDto::new);
  }

  public Mono<ProductDto> createProduct(CreateProductDto product) {
    Product newProduct = new Product(product.id, product.name, product.description, product.price);
    return repository.save(newProduct)
        .map(savedProduct -> new ProductDto(savedProduct));
  }

  public Mono<ProductDto> updateProduct(String productId, PutProductDto product) throws ProductNotFound {
    Product findProduct = repository.findByProductId(productId).block();
    if (findProduct == null) {
      throw new ProductNotFound(productId);
    }
    if (StringUtils.isNotBlank(product.name)) {
      findProduct.name = product.name;
    }
    if (StringUtils.isNotBlank(product.description)) {
      findProduct.description = product.description;
    }
    if (product.price != 0) {
      findProduct.price = product.price;
    }

    return repository.save(findProduct)
        .map(savedProduct -> new ProductDto(savedProduct));

  }

  public Mono<Void> deleteProduct(String productId) {
    return repository.deleteByProductId(productId);
  }
}