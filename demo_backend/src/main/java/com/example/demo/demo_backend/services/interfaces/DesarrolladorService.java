package com.example.demo.demo_backend.services.interfaces;

import com.example.demo.demo_backend.models.Desarrolladores;
import jakarta.transaction.Transactional;

import java.util.Optional;

public interface DesarrolladorService {
    @Transactional
    Desarrolladores saveDesarrollador(Desarrolladores desarrollador, Long paisId);

    Desarrolladores findByEmailAndContrasena(String email, String contrasena);

    Optional<Desarrolladores> findById(Long id);
}
