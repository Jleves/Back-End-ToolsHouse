package com.toolsToHome.PI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.toolsToHome.PI.Model.Imagen;
import com.toolsToHome.PI.Repository.ImagenRepository;

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
}
