package com.example.demo.demo_backend.models;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.util.Date;

@Getter
@Entity
@Table(name = "noticias")
@NoArgsConstructor
public class Noticias {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Setter
    @Column(name = "fecha_publicacion")
    private Date fecha_publicacion;

    @Setter
    @Column(name = "titulo")
    private String titulo;

    @Setter
    @Column(name = "descripcion")
    private String descripcion;

    @Setter
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "juego_id")
    private Juegos juego_id;
}
