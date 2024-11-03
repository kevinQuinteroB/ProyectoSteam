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
@Setter
@Entity
@Table(name = "ComentariosJuegos")
@NoArgsConstructor
public class ComentariosJuegos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="fecha")
    private Date fecha;

    @Column(name = "usuario_escritor_id")
    private Long usuario_escritor_id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "juego_id", updatable = false, insertable = false)
    private Juegos juego;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", updatable = false, insertable = false)
    private Usuarios usuario;
}
