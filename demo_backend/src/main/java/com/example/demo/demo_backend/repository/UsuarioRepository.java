package com.example.demo.demo_backend.repository;


import com.example.demo.demo_backend.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long>{
    @Query(value = "SELECT * FROM usuarios WHERE email = :email AND contrasena = :contrasena", nativeQuery = true)
    Usuarios findByEmail(String email, String contrasena);
}
