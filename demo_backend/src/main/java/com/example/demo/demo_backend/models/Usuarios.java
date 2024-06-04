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
    @Column(name="username")
    private String username;

    @Setter
    @Column(name="email")
    private String email;

    @Setter
    @Column(name="contrasena")
    private String contrasena;

    @Setter
    @Column(name="saldo")
    private double saldo;

    @Setter
    @Column(name="activo")
    private boolean activo;

    @Setter
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "pais_id")
    private Paises pais_id;
}
