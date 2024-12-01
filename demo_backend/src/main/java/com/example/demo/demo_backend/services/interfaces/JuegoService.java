package com.example.demo.demo_backend.services.interfaces;

import com.example.demo.demo_backend.models.Juegos;
import jakarta.transaction.Transactional;

import java.util.List;

public interface JuegoService {
    List<Juegos> searchByName(String keyword);

    @Transactional
    Juegos create(Juegos juegos, Long desarrolladorid);

    List<Juegos> obtenerJuegosPorDesarrollador(Long desarrolladorId);

    @Transactional
    void eliminarJuego(Long id);

    Juegos obtenerJuegoPorId(Long id);
}
