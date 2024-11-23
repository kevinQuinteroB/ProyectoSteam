package com.example.demo.demo_backend.services;

import com.example.demo.demo_backend.models.Juegos;
import com.example.demo.demo_backend.models.Noticias;
import com.example.demo.demo_backend.repository.JuegosRepository;
import com.example.demo.demo_backend.repository.NoticiasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class NoticiasServices {

    @Autowired
    private NoticiasRepository noticiasRepository;
    @Autowired
    private JuegosRepository juegosRepository;

    @Transactional
    public Noticias create(Noticias noticias, Long juego_id) {
        Juegos juego = juegosRepository.findById(juego_id)
                .orElseThrow(() -> new RuntimeException("No existe el Juego"));
        noticias.setJuegos(juego);
        return noticiasRepository.save(noticias);
    };

    public List<Noticias> findAllByJuego_id(Long juego_id){
        // Obtener las noticias del repositorio
        List<Noticias> noticias = noticiasRepository.findByJuegos_Id(juego_id);
        // Ordenar las noticias por fecha de publicación de la más reciente a la más antigua
        noticias.sort(Comparator.comparing(Noticias::getFecha_publicacion).reversed());
        return noticias;
    }

    public void delete(Long noticia_id) {
        Optional<Noticias> noticiaOptional = noticiasRepository.findById(noticia_id);
        if (!noticiaOptional.isPresent()) {
            throw new RuntimeException("No existe la noticia con el ID proporcionado");
        }
        noticiasRepository.deleteById(noticia_id);
    }
}
