package com.example.demo.demo_backend.controllers;

import com.example.demo.demo_backend.models.Juegos;
import com.example.demo.demo_backend.services.impl.JuegoServiceImpl;
import com.example.demo.demo_backend.services.interfaces.JuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/juegos")
@CrossOrigin(origins = "http://localhost:4200")
public class JuegosController{

    private JuegoService juegoService;

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<Juegos>> searchByName(@PathVariable String keyword) {
        List<Juegos> juegos = juegoService.searchByName(keyword);
        return ResponseEntity.ok(juegos);
    }

    @PostMapping("/crear")
    public ResponseEntity<Juegos> crear(@RequestBody Map<String, Object> juegoData){

        String lanzamientoStr = (String) juegoData.get("fecha_lanzamiento");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Juegos juego = new Juegos();
        juego.setNombre(juegoData.get("nombre").toString());
        juego.setDescripcion(juegoData.get("descripcion").toString());
        juego.setPortada(juegoData.get("portada").toString());
        juego.setLink(juegoData.get("link").toString());

        try {
            Date lanzamientoDate = dateFormat.parse(lanzamientoStr);
            juego.setFecha_lanzamiento(lanzamientoDate);
        } catch (ParseException e) {
            throw new RuntimeException("Formato de fecha incorrecto para fundación", e);
        }

        Long desarrollador = Long.valueOf((Integer) juegoData.get("desarrollador"));
        Juegos newJuego = juegoService.create(juego, desarrollador);

        return ResponseEntity.ok(newJuego);
    }

    @GetMapping("/desarrollador/{id}")
    public List<Juegos> obtenerJuegosPorDesarrollador(@PathVariable Long id) {
        return juegoService.obtenerJuegosPorDesarrollador(id);
    }

    @GetMapping("/{id}")
    public Juegos obtenerJuegoPorId(@PathVariable Long id) {
        return juegoService.obtenerJuegoPorId(id);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        juegoService.eliminarJuego(id);
    }

    @Autowired
    public void setJuegoService(JuegoService juegoService) {
        this.juegoService = juegoService;
    }
}
