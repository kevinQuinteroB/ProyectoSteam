package com.example.demo.demo_backend.repository;


import com.example.demo.demo_backend.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long>{
    @Query("SELECT u.id, u.contrasena, u.email, u.saldo, u.username, u.pais_id FROM Usuarios u WHERE u.email = :email and u.contrasena = :contrasena")
    Object findByEmail(String email, String contrasena);
}
