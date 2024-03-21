package com.toolsToHome.PI.Service;

import com.toolsToHome.PI.Model.Herramienta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.toolsToHome.PI.Model.Imagen;
import com.toolsToHome.PI.Repository.ImagenRepository;

import java.util.Optional;

@Service
public class ImagenService {
    private final ImagenRepository imagenRepository;

    @Autowired
    public ImagenService(ImagenRepository imagenRepository) {
        this.imagenRepository = imagenRepository;
    }

    public void guardarImagen(Imagen imagen) {
        imagenRepository.save(imagen);
    }

    public void actualizarImagen(Imagen imagen) {
        imagenRepository.save(imagen);
    }

    public void eliminarImagen(Long id) {
        imagenRepository.deleteById(id);
    }

    Optional<Imagen> buscarPorId(Long id) { return imagenRepository.findById(id); }
}
