package com.guidejourney.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.guidejourney.model.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}