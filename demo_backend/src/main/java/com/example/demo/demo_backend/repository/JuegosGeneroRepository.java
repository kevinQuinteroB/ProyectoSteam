package com.example.demo.demo_backend.repository;

import com.example.demo.demo_backend.models.JuegosGenero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JuegosGeneroRepository extends JpaRepository<JuegosGenero, Long> {
    @Query(value = "SELECT * FROM juegos_genero j WHERE juego_id = :id", nativeQuery = true)
    List<JuegosGenero> EncontrarByID(Long id);
}
