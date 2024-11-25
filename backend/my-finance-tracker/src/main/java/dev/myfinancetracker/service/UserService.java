package dev.myfinancetracker.service;

import dev.myfinancetracker.model.UserModel;
import dev.myfinancetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService (UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserModel createUser(UserModel user) {
        String encryptedPassword = passwordEncoder.encode(user.getPasswordHash());
        user.setPasswordHash(encryptedPassword);

        return userRepository.save(user);
    }
}
