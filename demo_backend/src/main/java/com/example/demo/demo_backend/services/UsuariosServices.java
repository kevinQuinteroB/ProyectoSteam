package com.example.demo.demo_backend.services;


import com.example.demo.demo_backend.models.Usuarios;
import com.example.demo.demo_backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServices {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuarios findUsuarioByEmail(String email, String contrasena) {
        return usuarioRepository.findByEmail(email, contrasena);
    }

    public Usuarios saveUsuario(Usuarios usuario) {
        return usuarioRepository.save(usuario);
    }
}

