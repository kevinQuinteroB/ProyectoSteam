package com.example.demo.demo_backend.services;

import com.example.demo.demo_backend.models.Paises;
import com.example.demo.demo_backend.repository.PaisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisesServices {
    @Autowired
    private PaisesRepository paisesRepository;

    public List<Paises> returnAll(){
        return paisesRepository.findAll();
    }

    public Paises findById(Long id){
        return paisesRepository.findById(id).get();
    }
}
