package br.com.cooperativa.caicara.caicarabackend.application.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cooperativa.caicara.caicarabackend.domain.dto.product.ProductDTO;
import br.com.cooperativa.caicara.caicarabackend.domain.entity.product.Product;
import br.com.cooperativa.caicara.caicarabackend.domain.repository.ProductRepository;
import br.com.cooperativa.caicara.caicarabackend.domain.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<List<Product>> findByUserId(UUID id) {
        return productRepository.findByUserId(id);
    }

    @Override
    public Product saveProduct(ProductDTO data) {
        Product product = Product.from(data);
        product.setId(UUID.fromString(data.userId()));
        return productRepository.save(product);
    }

}
