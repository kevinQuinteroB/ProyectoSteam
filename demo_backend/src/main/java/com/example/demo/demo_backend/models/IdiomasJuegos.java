package com.example.demo.demo_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Setter
@Table(name = "IdiomasJuegos")
@NoArgsConstructor
public class IdiomasJuegos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "juego_id")
    private Juegos juegos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idioma_id")
    private Idiomas  idioma;
}
