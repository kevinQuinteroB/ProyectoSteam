package com.example.demo.demo_backend.repository;


import com.example.demo.demo_backend.models.ComentariosJuegos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<ComentariosJuegos,Long> {

    List<ComentariosJuegos> findByJuego_id(long juegoId);

}
