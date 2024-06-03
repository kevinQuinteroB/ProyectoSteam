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

public class amigos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Setter
    @Column(name="fecha")
    private Date fecha;

    @Setter
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "usuario_id1")
    private usuarios usuario_id1;

    @Setter
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "usuario_id2")
    private usuarios usuario_id2;
}
