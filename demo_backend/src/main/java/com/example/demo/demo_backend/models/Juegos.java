package com.example.demo.demo_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Entity
@Setter
@Table(name = "juegos")
@NoArgsConstructor
public class Juegos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="nombre", nullable = false, unique = true)
    private String nombre;

    @Column(name="fecha_lanzamiento", nullable = false)
    private Date fecha_lanzamiento;

    @Column(name="portada", nullable = false, unique = true)
    private String portada;

    @Column(name="valoracion")
    private long valoracion;

    @Column(name = "descuento")
    private long descuento;

    @Column(name = "precio", nullable = false)
    private long precio;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="desarrollador", nullable = false, updatable = false, insertable = false)
    private Desarrolladores desarrollador;

}
