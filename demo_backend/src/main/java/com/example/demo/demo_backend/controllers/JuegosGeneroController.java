package com.example.demo.demo_backend.controllers;

import com.example.demo.demo_backend.models.Generos;
import com.example.demo.demo_backend.models.JuegosGenero;
import com.example.demo.demo_backend.services.JuegosGeneroServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/juegosGenero")
@CrossOrigin(origins = "http://localhost:4200")
public class JuegosGeneroController {
    @Autowired
    private JuegosGeneroServices juegosGeneroServices;

    @GetMapping("{id}")
    public ResponseEntity<List<JuegosGenero>> retunGenerosJuego(@PathVariable Long id) {
        List<JuegosGenero> juegosGenero = juegosGeneroServices.EncontrarByID(id);
        return ResponseEntity.ok(juegosGenero);
    }
}
