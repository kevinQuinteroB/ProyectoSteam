package com.example.demo.demo_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Entity
@Table(name = "juegos")
@NoArgsConstructor
public class Juegos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Setter
    @Column(name="nombre")
    private String nombre;

    @Setter
    @Column(name="fecha_lanzamiento")
    private Date fecha_lanzamiento;

    @Setter
    @Column(name="valoracion")
    private long valoracion;

    @Setter
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "desarrollador_id")
    private Desarrolladores desarrollador_id;
}
