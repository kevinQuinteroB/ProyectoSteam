package com.example.demo.demo_backend.services.interfaces;

import com.example.demo.demo_backend.models.Noticias;
import jakarta.transaction.Transactional;

import java.util.List;

public interface NoticiaService {
    @Transactional
    Noticias create(Noticias noticias, Long juego_id);

    List<Noticias> findAllByJuego_id(Long juego_id);

    void delete(Long noticia_id);
}
