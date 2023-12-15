package br.com.cooperativa.caicara.caicarabackend.domain.dto.product;

import java.math.BigDecimal;


import br.com.cooperativa.caicara.caicarabackend.domain.entity.product.ProductType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDTO(
        @NotBlank String title,
        @NotBlank String userId,
        @NotNull BigDecimal weight,
        @NotNull Integer quantity,
        @NotNull BigDecimal pricePerKg,
        @NotNull BigDecimal storageTemperature,
        @NotBlank ProductType type) {
}
