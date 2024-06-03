package com.example.demo.demo_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Entity
@Table(name = "comentarios_usuarios")
@NoArgsConstructor
public class comentarios_usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Setter
    @Column(name="descripcion")
    private String descripcion;

    @Setter
    @Column(name="fecha")
    private Date fecha;

    @Setter
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "usuario_escritor_id")
    private usuarios usuario_escritor_id;

    @Setter
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "usuario_receptor_id")
    private usuarios usuario_receptor_id;
}
