package com.example.demo.demo_backend.services.impl;

import com.example.demo.demo_backend.models.ComentariosJuegos;
import com.example.demo.demo_backend.models.Juegos;
import com.example.demo.demo_backend.models.Usuarios;
import com.example.demo.demo_backend.repository.ComentarioRepository;
import com.example.demo.demo_backend.repository.JuegosRepository;
import com.example.demo.demo_backend.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServiceImpl implements com.example.demo.demo_backend.services.interfaces.ComentarioService {

    private ComentarioRepository comentarioRepository;
    private JuegosRepository juegosRepository;
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public ComentariosJuegos create(ComentariosJuegos comentarios, Long juego_id, Long usuario_id) {
        Juegos juego = juegosRepository.findById(juego_id)
                .orElseThrow(() -> new RuntimeException("No existe el Juego"));
        comentarios.setJuego(juego);
        Usuarios usuarios = usuarioRepository.findById(usuario_id)
                .orElseThrow(() -> new RuntimeException("No existe el Usuario"));
        comentarios.setUsuario(usuarios);
        return comentarioRepository.save(comentarios);
    }

    @Override
    public List<ComentariosJuegos> obtenerComentariosPorJuegoId(long juegoId) {
        return comentarioRepository.findByJuego_id(juegoId);
    }

    @Autowired
    public void setComentarioRepository(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    @Autowired
    public void setJuegosRepository(JuegosRepository juegosRepository) {
        this.juegosRepository = juegosRepository;
    }

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
}
