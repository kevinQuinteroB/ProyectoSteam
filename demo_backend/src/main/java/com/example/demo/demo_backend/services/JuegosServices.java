package com.example.demo.demo_backend.services;

import com.example.demo.demo_backend.models.Juegos;
import com.example.demo.demo_backend.repository.JuegosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuegosServices {
    @Autowired
    private JuegosRepository juegosRepository;

    public List<Juegos> searchByName(String keyword) {
        return juegosRepository.searchByName(keyword);
    }


}
