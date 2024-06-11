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
    @Column(name="nombre", nullable = false, unique = true)
    private String nombre;

    @Setter
    @Column(name="fecha_lanzamiento", nullable = false)
    private Date fecha_lanzamiento;

    @Setter
    @Column(name="portada", nullable = false, unique = true)
    private String portada;

    @Setter
    @Column(name="valoracion")
    private long valoracion;

    @Setter
    @Column(name = "desarrollador_id")
    private Long desarrollador_id;

    @Setter
    @Column(name = "descuento")
    private long descuento;

    @Setter
    @Column(name = "precio", nullable = false)
    private long precio;

    @Setter
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
}
