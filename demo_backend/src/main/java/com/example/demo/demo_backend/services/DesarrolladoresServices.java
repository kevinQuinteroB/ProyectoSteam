package com.example.demo.demo_backend.services;

import com.example.demo.demo_backend.models.Desarrolladores;
import com.example.demo.demo_backend.models.Paises;
import com.example.demo.demo_backend.repository.DesarrolladoresRepository;
import com.example.demo.demo_backend.repository.PaisesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DesarrolladoresServices {
    @Autowired
    private DesarrolladoresRepository desarrolladoresRepository;

    @Autowired
    private PaisesRepository paisesRepository;

    @Transactional
    public Desarrolladores saveDesarrollador(Desarrolladores desarrollador, Long paisId) {
        Paises pais = paisesRepository.findById(paisId)
                .orElseThrow(() -> new RuntimeException("País no encontrado"));
        desarrollador.setPais(pais);
        return desarrolladoresRepository.save(desarrollador);
    }

    public Desarrolladores findByEmailAndContrasena (String email, String contrasena){
        return desarrolladoresRepository.findByEmailAndContrasena(email, contrasena);
    }

    public Optional<Desarrolladores> findById(Long id){
        return desarrolladoresRepository.findById(id);
    }
}
