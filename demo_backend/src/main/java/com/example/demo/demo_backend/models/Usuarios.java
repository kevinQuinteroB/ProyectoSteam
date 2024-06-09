package com.example.demo.demo_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Table(name = "usuarios")
@NoArgsConstructor

public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Setter
    @Column(name="username", nullable = false, unique = true)
    private String username;

    @Setter
    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Setter
    @Column(name="contrasena", nullable = false)
    private String contrasena;

    @Setter
    @Column(name="saldo", nullable = false)
    private double saldo;

    @Setter
    private Long pais_id;
}
