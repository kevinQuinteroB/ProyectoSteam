package com.example.demo.demo_backend.services.impl;

import com.example.demo.demo_backend.models.Generos;
import com.example.demo.demo_backend.repository.GenerosRepository;
import com.example.demo.demo_backend.services.interfaces.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServiceImpl implements GeneroService {

    private GenerosRepository generosRepository;

    @Override
    public List<Generos> retunall(){
        return generosRepository.findAll();
    }

    @Override
    public Generos encontrarByID(Long id){
        return generosRepository.EncontrarByID(id);
    }

    @Autowired
    public void setGenerosRepository(GenerosRepository generosRepository) {
        this.generosRepository = generosRepository;
    }
}
