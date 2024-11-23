package com.example.demo.demo_backend.repository;

import com.example.demo.demo_backend.models.Juegos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JuegosRepository extends JpaRepository<Juegos,Long>{
    @Query("SELECT j FROM Juegos j WHERE LOWER(j.nombre) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Juegos> searchByName(@Param("keyword") String keyword);

    List<Juegos> findByDesarrollador_Id(Long desarrolladorId);
}
