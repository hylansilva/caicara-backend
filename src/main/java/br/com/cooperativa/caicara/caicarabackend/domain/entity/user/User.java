package br.com.cooperativa.caicara.caicarabackend.domain.entity.user;

import br.com.cooperativa.caicara.caicarabackend.domain.dto.user.UserDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_USERS")
@Table(name = "TB_USERS")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(unique = true)
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @Enumerated(EnumType.STRING)
    private UserType role;

    @NotNull
    private BigDecimal amount;

    public static User from(UserDTO dto) {
        var user = new User();
        BeanUtils.copyProperties(dto, user);
        return user;
    }
}
