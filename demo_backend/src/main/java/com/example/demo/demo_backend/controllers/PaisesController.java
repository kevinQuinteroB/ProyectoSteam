package com.example.demo.demo_backend.controllers;

import com.example.demo.demo_backend.models.Paises;
import com.example.demo.demo_backend.services.PaisesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paises")
@CrossOrigin(origins = "http://localhost:4200/registro")
public class PaisesController {
    @Autowired
    private PaisesServices paisesServices;

    @GetMapping("/all")
    public ResponseEntity<Object> retunListaPaises(){
        return ResponseEntity.ok(paisesServices.returnAll());
    }
}
