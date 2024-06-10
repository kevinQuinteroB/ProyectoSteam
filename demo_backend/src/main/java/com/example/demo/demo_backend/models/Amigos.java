package com.example.demo.demo_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Entity
@Table(name = "amigos")
@NoArgsConstructor

public class Amigos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Setter
    @Column(name="fecha", nullable = false)
    private Date fecha;

    @Setter
    @Column(name = "usuario_id1")
    private Long usuario_id1;

    @Setter
    @Column(name = "usuario_id2")
    private Long usuario_id2;


}
