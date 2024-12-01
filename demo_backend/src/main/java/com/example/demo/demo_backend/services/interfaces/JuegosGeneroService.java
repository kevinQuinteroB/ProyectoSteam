package com.example.demo.demo_backend.services.interfaces;

import com.example.demo.demo_backend.models.JuegosGenero;

import java.util.List;

public interface JuegosGeneroService {
    List<JuegosGenero> EncontrarByID(Long id);
}
