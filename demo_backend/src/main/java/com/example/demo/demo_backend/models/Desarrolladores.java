package com.example.demo.demo_backend.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Entity
@Setter
@Table(name = "desarrolladores")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Desarrolladores {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "fundacion")
    private Date fundacion;

    @Column(name="nombre", nullable = false, unique = true)
    private String nombre;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pais_id", nullable = false, insertable = true ,updatable = true)
    private Paises pais;

    @JsonProperty("pais_id")
    public Long getPaisId() {
        return pais.getId();
    }
}
