package com.guidejourney.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guidejourney.model.entities.StudentProfile;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
    StudentProfile findByUserId(Long userId);
}
