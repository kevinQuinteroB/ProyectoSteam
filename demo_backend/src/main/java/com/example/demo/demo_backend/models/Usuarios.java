package com.example.demo.demo_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="username", nullable = false, unique = true)
    private String username;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="contrasena", nullable = false)
    private String contrasena;

    @Column(name="saldo", nullable = false)
    private double saldo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="pais_id", nullable = false)
    private Paises pais;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventario_id", referencedColumnName = "id")
    private Inventarios inventario;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComentariosJuegos> comentarios = new ArrayList<>();

    public void addComentario(ComentariosJuegos comentario) {
        comentarios.add(comentario);
        comentario.setUsuario(this);
    }

    public void removeComentario(ComentariosJuegos comentario) {
        comentarios.remove(comentario);
        comentario.setUsuario(null);
    }
}
