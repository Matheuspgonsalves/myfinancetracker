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

    public UserModel updateUser(int id, UserModel updateUser){
        UserModel existingUser = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User Not Found"));

        existingUser.setEmail(updateUser.getEmail());
        existingUser.setName(updateUser.getName());
        existingUser.setLastName(updateUser.getLastName());

        if(updateUser.getPasswordHash() != null && !updateUser.getPasswordHash().isEmpty()){
            String encryptedPassword = passwordEncoder.encode(updateUser.getPasswordHash());
            existingUser.setPasswordHash(encryptedPassword);
        }

        return userRepository.save(existingUser);
    }

    public void deleteUser(int id){
        if(!userRepository.existsById(id)){
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }
}
