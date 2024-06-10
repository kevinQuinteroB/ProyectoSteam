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
    @Column(name = "usuario_escritor_id")
    private Long usuario_escritor_id;

    @Setter
    @Column(name = "juegos_id")
    private Long juegos_id;


}
