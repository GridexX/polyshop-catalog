package fr.dopolytech.polyshop.catalog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import fr.dopolytech.polyshop.catalog.repositories.ProductRepository;
import fr.dopolytech.polyshop.catalog.services.ProductService;
import fr.dopolytech.polyshop.catalog.documents.Product;

@RestController
@RequestMapping("/products")
class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Mono<Product> create(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public Mono<Product> findOne(@PathVariable("id") String productId) {
		return productService.getProduct(productId);
	}

	@GetMapping(produces = "application/json")
	public Flux<Product> findALl() {
		return productService.getProducts();
	}


	@DeleteMapping(value = "/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> delete(@PathVariable("id") String id) {
		return productService.deleteProduct(id);
	}
}
