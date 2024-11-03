package com.example.demo.demo_backend.repository;

import com.example.demo.demo_backend.models.Desarrolladores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DesarrolladoresRepository extends JpaRepository<Desarrolladores, Long> {

    @Query(value = "SELECT * FROM desarrolladores WHERE email = :email AND contrasena = :contrasena", nativeQuery = true)
    Desarrolladores findByEmailAndContrasena(String email, String contrasena);

}
