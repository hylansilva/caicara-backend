package br.com.cooperativa.caicara.caicarabackend.application.serviceImpl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cooperativa.caicara.caicarabackend.domain.dto.user.UserDTO;
import br.com.cooperativa.caicara.caicarabackend.domain.entity.user.User;
import br.com.cooperativa.caicara.caicarabackend.domain.repository.UserRepository;
import br.com.cooperativa.caicara.caicarabackend.domain.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(UserDTO data) {
        User user = User.from(data);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

}
