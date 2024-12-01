package com.example.demo.demo_backend.controllers;

import com.example.demo.demo_backend.models.Desarrolladores;
import com.example.demo.demo_backend.services.impl.DesarrolladorServiceImpl;
import com.example.demo.demo_backend.services.interfaces.DesarrolladorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/desarrollador")
@CrossOrigin(origins = "http://localhost:4200")
public class DesarrolladoresController {

    private DesarrolladorService desarrolladorService;

    @PostMapping("/register")
    public ResponseEntity<Desarrolladores> register(@RequestBody Map<String, Object> desarrolladorData) {
        Desarrolladores Desarrollador = new Desarrolladores();

        String fundacionStr = (String) desarrolladorData.get("fundacion");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Desarrollador.setNombre(desarrolladorData.get("nombre").toString());
        Desarrollador.setEmail(desarrolladorData.get("email").toString());
        Desarrollador.setContrasena(desarrolladorData.get("contrasena").toString());
        Desarrollador.setDireccion(desarrolladorData.get("direccion").toString());

        try {
            Date fundacionDate = dateFormat.parse(fundacionStr);
            Desarrollador.setFundacion(fundacionDate);
        } catch (ParseException e) {
            throw new RuntimeException("Formato de fecha incorrecto para fundación", e);
        }

        Long paisId = Long.valueOf((Integer) desarrolladorData.get("pais_id"));
        Desarrolladores newDesarrollador = desarrolladorService.saveDesarrollador(Desarrollador, paisId);

        return ResponseEntity.ok(newDesarrollador);
    }

    @GetMapping("/login/{email}/{contrasena}")
    public ResponseEntity<Desarrolladores> login(@PathVariable String email, @PathVariable String contrasena) {
        return ResponseEntity.ok(desarrolladorService.findByEmailAndContrasena(email, contrasena));
    }

    @GetMapping("/id/{id}")
    public Optional<Desarrolladores> id(@PathVariable Long id) {
        return desarrolladorService.findById(id);
    }

    @Autowired
    public void setDesarrolladorService(DesarrolladorService desarrolladorService) {
        this.desarrolladorService = desarrolladorService;
    }
}
