package com.example.demo.demo_backend.services;

import com.example.demo.demo_backend.models.Generos;
import com.example.demo.demo_backend.repository.GenerosRepository;
import com.example.demo.demo_backend.services.impl.GeneroServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GeneroServiceTest {

    @InjectMocks
    private GeneroServiceImpl generosService;
    @Mock
    private GenerosRepository generosRepository;

    private Generos genero;

    @BeforeEach
    void setUp() {
        genero = Generos.builder()
                .id(1L)
                .nombre("Ficcion")
                .build();
    }

    @Test
    @Tag("Devolver todos los generos disponibles")
    void returnAll() {
        Generos genero1 = Generos.builder().id(1L).nombre("Acción").build();
        Generos genero2 = Generos.builder().id(2L).nombre("Aventura").build();
        List<Generos> generos = List.of(genero1, genero2);

        when(generosRepository.findAll()).thenReturn(generos);
        var result = generosService.retunall();

        assertNotNull(result);
        assertEquals(generos, result);
        assertEquals(2, result.size());
    }


    @Test
    @Tag("Encontrar genero por id")
    void encontrarByID() {
        Long idGenero = 1L;

        when(generosRepository.EncontrarByID(idGenero)).thenReturn(genero);
        var result = generosService.encontrarByID(idGenero);

        assertNotNull(result);
        assertEquals(genero, result);
    }
}