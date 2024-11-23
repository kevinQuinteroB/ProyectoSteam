package com.example.demo.demo_backend.repository;

import com.example.demo.demo_backend.models.Noticias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticiasRepository extends JpaRepository<Noticias, Long> {

    List<Noticias> findByJuegos_Id(long juegosId);

}
