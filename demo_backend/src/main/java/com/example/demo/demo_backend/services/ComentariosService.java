package com.example.demo.demo_backend.services;

import com.example.demo.demo_backend.models.ComentariosJuegos;
import com.example.demo.demo_backend.models.Juegos;
import com.example.demo.demo_backend.models.Usuarios;
import com.example.demo.demo_backend.repository.ComentarioRepository;
import com.example.demo.demo_backend.repository.JuegosRepository;
import com.example.demo.demo_backend.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentariosService {

    @Autowired
    private ComentarioRepository comentarioRepository;
    @Autowired
    private JuegosRepository juegosRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

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

    public List<ComentariosJuegos> obtenerComentariosPorJuegoId(long juegoId) {
        return comentarioRepository.findByJuego_id(juegoId);
    }
}
