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
@Table(name="generos")
@NoArgsConstructor
@Setter
public class Generos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="nombre", nullable = false, unique = true)
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JuegosGenero> juegosGeneros = new ArrayList<>();

    public void addJuegoGenero(JuegosGenero juegosGenero) {
        juegosGeneros.add(juegosGenero);
        juegosGenero.setGenero(this);
    }
    public void removeJuegoGenero(JuegosGenero juegosGenero) {
        juegosGeneros.remove(juegosGenero);
        juegosGenero.setGenero(null);
    }
}
