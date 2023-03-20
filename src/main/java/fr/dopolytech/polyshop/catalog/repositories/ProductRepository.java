package fr.dopolytech.polyshop.catalog.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import fr.dopolytech.polyshop.catalog.documents.Product;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, String> {

}
