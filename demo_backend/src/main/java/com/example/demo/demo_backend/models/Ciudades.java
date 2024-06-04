package com.example.demo.demo_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Table(name = "ciudades")
@NoArgsConstructor

public class Ciudades {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Setter
    @Column(name="ciudad")
    private long ciudad;

    @Setter
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "pais_id")
    private Paises pais_id;
}
