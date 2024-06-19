package com.guidejourney.model.entities;
import com.guidejourney.model.enums.Role;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
