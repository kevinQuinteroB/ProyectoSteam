package com.example.demo.demo_backend.services;

import com.example.demo.demo_backend.models.*;
import com.example.demo.demo_backend.repository.ComentarioRepository;
import com.example.demo.demo_backend.repository.JuegosRepository;
import com.example.demo.demo_backend.repository.UsuarioRepository;
import com.example.demo.demo_backend.services.impl.ComentarioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ComentarioServiceImplTest {

    @Mock
    private ComentarioRepository comentarioRepository;
    @Mock private JuegosRepository juegosRepository;
    @Mock private UsuarioRepository usuarioRepository;
    @InjectMocks
    private ComentarioServiceImpl comentarioServiceImpl;

    private Juegos juego;
    private Desarrolladores desarrollador;
    private Paises pais;
    private Usuarios usuario;
    private ComentariosJuegos comentario;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        // Crear instancias de los objetos
        pais = Paises.builder()
                .id(1L)
                .nombre("Colombia")
                .build();

        desarrollador = Desarrolladores.builder()
                .id(1L)
                .nombre("Desarrollador")
                .email("dev@example.com")
                .contrasena("password1234")
                .direccion("Carrera 25 # 45-22 Bucaramanga")
                .fundacion(new Date())
                .pais(pais)
                .build();

        juego = Juegos.builder()
                .id(1L)
                .nombre("Juego Prueba")
                .fecha_lanzamiento(new Date())
                .portada("portada.jpg")
                .descripcion("descripcion")
                .link("http://ejemplo.com")
                .desarrollador(desarrollador)
                .build();

        usuario = Usuarios.builder()
                .id(1L)
                .username("Andres25")
                .primerNombre("Andres")
                .primerApellido("Peres")
                .email("andres25@gmail.com")
                .contrasena("password1234")
                .pais(pais)
                .build();

        comentario = ComentariosJuegos.builder()
                .id(1L)
                .descripcion("Buen juego")
                .juego(juego)
                .usuario(usuario)
                .fecha(new Date(2024, 01, 02))
                .build();
    }

    @Test
    @Tag("Crear comentario cuando todos los parametros son diferentes de nulo")
    void create() {
        Long idUsuario = usuario.getId();
        Long idJuego = juego.getId();

        ComentariosJuegos comentariosJuegos = new ComentariosJuegos();
        comentariosJuegos.setId(1L);
        comentariosJuegos.setDescripcion("Buen juego");
        comentariosJuegos.setFecha(new Date(2024, 01, 02));

        when(juegosRepository.findById(idJuego)).thenReturn(Optional.of(juego));
        when(usuarioRepository.findById(idUsuario)).thenReturn(Optional.of(usuario));
        when(comentarioRepository.save(any(ComentariosJuegos.class))).thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        var result = comentarioServiceImpl.create(comentariosJuegos, idJuego, idUsuario);

        assertNotNull(result);
        assertEquals(juego, result.getJuego());
        assertEquals(usuario, result.getUsuario());
        verify(juegosRepository).findById(idJuego);
        verify(usuarioRepository).findById(idUsuario);
        verify(comentarioRepository).save(any(ComentariosJuegos.class));
        assertEquals(comentario, result);
    }

    @Test
    @Tag("Crear comentario cuando no existe juego")
    void createCommentWhenGameDoesNotExists(){
        Long idUsuario = usuario.getId();
        Long idJuego = juego.getId();

        when(juegosRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        var e = assertThrows(RuntimeException.class, () -> comentarioServiceImpl.create(comentario, idJuego, idUsuario));
        assertEquals("No existe el Juego", e.getMessage());
    }

    @Test
    @Tag("Crear comentario cuando no existe usuario")
    void createCommentWhenUserDoesNotExists(){
        Long idUsuario = usuario.getId();
        Long idJuego = juego.getId();

        when(juegosRepository.findById(idJuego)).thenReturn(Optional.of(juego));
        when(usuarioRepository.findById(idUsuario)).thenReturn(Optional.empty());


        var e = assertThrows(RuntimeException.class, () -> comentarioServiceImpl.create(comentario, idJuego, idUsuario));
        assertEquals("No existe el Usuario", e.getMessage());
    }

    @Test
    @Tag("Obtener comentarios segun el juego")
    void obtenerComentariosPorJuegoId() {
        Long idJuego = 1L;

        when(comentarioRepository.findByJuego_id(idJuego)).thenReturn(List.of(comentario));

        var result = comentarioServiceImpl.obtenerComentariosPorJuegoId(idJuego);

        assertNotNull(result);
        assertEquals(1, result.size());
    }
}