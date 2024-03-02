package com.toolsToHome.PI.Service;


import com.toolsToHome.PI.Model.Usuario;
import com.toolsToHome.PI.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {

    public UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> buscarUsuario = usuarioRepository.findByEmail(username);
        if(buscarUsuario.isPresent()){
            return buscarUsuario.get();

        }else throw new UsernameNotFoundException("No se encontro el usuario");
    }
}
