package com.example.demo.demo_backend.services;

import com.example.demo.demo_backend.models.Inventarios;
import com.example.demo.demo_backend.models.Juegos;
import com.example.demo.demo_backend.models.Usuarios;
import com.example.demo.demo_backend.repository.InventariosRepository;
import com.example.demo.demo_backend.repository.JuegosRepository;
import com.example.demo.demo_backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioServices  {
    @Autowired
    private InventariosRepository inventariosRepository;
    @Autowired
    private JuegosRepository juegosRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Inventarios save(Long juego_id, Long usuario_id) {
        Inventarios inventarios = new Inventarios();
        Juegos juego = juegosRepository.findById(juego_id)
                .orElseThrow(() -> new RuntimeException("País no encontrado"));
        inventarios.setJuego(juego);
        Usuarios usuarios = usuarioRepository.findById(usuario_id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        inventarios.setUsuario(usuarios);
        return inventariosRepository.save(inventarios);
    }

    public List<Inventarios> findAllByUsuario_id(Long usuario_id) {
        return inventariosRepository.findAllByUsuario_Id(usuario_id);
    }

    public Inventarios obtenerInventarioPorJuegoYUsuario(Long juegoId, Long usuarioId) {
        return inventariosRepository.findByJuegoIdAndUsuarioId(juegoId, usuarioId);
    }
}
