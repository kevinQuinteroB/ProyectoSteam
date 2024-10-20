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
@Table(name = "desarrolladores")
@NoArgsConstructor
public class Desarrolladores {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Setter
    @Column(name="nombre", nullable = false, unique = true)
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "desarrollador",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Juegos> juegos = new ArrayList<>();
    public void addJuego(Juegos juego) {
        juegos.add(juego);
        juego.setDesarrollador(this);
    }
    public void removeUsuario(Juegos juego) {
        juegos.remove(juego);
        juego.setDesarrollador(null);
    }
}
