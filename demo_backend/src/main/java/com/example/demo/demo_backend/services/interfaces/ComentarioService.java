package com.example.demo.demo_backend.services.interfaces;

import com.example.demo.demo_backend.models.ComentariosJuegos;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ComentarioService {
    @Transactional
    ComentariosJuegos create(ComentariosJuegos comentarios, Long juego_id, Long usuario_id);

    List<ComentariosJuegos> obtenerComentariosPorJuegoId(long juegoId);
}
