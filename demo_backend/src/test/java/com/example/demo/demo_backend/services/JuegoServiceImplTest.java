package com.example.demo.demo_backend.services;

import com.example.demo.demo_backend.models.Desarrolladores;
import com.example.demo.demo_backend.models.Juegos;
import com.example.demo.demo_backend.models.Paises;
import com.example.demo.demo_backend.repository.DesarrolladoresRepository;
import com.example.demo.demo_backend.repository.JuegosRepository;
import com.example.demo.demo_backend.services.impl.JuegoServiceImpl;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JuegoServiceImplTest {

    @Mock
    private JuegosRepository juegosRepository;
    @Mock
    private DesarrolladoresRepository desarrolladoresRepository;
    @InjectMocks
    private JuegoServiceImpl juegosService;

    private Desarrolladores desarrollador;
    private Juegos juego;
    private Juegos juego2;

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

        juego2 = Juegos.builder()
                .id(1L)
                .nombre("Juego Prueba2")
                .fecha_lanzamiento(new Date())
                .portada("portada2.jpg")
                .descripcion("descripcion2")
                .link("http://ejemplo2.com")
                .desarrollador(desarrollador)
                .build();
    }

    @Test
    @Tag("Buscar juego por nombre")
    void searchByName() {
        String keyword = "Jue";

        when(juegosRepository.searchByName(keyword)).thenReturn(List.of(juego, juego2));
        var result = juegosService.searchByName(keyword);

        assertNotNull(result);
        assertEquals(List.of(juego, juego2), result);
        assertEquals(2, result.size());
    }

    @Test
    @Tag("Crear juego con todos los parametros")
    void create() {
        Long idDesarrollador = 1L;

        when(desarrolladoresRepository.findById(idDesarrollador)).thenReturn(Optional.of(desarrollador));
        when(juegosRepository.save(juego)).thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        var result = juegosService.create(juego, idDesarrollador);
        assertNotNull(result);
        assertEquals(juego, result);
    }

    @Test
    @Tag("Crear juego con todos los parametros")
    void createGameWhenDevelopDoesNotExists() {
        Long idDesarrollador = 1L;

        when(desarrolladoresRepository.findById(idDesarrollador)).thenReturn(Optional.empty());
        var exception = assertThrows(RuntimeException.class, () -> juegosService.create(juego, idDesarrollador));

        assertEquals("No existe el desarrollador", exception.getMessage());
    }

    @Test
    void obtenerJuegosPorDesarrollador() {
        Long idDesarrollador = 1L;

        when(juegosRepository.findByDesarrollador_Id(idDesarrollador)).thenReturn(List.of(juego, juego2));

        var result = juegosService.obtenerJuegosPorDesarrollador(idDesarrollador);
        assertNotNull(result);
        assertEquals(List.of(juego, juego2), result);
    }

    @Test
    @Tag("Eliminar un juego por id")
    void eliminarJuego() {
        Long idJuego = 1L;
        juegosService.eliminarJuego(idJuego);
        verify(juegosRepository).deleteById(idJuego);
    }

    @Test
    @Tag("Obtener juego por id")
    void obtenerJuegoPorId() {
        Long idJuego = 1L;

        when(juegosRepository.findById(idJuego)).thenReturn(Optional.of(juego));
        var result = juegosService.obtenerJuegoPorId(idJuego);

        assertEquals(juego, result);
    }
}