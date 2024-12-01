package com.example.demo.demo_backend.services.impl;


import com.example.demo.demo_backend.models.Paises;
import com.example.demo.demo_backend.models.Usuarios;
import com.example.demo.demo_backend.repository.PaisesRepository;
import com.example.demo.demo_backend.repository.UsuarioRepository;
import com.example.demo.demo_backend.services.interfaces.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;
    private PaisesRepository paisesRepository;

    @Override
    public Usuarios findUsuarioByEmail(String email, String contrasena) {
        return usuarioRepository.findByEmail(email, contrasena);
    }

    @Transactional
    @Override
    public Usuarios saveUsuario(Usuarios usuario, Long paisId) {
        Paises pais = paisesRepository.findById(paisId)
                .orElseThrow(() -> new RuntimeException("País no encontrado"));
        usuario.setPais(pais);
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuarios> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Autowired
    public void setPaisesRepository(PaisesRepository paisesRepository) {
        this.paisesRepository = paisesRepository;
    }
}

