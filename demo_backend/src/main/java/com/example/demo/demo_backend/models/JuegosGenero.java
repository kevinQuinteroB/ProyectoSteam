package com.example.demo.demo_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Juego_id", nullable = false, updatable = false, insertable = false)
    private Juegos juegos;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Genero_id", nullable = false, updatable = false, insertable = false)
    private Generos genero;

}
