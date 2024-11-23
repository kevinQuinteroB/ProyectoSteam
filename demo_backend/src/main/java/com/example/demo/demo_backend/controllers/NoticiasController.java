package com.example.demo.demo_backend.controllers;

import com.example.demo.demo_backend.models.Noticias;
import com.example.demo.demo_backend.services.NoticiasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/noticias")
@CrossOrigin(origins = "http://localhost:4200")
public class NoticiasController {
    @Autowired
    private NoticiasServices noticiasServices;

    @PostMapping("/crear")
    public ResponseEntity<Noticias> crear(@RequestBody Map<String, Object> noticiasData){
        LocalDate fechaActual = LocalDate.now();
        Date fechaSql = Date.valueOf(fechaActual);

        Noticias noticias = new Noticias();
        noticias.setTitulo(noticiasData.get("titulo").toString());
        noticias.setDescripcion(noticiasData.get("descripcion").toString());
        noticias.setFecha_publicacion(fechaSql);

        Long juego_id = Long.valueOf((Integer) noticiasData.get("juego_id"));
        Noticias newNoticia = noticiasServices.create(noticias, juego_id);

        return ResponseEntity.ok(newNoticia);
    }

    @GetMapping("/all/{juego_id}")
    public List<Noticias> getAll(@PathVariable Long juego_id){
        return noticiasServices.findAllByJuego_id(juego_id);
    }

    @DeleteMapping("/delete/{noticia_id}")
    public void delete(@PathVariable Long noticia_id){
        noticiasServices.delete(noticia_id);
    }
}
