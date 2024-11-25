package dev.myfinancetracker.repository;

import dev.myfinancetracker.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
}
