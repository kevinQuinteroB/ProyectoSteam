package com.example.demo.demo_backend.repository;

import com.example.demo.demo_backend.models.Generos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenerosRepository extends JpaRepository<Generos, Long> {

    @Query(value = "SELECT * FROM generos WHERE id = :id", nativeQuery = true)
    Generos EncontrarByID(Long id);
}
