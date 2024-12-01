package com.example.demo.demo_backend.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ComentariosJuegos")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class ComentariosJuegos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="fecha")
    private Date fecha;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "juego_id")
    private Juegos juego;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    @JsonProperty("juego_id")
    public Long getJuegoId() {
        return juego.getId();
    }

    @JsonProperty("usuario_id")
    public Long getUsuarioId() {
        return usuario.getId();
    }

    public String getUsuarioNombre() {
        return this.usuario.getUsername();  // Devuelve el nombre del usuario
    }
}
