package com.example.demo.demo_backend.controllers;

import com.example.demo.demo_backend.models.Generos;
import com.example.demo.demo_backend.services.GenerosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
@CrossOrigin(origins = "http://localhost:4200")
public class GenerosController {
    @Autowired
    private GenerosServices generosServices;

    @GetMapping("/all")
    public ResponseEntity<Object> retunListaPaises(){
        return ResponseEntity.ok(generosServices.retunall());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Generos> retunGenerosJuego(@PathVariable Long id) {
        Generos generos = generosServices.EncontrarByID(id);
        return ResponseEntity.ok(generos);
    }
}
