package com.example.demo.demo_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "paises")
@NoArgsConstructor


public class Paises {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Setter
    @Column(name="nombre")
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "pais",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Usuarios> usuarios = new ArrayList<>();

    public void addUsuario(Usuarios usuario) {
        usuarios.add(usuario);
        usuario.setPais(this);
    }
    public void removeUsuario(Usuarios usuario) {
        usuarios.remove(usuario);
        usuario.setPais(null);
    }
}
