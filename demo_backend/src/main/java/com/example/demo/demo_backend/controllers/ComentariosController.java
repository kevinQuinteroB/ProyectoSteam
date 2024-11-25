package com.example.demo.demo_backend.controllers;

import com.example.demo.demo_backend.models.ComentariosJuegos;
import com.example.demo.demo_backend.repository.ComentarioRepository;
import com.example.demo.demo_backend.services.ComentariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comentarios")
@CrossOrigin(origins = "http://localhost:4200")
public class ComentariosController {

    @Autowired
    private ComentarioRepository comentarioRepository;
    @Autowired
    private ComentariosService comentariosService;

    @PostMapping("/crear")
    public ComentariosJuegos crear(@RequestBody Map<String, Object> comentarioData) {
        LocalDate fechaActual = LocalDate.now();
        Date fechaSql = Date.valueOf(fechaActual);

        ComentariosJuegos comentarios = new ComentariosJuegos();
        comentarios.setDescripcion((String) comentarioData.get("descripcion"));
        comentarios.setFecha(fechaSql);

        Long juego_id = Long.valueOf((Integer) comentarioData.get("juego_id"));
        Long usuario_id = Long.valueOf((Integer) comentarioData.get("usuario_id"));
        ComentariosJuegos newComentarios = comentariosService.create(comentarios, juego_id, usuario_id);
        return comentarioRepository.save(newComentarios);
    }

    @GetMapping("/comentarios/{juegoId}")
    public List<ComentariosJuegos> obtenerComentariosPorJuego(@PathVariable long juegoId) {
        return comentariosService.obtenerComentariosPorJuegoId(juegoId);
    }
}
