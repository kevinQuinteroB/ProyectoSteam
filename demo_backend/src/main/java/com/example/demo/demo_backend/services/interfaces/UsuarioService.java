package com.example.demo.demo_backend.services.interfaces;

import com.example.demo.demo_backend.models.Usuarios;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UsuarioService {
    Usuarios findUsuarioByEmail(String email, String contrasena);

    @Transactional
    Usuarios saveUsuario(Usuarios usuario, Long paisId);

    List<Usuarios> findAllUsuarios();
}
