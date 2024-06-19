package com.guidejourney.model.entities;

import jakarta.persistence.*;
import java.util.List;

import com.guidejourney.model.enums.Country;

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
    private byte[] profilePicture; // Preparado para ser utilizado

    private String name;

    @Enumerated(EnumType.STRING)
    private Country country;

    private String companyOrSchool;

    @Lob
    private String biography; // Preparado para ser utilizado

    @ElementCollection
    private List<String> interestAreas; // Preparado pero no utilizado en esta rama
}