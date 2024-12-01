package com.example.demo.demo_backend.services;

import com.example.demo.demo_backend.models.*;
import com.example.demo.demo_backend.repository.InventariosRepository;
import com.example.demo.demo_backend.repository.JuegosRepository;
import com.example.demo.demo_backend.repository.UsuarioRepository;
import com.example.demo.demo_backend.services.impl.InventarioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InventarioServiceImplTest {

    @InjectMocks
    private InventarioServiceImpl inventarioServiceImpl;
    @Mock
    private InventariosRepository inventariosRepository;
    @Mock
    private JuegosRepository juegosRepository;
    @Mock
    private UsuarioRepository usuarioRepository;

    private Juegos juego;
    private Inventarios inventario;
    private Usuarios usuario;
    private Desarrolladores desarrollador;

    @BeforeEach
    void setUp() {
        Paises pais = Paises.builder()
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

        inventario = Inventarios.builder()
                .juego(juego)
                .usuario(usuario)
                .build();
    }

    @Test
    @Tag("Crear inventario con todos los parametros")
    void save() {
        Long idUsuario = usuario.getId();
        Long idJuego = juego.getId();

        when(juegosRepository.findById(idJuego)).thenReturn(Optional.of(juego));
        when(usuarioRepository.findById(idUsuario)).thenReturn(Optional.of(usuario));
        when(inventariosRepository.save(any(Inventarios.class))).thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        var result = inventarioServiceImpl.save(idJuego, idUsuario);
        assertNotNull(result);
        assertEquals(inventario, result);
        verify(inventariosRepository).save(any(Inventarios.class));
    }

    @Test
    @Tag("Crear inventario cuando no existe juego")
    void createInventoryWhenGameDoesNotExists() {
        Long idUsuario = usuario.getId();
        Long idJuego = juego.getId();

        when(juegosRepository.findById(idJuego)).thenReturn(Optional.empty());

        var exception = assertThrows(RuntimeException.class, ()-> inventarioServiceImpl.save(idJuego, idUsuario));

        assertEquals("Juego no encontrado", exception.getMessage());
    }

    @Test
    @Tag("Crear inventario cuando no existe usuario")
    void createInventoryWhenUserDoesNotExists() {
        Long idUsuario = usuario.getId();
        Long idJuego = juego.getId();

        when(juegosRepository.findById(idJuego)).thenReturn(Optional.of(juego));
        when(usuarioRepository.findById(idUsuario)).thenReturn(Optional.empty());

        var exception = assertThrows(RuntimeException.class, ()-> inventarioServiceImpl.save(idJuego, idUsuario));

        assertEquals("Usuario no encontrado", exception.getMessage());
    }

    @Test
    @Tag("Encontrar inventario por usuario")
    void findAllByUsuario_id() {
        Long idUsuario = usuario.getId();
        when(inventariosRepository.findAllByUsuario_Id(idUsuario)).thenReturn(List.of(inventario));

        var result = inventarioServiceImpl.findAllByUsuario_id(idUsuario);

        assertNotNull(result);
        assertEquals(List.of(inventario), result);
        assertEquals(1, result.size());

    }

    @Test
    @Tag("Obtener inventario por usuario y juego")
    void obtenerInventarioPorJuegoYUsuario() {
        Long idJuego = juego.getId();
        Long idUsuario = usuario.getId();

        when(inventariosRepository.findByJuegoIdAndUsuarioId(idJuego, idUsuario)).thenReturn(inventario);
        var result = inventarioServiceImpl.obtenerInventarioPorJuegoYUsuario(idJuego, idUsuario);
        assertNotNull(result);
        assertEquals(inventario, result);

    }
}