package com.example.demo.demo_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Table(name = "JuegosGenero")
@NoArgsConstructor
@Setter
public class JuegosGenero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Juego_id")
    private Juegos juegos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Genero_id")
    private Generos genero;

}
