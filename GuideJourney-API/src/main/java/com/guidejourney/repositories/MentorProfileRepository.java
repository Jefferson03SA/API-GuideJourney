package com.guidejourney.repositories;

import com.guidejourney.model.entities.MentorProfile;
import com.guidejourney.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MentorProfileRepository extends JpaRepository<MentorProfile, Long> {
    Optional<MentorProfile> findByUser(User user);
}
