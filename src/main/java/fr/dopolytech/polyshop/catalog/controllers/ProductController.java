package fr.dopolytech.polyshop.catalog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import fr.dopolytech.polyshop.catalog.services.ProductService;
import fr.dopolytech.polyshop.catalog.documents.Product;
import fr.dopolytech.polyshop.catalog.dto.CreateProductDto;
import fr.dopolytech.polyshop.catalog.dto.ProductDto;
import fr.dopolytech.polyshop.catalog.dto.PutProductDto;
import fr.dopolytech.polyshop.catalog.exceptions.ProductNotFound;

@RestController
@RequestMapping("/products")
class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Mono<ProductDto> create(@RequestBody CreateProductDto productDto) {
		return productService.createProduct(productDto);
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public Mono<ProductDto> findOne(@PathVariable("id") String productId) {
		return productService.getProduct(productId);
	}

	@GetMapping(produces = "application/json")
	public Flux<ProductDto> findALl() {
		return productService.getProducts();
	}

	@PutMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Mono<ProductDto>> update(@PathVariable("id") String id, @RequestBody PutProductDto productDto) {
		try {
			return ResponseEntity.ok().body(productService.updateProduct(id, productDto));
		} catch (ProductNotFound e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping(value = "/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> delete(@PathVariable("id") String id) {
		return productService.deleteProduct(id);
	}
}
