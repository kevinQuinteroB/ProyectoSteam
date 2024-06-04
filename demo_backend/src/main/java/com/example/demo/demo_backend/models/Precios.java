package com.example.demo.demo_backend.models;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.util.Date;

@Getter
@Entity
@Table(name = "precios")
@NoArgsConstructor
public class Precios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Setter
    @Column(name = "fecha_inicio")
    private Date fecha_inicio;

    @Setter
    @Column(name = "fecha_final")
    private Date fecha_final;

    @Setter
    @Column(name = "descuento")
    private long descuento;

    @Setter
    @Column(name = "precio")
    private long precio;

    @Setter
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "juego_id")
    private Juegos juego_id;
}
