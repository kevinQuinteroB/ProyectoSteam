package com.example.demo.demo_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="username", nullable = false, unique = true)
    private String username;

    @Column(name = "primerNombre", nullable = false)
    private String primerNombre;

    @Column(name = "primerApellido", nullable = false)
    private String primerApellido;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="contrasena", nullable = false)
    private String contrasena;

    @Column(name = "telefono")
    private int telefono;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pais_id",nullable = false ,insertable = true ,updatable = true)
    private Paises pais;

}
