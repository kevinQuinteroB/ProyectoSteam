package com.example.demo.demo_backend.controllers;

import com.example.demo.demo_backend.models.Usuarios;
import com.example.demo.demo_backend.services.impl.UsuarioServiceImpl;
import com.example.demo.demo_backend.services.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuariosController {

    private UsuarioService usuarioService;

    @GetMapping("/login/{email}/{contrasena}")
    public ResponseEntity<Usuarios> retunUsuario(@PathVariable String email, @PathVariable String contrasena) {
        return ResponseEntity.ok(usuarioService.findUsuarioByEmail(email, contrasena));
    }

    @GetMapping("all")
    public ResponseEntity<List<Usuarios>> retunUsuarios() {
        return ResponseEntity.ok(usuarioService.findAllUsuarios());
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
        Usuarios newUser = usuarioService.saveUsuario(usuario, paisId);
        return ResponseEntity.ok(newUser);
    }

    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}
