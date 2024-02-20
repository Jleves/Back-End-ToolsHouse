package com.toolsToHome.PI.Service;

import com.toolsToHome.PI.Model.Herramienta;
import com.toolsToHome.PI.Repository.HerramientaRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HerramientaService {
    private static final Logger logger= Logger.getLogger(HerramientaService.class);
    private HerramientaRepository herramientaRepository;
    @Autowired
    public HerramientaService(HerramientaRepository herramientaRepository) {
        this.herramientaRepository = herramientaRepository;
    }
    public Herramienta guardarHerramienta (Herramienta herramienta) {
        logger.info("Herramienta service");return herramientaRepository.save(herramienta);
    }
    public Optional<Herramienta> buscarPorId(Long id){
        return herramientaRepository.findById(id);
    }
    public void eliminarHerramienta(Long id){
        herramientaRepository.deleteById(id);
    }
    public void actualizarHerramienta(Herramienta herramienta){
        herramientaRepository.save(herramienta);
    }
    public List<Herramienta> listarTodos(){
        return herramientaRepository.findAll();
    }

}
