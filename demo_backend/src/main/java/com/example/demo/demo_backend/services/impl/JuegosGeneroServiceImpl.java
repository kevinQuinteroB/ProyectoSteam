package com.example.demo.demo_backend.services.impl;

import com.example.demo.demo_backend.models.JuegosGenero;
import com.example.demo.demo_backend.repository.JuegosGeneroRepository;
import com.example.demo.demo_backend.services.interfaces.JuegosGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuegosGeneroServiceImpl implements JuegosGeneroService {

    private GeneroServiceImpl generoService;
    private JuegosGeneroRepository juegosGeneroRepository;

    @Override
    public List<JuegosGenero> EncontrarByID(Long id){
        return juegosGeneroRepository.EncontrarByID(id);
    }

    @Autowired
    public void setGeneroService(GeneroServiceImpl generoService) {
        this.generoService = generoService;
    }

    @Autowired
    public void setJuegosGeneroRepository(JuegosGeneroRepository juegosGeneroRepository) {
        this.juegosGeneroRepository = juegosGeneroRepository;
    }
}
