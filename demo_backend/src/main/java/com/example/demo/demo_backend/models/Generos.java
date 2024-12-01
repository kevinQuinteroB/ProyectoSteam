package com.example.demo.demo_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name="generos")
@NoArgsConstructor
@Setter
@AllArgsConstructor
@Builder
public class Generos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="nombre", nullable = false, unique = true)
    private String nombre;

}
