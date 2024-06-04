package com.example.demo.demo_backend.models;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Getter
@Entity
@Table(name = "idiomas_juegos")
@NoArgsConstructor
public class IdiomasJuegos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Setter
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "idioma_id")
    private Idiomas idioma_id;

    @Setter
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "juego_id")
    private Juegos juego_id;
}
