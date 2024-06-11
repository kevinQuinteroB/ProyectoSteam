package com.example.demo.demo_backend.controllers;

import com.example.demo.demo_backend.models.Juegos;
import com.example.demo.demo_backend.services.JuegosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/juegos")
@CrossOrigin(origins = "http://localhost:4200/registro")
public class JuegosController{
    @Autowired
    private JuegosServices juegosService;

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<Juegos>> searchByName(@PathVariable String keyword) {
        List<Juegos> juegos = juegosService.searchByName(keyword);
        return ResponseEntity.ok(juegos);
    }
}
