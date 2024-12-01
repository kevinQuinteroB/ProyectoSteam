package com.example.demo.demo_backend.services.interfaces;

import com.example.demo.demo_backend.models.Generos;

import java.util.List;

public interface GeneroService {
    List<Generos> retunall();

    Generos encontrarByID(Long id);
}
