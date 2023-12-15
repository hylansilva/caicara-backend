package br.com.cooperativa.caicara.caicarabackend.domain.entity.product;

import java.math.BigDecimal;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;

import br.com.cooperativa.caicara.caicarabackend.domain.dto.product.ProductDTO;
import br.com.cooperativa.caicara.caicarabackend.domain.entity.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_PRODUCTS")
@Table(name = "TB_PRODUCTS")
public class Product {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id; 

    @NotBlank
    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @NotBlank
    private String title;

    @NotNull
    private BigDecimal weight;

    @NotNull
    private Integer quantity;

    @NotNull
    private BigDecimal pricePerKg;

    @NotNull
    private BigDecimal storageTemperature;

    @Enumerated(EnumType.STRING)
    private ProductType type;

    public static Product from(ProductDTO dto) {
        var product = new Product();
        BeanUtils.copyProperties(dto, product);
        return product;
    }
}
