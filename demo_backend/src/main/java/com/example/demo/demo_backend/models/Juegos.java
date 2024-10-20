package com.example.demo.demo_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Entity
@Table(name = "juegos")
@NoArgsConstructor
public class Juegos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Setter
    @Column(name="nombre", nullable = false, unique = true)
    private String nombre;

    @Setter
    @Column(name="fecha_lanzamiento", nullable = false)
    private Date fecha_lanzamiento;

    @Setter
    @Column(name="portada", nullable = false, unique = true)
    private String portada;

    @Setter
    @Column(name="valoracion")
    private long valoracion;

    @Setter
    @Column(name = "descuento")
    private long descuento;

    @Setter
    @Column(name = "precio", nullable = false)
    private long precio;

    @Setter
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @JsonIgnore
    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Compras> compras = new ArrayList<>();

    public void addCompras(Compras compra) {
        compras.add(compra);
        compra.setJuego(this);
    }
    public void removeCompras(Compras compra) {
        compras.remove(compra);
        compra.setJuego(null);
    }

    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="desarrollador", nullable = false)
    private Desarrolladores desarrollador;

    @JsonIgnore
    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComentariosJuegos> comentarios = new ArrayList<>();

    public void addComentario(ComentariosJuegos comentario) {
        comentarios.add(comentario);
        comentario.setJuego(this);
    }

    public void removeComentario(ComentariosJuegos comentario) {
        comentarios.remove(comentario);
        comentario.setJuego(null);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "juegos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Noticias> noticias = new ArrayList<>();

    public void addNoticia(Noticias noticia) {
        noticias.add(noticia);
        noticia.setJuegos(this);
    }
    public void removeNoticia(Noticias noticia) {
        noticias.remove(noticia);
        noticia.setJuegos(null);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "juegos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IdiomasJuegos> idiomasJuegos = new ArrayList<>();

    public void addIdiomaJuego(IdiomasJuegos idiomasJuego) {
        idiomasJuegos.add(idiomasJuego);
        idiomasJuego.setJuegos(this);
    }
    public void removeIdiomaJuego(IdiomasJuegos idiomasJuego) {
        idiomasJuegos.remove(idiomasJuego);
        idiomasJuego.setJuegos(null);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "juegos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JuegosGenero> juegosGeneros = new ArrayList<>();

    public void addJuegoGenero(JuegosGenero juegosGenero) {
        juegosGeneros.add(juegosGenero);
        juegosGenero.setJuegos(this);
    }
    public void removeJuegoGenero(JuegosGenero juegosGenero) {
        juegosGeneros.remove(juegosGenero);
        juegosGenero.setJuegos(null);
    }
}
