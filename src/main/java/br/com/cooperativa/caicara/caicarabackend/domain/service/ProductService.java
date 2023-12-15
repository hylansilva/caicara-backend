package br.com.cooperativa.caicara.caicarabackend.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.cooperativa.caicara.caicarabackend.domain.dto.product.ProductDTO;
import br.com.cooperativa.caicara.caicarabackend.domain.entity.product.Product;

@Service
public interface ProductService {
    Optional<List<Product>> findByUserId(UUID id);
    Product saveProduct(ProductDTO data);
}
