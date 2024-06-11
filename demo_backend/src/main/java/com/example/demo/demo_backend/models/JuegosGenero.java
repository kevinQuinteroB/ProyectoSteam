package com.example.demo.demo_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Table(name = "JuegosGenero")
@NoArgsConstructor
public class JuegosGenero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Setter
    @JoinColumn(name = "id_Juego")
    private long  id_Juego;

    @Setter
    @JoinColumn(name = "id_Genero")
    private long  id_Genero;
}
