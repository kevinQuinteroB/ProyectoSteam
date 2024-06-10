package com.example.demo.demo_backend.repository;

import com.example.demo.demo_backend.models.Juegos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface JuegosRepository extends JpaRepository<Juegos,Long>{
}
