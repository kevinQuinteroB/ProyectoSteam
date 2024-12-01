package com.example.demo.demo_backend.services.interfaces;

import com.example.demo.demo_backend.models.Inventarios;

import java.util.List;

public interface InventarioService {
    Inventarios save(Long juego_id, Long usuario_id);

    List<Inventarios> findAllByUsuario_id(Long usuario_id);

    Inventarios obtenerInventarioPorJuegoYUsuario(Long juegoId, Long usuarioId);
}
