package br.com.cooperativa.caicara.caicarabackend.domain.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.cooperativa.caicara.caicarabackend.domain.dto.user.UserDTO;
import br.com.cooperativa.caicara.caicarabackend.domain.entity.user.User;


@Service
public interface UserService {
    Optional<User> findById(UUID id);
    User saveUser(UserDTO data);
    Optional<User> findByEmail(String email);
}
