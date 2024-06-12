package com.example.demo.demo_backend.services;

import com.example.demo.demo_backend.models.Generos;
import com.example.demo.demo_backend.models.JuegosGenero;
import com.example.demo.demo_backend.repository.JuegosGeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuegosGeneroServices {
    @Autowired
    private  GenerosServices generosServices;

    @Autowired
    private JuegosGeneroRepository juegosGeneroRepository;

    public List<JuegosGenero> EncontrarByID(Long id){
        return juegosGeneroRepository.EncontrarByID(id);
    }


}
