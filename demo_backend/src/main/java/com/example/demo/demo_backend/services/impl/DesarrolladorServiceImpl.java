package com.example.demo.demo_backend.services.impl;

import com.example.demo.demo_backend.models.Desarrolladores;
import com.example.demo.demo_backend.models.Paises;
import com.example.demo.demo_backend.repository.DesarrolladoresRepository;
import com.example.demo.demo_backend.repository.PaisesRepository;
import com.example.demo.demo_backend.services.interfaces.DesarrolladorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DesarrolladorServiceImpl implements DesarrolladorService {

    private DesarrolladoresRepository desarrolladoresRepository;
    private PaisesRepository paisesRepository;

    @Override
    @Transactional
    public Desarrolladores saveDesarrollador(Desarrolladores desarrollador, Long paisId) {
        Paises pais = paisesRepository.findById(paisId)
                .orElseThrow(() -> new RuntimeException("País no encontrado"));
        desarrollador.setPais(pais);
        return desarrolladoresRepository.save(desarrollador);
    }

    @Override
    public Desarrolladores findByEmailAndContrasena (String email, String contrasena){
        return desarrolladoresRepository.findByEmailAndContrasena(email, contrasena);
    }

    @Override
    public Optional<Desarrolladores> findById(Long id){
        return desarrolladoresRepository.findById(id);
    }

    @Autowired
    public void setDesarrolladoresRepository(DesarrolladoresRepository desarrolladoresRepository) {
        this.desarrolladoresRepository = desarrolladoresRepository;
    }

    @Autowired
    public void setPaisesRepository(PaisesRepository paisesRepository) {
        this.paisesRepository = paisesRepository;
    }
}
