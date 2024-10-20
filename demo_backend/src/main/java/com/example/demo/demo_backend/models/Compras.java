package com.example.demo.demo_backend.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Compras")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Compras {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "compra", cascade = CascadeType.ALL)
    private Inventarios inventario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "juego_id", nullable = false)
    private Juegos juego;

}
