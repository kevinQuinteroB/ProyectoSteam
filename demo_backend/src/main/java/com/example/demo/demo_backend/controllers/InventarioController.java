package com.example.demo.demo_backend.controllers;

import com.example.demo.demo_backend.models.Inventarios;
import com.example.demo.demo_backend.services.InventarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/inventario")
@CrossOrigin(origins = "http://localhost:4200")
public class InventarioController {

    @Autowired
    private InventarioServices inventarioServices;

    @PostMapping("/crear")
    public Inventarios compra(@RequestBody Map<String, Object> inventario) {
        Long juego_id = Long.valueOf((Integer) inventario.get("juego_id"));
        Long usuario_id = Long.valueOf((Integer) inventario.get("usuario_id"));
        return inventarioServices.save(juego_id, usuario_id);
    }

    @GetMapping("usuario/{id}")
    public List<Inventarios> obtenerUsuario(@PathVariable Long id){
        return inventarioServices.findAllByUsuario_id(id);
    }

    @GetMapping("/inventarios/{juegoId}/{usuarioId}")
    public Inventarios obtenerInventario(@PathVariable Long juegoId, @PathVariable Long usuarioId) {
        return inventarioServices.obtenerInventarioPorJuegoYUsuario(juegoId, usuarioId);
    }
}
