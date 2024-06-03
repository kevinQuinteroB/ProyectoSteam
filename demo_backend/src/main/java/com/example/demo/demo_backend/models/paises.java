package com.example.demo.demo_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Entity
@Table(name = "paises")
@NoArgsConstructor

public class paises {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Setter
    @Column(name="pais")
    private String nombre;

    @Setter
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private usuarios usuario_id;
}
