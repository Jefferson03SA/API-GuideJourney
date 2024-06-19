package com.guidejourney.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guidejourney.model.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
