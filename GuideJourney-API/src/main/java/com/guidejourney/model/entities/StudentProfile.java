package com.guidejourney.model.entities;

import jakarta.persistence.*;
import java.util.List;

import com.guidejourney.model.enums.Country;
import com.guidejourney.model.enums.InterestArea;

import lombok.Data;

@Entity
@Data
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Lob
    @Column(name = "profile_picture", columnDefinition = "BYTEA")
    private byte[] profilePicture;

    private String name;

    @Enumerated(EnumType.STRING)
    private Country country;

    private String companyOrSchool;

    @Lob
    @Column(name = "biography", columnDefinition = "TEXT")
    private String biography;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<InterestArea> interestAreas;
}
