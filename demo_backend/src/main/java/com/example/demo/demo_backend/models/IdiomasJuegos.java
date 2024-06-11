package com.example.demo.demo_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Table(name = "IdiomasJuegos")
@NoArgsConstructor
public class IdiomasJuegos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Setter
    @JoinColumn(name = "id_Juego")
    private long  id_Juego;

    @Setter
    @JoinColumn(name = "id_idioma")
    private long  id_idioma;
}
