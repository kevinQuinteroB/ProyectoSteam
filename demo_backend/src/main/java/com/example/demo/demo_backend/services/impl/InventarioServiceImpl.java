package com.example.demo.demo_backend.services.impl;

import com.example.demo.demo_backend.models.Inventarios;
import com.example.demo.demo_backend.models.Juegos;
import com.example.demo.demo_backend.models.Usuarios;
import com.example.demo.demo_backend.repository.InventariosRepository;
import com.example.demo.demo_backend.repository.JuegosRepository;
import com.example.demo.demo_backend.repository.UsuarioRepository;
import com.example.demo.demo_backend.services.interfaces.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioServiceImpl implements InventarioService {

    private InventariosRepository inventariosRepository;
    private JuegosRepository juegosRepository;
    private UsuarioRepository usuarioRepository;

    @Override
    public Inventarios save(Long juego_id, Long usuario_id) {
        Inventarios inventarios = new Inventarios();
        Juegos juego = juegosRepository.findById(juego_id)
                .orElseThrow(() -> new RuntimeException("Juego no encontrado"));
        inventarios.setJuego(juego);
        Usuarios usuarios = usuarioRepository.findById(usuario_id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        inventarios.setUsuario(usuarios);
        return inventariosRepository.save(inventarios);
    }

    @Override
    public List<Inventarios> findAllByUsuario_id(Long usuario_id) {
        return inventariosRepository.findAllByUsuario_Id(usuario_id);
    }

    @Override
    public Inventarios obtenerInventarioPorJuegoYUsuario(Long juegoId, Long usuarioId) {
        return inventariosRepository.findByJuegoIdAndUsuarioId(juegoId, usuarioId);
    }

    @Autowired
    public void setInventariosRepository(InventariosRepository inventariosRepository) {
        this.inventariosRepository = inventariosRepository;
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
