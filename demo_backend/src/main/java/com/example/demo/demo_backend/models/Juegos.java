package com.example.demo.demo_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @Column(name="link", nullable = false, unique = true)
    private String link;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="desarrollador", nullable = false)
    private Desarrolladores desarrollador;

    @JsonProperty("desarrollador")
    public Long getDesarrolladorId() {
        return desarrollador.getId();
    }
}
