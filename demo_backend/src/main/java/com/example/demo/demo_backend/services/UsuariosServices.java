package com.example.demo.demo_backend.services;


import com.example.demo.demo_backend.models.Paises;
import com.example.demo.demo_backend.models.Usuarios;
import com.example.demo.demo_backend.repository.PaisesRepository;
import com.example.demo.demo_backend.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServices {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PaisesRepository paisesRepository;

    public Usuarios findUsuarioByEmail(String email, String contrasena) {
        return usuarioRepository.findByEmail(email, contrasena);
    }

    @Transactional
    public Usuarios saveUsuario(Usuarios usuario, Long paisId) {
        Paises pais = paisesRepository.findById(paisId)
                .orElseThrow(() -> new RuntimeException("País no encontrado"));
        usuario.setPais(pais);
        return usuarioRepository.save(usuario);
    }

    public List<Usuarios> findAllUsuarios() {
        return usuarioRepository.findAll();
    }
}

