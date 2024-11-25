package com.example.demo.demo_backend.services;

import com.example.demo.demo_backend.models.Desarrolladores;
import com.example.demo.demo_backend.models.Juegos;
import com.example.demo.demo_backend.repository.DesarrolladoresRepository;
import com.example.demo.demo_backend.repository.JuegosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuegosServices {
    @Autowired
    private JuegosRepository juegosRepository;
    @Autowired
    private DesarrolladoresRepository desarrolladoresRepository;

    public List<Juegos> searchByName(String keyword) {
        return juegosRepository.searchByName(keyword);
    }

    @Transactional
    public Juegos create(Juegos juegos, Long desarrolladorid) {
        Desarrolladores desarrollador = desarrolladoresRepository.findById(desarrolladorid)
                .orElseThrow(() -> new RuntimeException("No existe el desarrollador"));
        juegos.setDesarrollador(desarrollador);
        return juegosRepository.save(juegos);
    }

    public List<Juegos> obtenerJuegosPorDesarrollador(Long desarrolladorId) {
        return juegosRepository.findByDesarrollador_Id(desarrolladorId);
    }

    public void eliminarJuego(Long id) {
        juegosRepository.deleteById(id);
    }

    public Juegos obtenerJuegoPorId(Long id) {
        return juegosRepository.findById(id).orElse(null);
    }
}
