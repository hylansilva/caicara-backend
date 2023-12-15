package br.com.cooperativa.caicara.caicarabackend.application.controller;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cooperativa.caicara.caicarabackend.domain.dto.product.ProductDTO;
import br.com.cooperativa.caicara.caicarabackend.domain.entity.product.Product;
import br.com.cooperativa.caicara.caicarabackend.domain.service.ProductService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody @Valid ProductDTO DTO) {
        Product createProduct = productService.saveProduct(DTO);
        return new ResponseEntity<>(createProduct, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Product>> listByUserId(@PathVariable UUID id) {
        Optional<List<Product>> product = productService.findByUserId(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
