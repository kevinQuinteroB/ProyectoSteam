package com.example.demo.demo_backend.services.interfaces;

import com.example.demo.demo_backend.models.Paises;

import java.util.List;

public interface PaisService {
    List<Paises> returnAll();

    Paises findById(Long id);

    Paises obtenerNombrePorId(long paisId);
}
