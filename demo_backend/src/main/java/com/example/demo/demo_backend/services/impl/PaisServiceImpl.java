package com.example.demo.demo_backend.services.impl;

import com.example.demo.demo_backend.models.Paises;
import com.example.demo.demo_backend.repository.PaisesRepository;
import com.example.demo.demo_backend.services.interfaces.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServiceImpl implements PaisService {

    private PaisesRepository paisesRepository;

    @Override
    public List<Paises> returnAll(){
        return paisesRepository.findAll();
    }

    @Override
    public Paises findById(Long id){
        return paisesRepository.findById(id).get();
    }

    @Override
    public Paises obtenerNombrePorId(long paisId) {
        return paisesRepository.findNombreById(paisId);
    }

    @Autowired
    public void setPaisesRepository(PaisesRepository paisesRepository) {
        this.paisesRepository = paisesRepository;
    }
}
