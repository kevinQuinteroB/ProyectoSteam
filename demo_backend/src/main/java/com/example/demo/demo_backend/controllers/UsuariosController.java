package com.example.demo.demo_backend.controllers;

import com.example.demo.demo_backend.models.Usuarios;
import com.example.demo.demo_backend.services.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuariosController {
    @Autowired
    private UsuariosServices usuariosServices;

    @GetMapping("/login/{email}/{contrasena}")
    public ResponseEntity<Usuarios> retunUsuario(@PathVariable String email, @PathVariable String contrasena) {
        return ResponseEntity.ok(usuariosServices.findUsuarioByEmail(email, contrasena));
    }

    @PostMapping("/register")
    public ResponseEntity<Usuarios> registerUser(@RequestBody Usuarios usuario) {
        Usuarios newUser = usuariosServices.saveUsuario(usuario);
        return ResponseEntity.ok(newUser);
    }
}
