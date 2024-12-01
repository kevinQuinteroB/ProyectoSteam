package com.example.demo.demo_backend.controllers;

import com.example.demo.demo_backend.models.Paises;
import com.example.demo.demo_backend.services.impl.PaisServiceImpl;
import com.example.demo.demo_backend.services.interfaces.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paises")
@CrossOrigin("http://localhost:4200")
public class PaisesController {

    private PaisService paisService;

    @GetMapping("/all")
    public ResponseEntity<Object> retunListaPaises(){
        return ResponseEntity.ok(paisService.returnAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paises> obtenerNombrePais(@PathVariable long id) {
        Paises paisNombre = paisService.obtenerNombrePorId(id);
        if (paisNombre != null) {
            return ResponseEntity.ok(paisNombre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Autowired
    public void setPaisService(PaisService paisService) {
        this.paisService = paisService;
    }
}
