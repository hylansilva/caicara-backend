package br.com.cooperativa.caicara.caicarabackend.domain.repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cooperativa.caicara.caicarabackend.domain.entity.product.Product;

public interface ProductRepository extends JpaRepository<Product, String>{
    Optional<List<Product>> findByUserId(UUID userId);
}