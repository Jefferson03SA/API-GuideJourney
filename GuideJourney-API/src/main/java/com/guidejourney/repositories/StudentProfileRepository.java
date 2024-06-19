package com.guidejourney.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guidejourney.model.entities.StudentProfile;
import com.guidejourney.model.entities.User;

import java.util.Optional;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
    Optional<StudentProfile> findByUser(User user);
}
