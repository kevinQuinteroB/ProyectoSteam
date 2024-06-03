package com.example.demo.demo_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Entity
@Table(name = "ciudades")
@NoArgsConstructor

public class ciudades {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Setter
    @Column(name="ciudad")
    private int ciudad;

    @Setter
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "pais_id")
    private paises pais_id;
}
