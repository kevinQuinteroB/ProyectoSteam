package com.example.demo.demo_backend.repository;

import com.example.demo.demo_backend.models.Inventarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventariosRepository extends JpaRepository<Inventarios,Long> {

    @Query("SELECT i FROM Inventarios i WHERE i.juego.id = :juegoId AND i.usuario.id = :usuarioId")
    Inventarios findByJuegoIdAndUsuarioId(Long juegoId, Long usuarioId);

    List<Inventarios> findAllByUsuario_Id(Long usuario_id);
}
