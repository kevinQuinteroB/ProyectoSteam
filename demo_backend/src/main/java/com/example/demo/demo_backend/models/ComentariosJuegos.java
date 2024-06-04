package com.example.demo.demo_backend.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Entity
@Table(name = "ComentariosJuegos")
@NoArgsConstructor
public class ComentariosJuegos {
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
    private Usuarios usuario_escritor_id;

    @Setter
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "juegos_id")
    private Juegos juegos_id;
}
