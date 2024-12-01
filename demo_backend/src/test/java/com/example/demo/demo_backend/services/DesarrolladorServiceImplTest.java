package com.example.demo.demo_backend.services;

import com.example.demo.demo_backend.models.Desarrolladores;
import com.example.demo.demo_backend.models.Paises;
import com.example.demo.demo_backend.repository.DesarrolladoresRepository;
import com.example.demo.demo_backend.repository.PaisesRepository;
import com.example.demo.demo_backend.services.impl.DesarrolladorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DesarrolladorServiceImplTest {

    @Mock
    private DesarrolladoresRepository desarrolladoresRepository;

    @Mock
    private PaisesRepository paisesRepository;

    @InjectMocks
    private DesarrolladorServiceImpl desarrolladoresService;

    private Paises pais;
    private Desarrolladores desarrollador;

    @BeforeEach
    void setUp(){
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
                .fundacion(new Date(2024, 01, 02))
                .pais(pais)
                .build();
    }

    @Test
    @Tag("Crear un nuevo desarrollador con todos los parametros")
    void saveDesarrollador() {
        Long idPais = pais.getId();

        when(paisesRepository.findById(idPais)).thenReturn(Optional.of(pais));
        when(desarrolladoresRepository.save(any(Desarrolladores.class))).thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        var result = desarrolladoresService.saveDesarrollador(desarrollador, idPais);

        assertNotNull(result);
        assertEquals(desarrollador, result);
        assertEquals(pais.getNombre(), result.getPais().getNombre());
        verify(desarrolladoresRepository).save(any(Desarrolladores.class));
    }

    @Test
    @Tag("Crear desarrollador cuando no existe el pais")
    void createDesarrolladorWhenCountryDoesNotExist() {
        Long idPais = pais.getId();

        when(paisesRepository.findById(idPais)).thenReturn(Optional.empty());

        var exception = assertThrows(RuntimeException.class, ()->desarrolladoresService.saveDesarrollador(desarrollador, idPais));

        assertEquals("País no encontrado", exception.getMessage());
    }

    @Test
    @Tag("Buscar desarrollador por email y contraseña")
    void findByEmailAndContrasena() {
        String email = "dev@example.com";
        String password = "password1234";

        when(desarrolladoresRepository.findByEmailAndContrasena(email, password)).thenReturn(desarrollador);
        var result = desarrolladoresService.findByEmailAndContrasena(email, password);

        assertNotNull(result);
        assertEquals(email, result.getEmail());
        assertEquals(password, result.getContrasena());
    }

    @Test
    @Tag("Buscar desarrollador por email y contraseña cuando alguno de los datos es incorrecto")
    void findByEmailAndContrasenaWhenParamsAreIncorect() {
        String email = "de@example.com";
        String password = "password1234";

        var result = desarrolladoresService.findByEmailAndContrasena(email, password);

        assertNull(result);
    }

    @Test
    void findById() {
        Long idDesarrollador = desarrollador.getId();

        when(desarrolladoresRepository.findById(idDesarrollador)).thenReturn(Optional.of(desarrollador));
        var result = desarrolladoresService.findById(idDesarrollador);
        assertNotNull(result);
        assertEquals(Optional.of(desarrollador), result);

    }
}