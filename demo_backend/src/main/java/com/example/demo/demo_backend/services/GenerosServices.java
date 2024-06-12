package com.example.demo.demo_backend.services;

import com.example.demo.demo_backend.models.Generos;
import com.example.demo.demo_backend.repository.GenerosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenerosServices {
    @Autowired
    private GenerosRepository generosRepository;

    public List<Generos> retunall(){
        return generosRepository.findAll();
    }

    public Generos EncontrarByID(Long id){
        return generosRepository.EncontrarByID(id);
    }
}
