package com.example.demo.demo_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Table(name = "idiomas")
@NoArgsConstructor
public class Idiomas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Setter
    @Column(name = "idioma")
    private String idioma;
}
