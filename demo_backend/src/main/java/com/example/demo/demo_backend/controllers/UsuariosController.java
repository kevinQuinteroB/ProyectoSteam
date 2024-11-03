package com.example.demo.demo_backend.controllers;

import com.example.demo.demo_backend.models.Usuarios;
import com.example.demo.demo_backend.services.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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

    @GetMapping("all")
    public ResponseEntity<List<Usuarios>> retunUsuarios() {
        return ResponseEntity.ok(usuariosServices.findAllUsuarios());
    }

    @PostMapping("/register")
    public ResponseEntity<Usuarios> registerUser(@RequestBody Map<String, Object> usuarioData) {
        Usuarios usuario = new Usuarios();
        usuario.setEmail((String) usuarioData.get("email"));
        usuario.setContrasena((String) usuarioData.get("contrasena"));
        usuario.setUsername((String) usuarioData.get("username"));
        usuario.setPrimerNombre((String) usuarioData.get("primerNombre"));
        usuario.setPrimerApellido((String) usuarioData.get("primerApellido"));
        usuario.setTelefono((int) usuarioData.get("telefono"));

        Long paisId = Long.valueOf((Integer) usuarioData.get("pais_id"));
        Usuarios newUser = usuariosServices.saveUsuario(usuario, paisId);
        return ResponseEntity.ok(newUser);
    }
}
