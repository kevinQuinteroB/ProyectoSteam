package com.example.demo.demo_backend.controllers;

import com.example.demo.demo_backend.models.Paises;
import com.example.demo.demo_backend.services.PaisesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paises")
@CrossOrigin("http://localhost:4200")
public class PaisesController {
    @Autowired
    private PaisesServices paisesServices;

    @GetMapping("/all")
    public ResponseEntity<Object> retunListaPaises(){
        return ResponseEntity.ok(paisesServices.returnAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paises> obtenerNombrePais(@PathVariable long id) {
        Paises paisNombre = paisesServices.obtenerNombrePorId(id);
        if (paisNombre != null) {
            return ResponseEntity.ok(paisNombre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
