package com.example.demo.demo_backend.services;

import com.example.demo.demo_backend.models.Inventarios;
import com.example.demo.demo_backend.repository.InventariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventarioServices  {
    @Autowired
    private InventariosRepository inventariosRepository;

    public Inventarios save(Inventarios inventarios) {
        return inventariosRepository.save(inventarios);
    }
}
