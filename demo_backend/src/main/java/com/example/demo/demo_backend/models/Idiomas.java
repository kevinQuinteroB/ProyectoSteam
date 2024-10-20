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
@Table(name = "idiomas")
@NoArgsConstructor
@Setter
public class Idiomas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "idioma")
    private String idioma;

    @JsonIgnore
    @OneToMany(mappedBy = "idioma", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IdiomasJuegos> idiomasJuegos = new ArrayList<>();

    public void addIdiomaJuego(IdiomasJuegos idiomasJuego) {
        idiomasJuegos.add(idiomasJuego);
        idiomasJuego.setIdioma(this);
    }
    public void removeIdiomaJuego(IdiomasJuegos idiomasJuego) {
        idiomasJuegos.remove(idiomasJuego);
        idiomasJuego.setIdioma(null);
    }
}
