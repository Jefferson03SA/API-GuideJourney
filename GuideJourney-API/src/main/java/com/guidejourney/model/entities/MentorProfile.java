package com.guidejourney.model.entities;

import java.util.List;

import com.guidejourney.model.enums.Country;
import com.guidejourney.model.enums.InterestArea;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MentorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "profile_picture", columnDefinition = "BYTEA")
    private byte[] profilePicture;

    private String name;

    @Enumerated(EnumType.STRING)
    private Country country;

    private String company;

    private int yearsOfExperience;

    @Lob
    @Column(name = "biography", columnDefinition = "TEXT")
    private String biography;

    private String linkedinLink; 


    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<InterestArea> interestAreas; 
}