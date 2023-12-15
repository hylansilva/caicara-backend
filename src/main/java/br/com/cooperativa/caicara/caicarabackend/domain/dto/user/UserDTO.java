package br.com.cooperativa.caicara.caicarabackend.domain.dto.user;

import br.com.cooperativa.caicara.caicarabackend.domain.entity.user.UserType;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;


public record UserDTO(
        @Email
        @NotBlank
        String email,
        @NotBlank
        String password,
        @NotNull
        UserType role,
        @NotNull
        BigDecimal amount
) {
}
