package com.example.demo.demo_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Table(name="generos_juegos")
@NoArgsConstructor
public class GenerosJuegos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Setter
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "juego_id")
    private Juegos juego_id;

    @Setter
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "genero_id")
    private Generos genero_id;
}
