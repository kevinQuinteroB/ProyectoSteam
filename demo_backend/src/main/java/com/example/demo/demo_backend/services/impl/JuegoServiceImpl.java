package com.example.demo.demo_backend.services.impl;

import com.example.demo.demo_backend.models.Desarrolladores;
import com.example.demo.demo_backend.models.Juegos;
import com.example.demo.demo_backend.repository.DesarrolladoresRepository;
import com.example.demo.demo_backend.repository.JuegosRepository;
import com.example.demo.demo_backend.services.interfaces.JuegoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuegoServiceImpl implements JuegoService {

    private JuegosRepository juegosRepository;
    private DesarrolladoresRepository desarrolladoresRepository;

    @Override
    public List<Juegos> searchByName(String keyword) {
        return juegosRepository.searchByName(keyword);
    }

    @Transactional
    @Override
    public Juegos create(Juegos juegos, Long desarrolladorid) {
        Desarrolladores desarrollador = desarrolladoresRepository.findById(desarrolladorid)
                .orElseThrow(() -> new RuntimeException("No existe el desarrollador"));
        juegos.setDesarrollador(desarrollador);
        return juegosRepository.save(juegos);
    }

    @Override
    public List<Juegos> obtenerJuegosPorDesarrollador(Long desarrolladorId) {
        return juegosRepository.findByDesarrollador_Id(desarrolladorId);
    }

    @Transactional
    @Override
    public void eliminarJuego(Long id) {
        juegosRepository.deleteById(id);
    }

    @Override
    public Juegos obtenerJuegoPorId(Long id) {
        return juegosRepository.findById(id).orElse(null);
    }

    @Autowired
    public void setJuegosRepository(JuegosRepository juegosRepository) {
        this.juegosRepository = juegosRepository;
    }

    @Autowired
    public void setDesarrolladoresRepository(DesarrolladoresRepository desarrolladoresRepository) {
        this.desarrolladoresRepository = desarrolladoresRepository;
    }
}
