package com.toolsToHome.PI.Service;



import com.toolsToHome.PI.DTO.UserDTO;
import com.toolsToHome.PI.Exceptions.ResourceNotFoundException;
import com.toolsToHome.PI.Model.Usuario;
import com.toolsToHome.PI.Model.UsuarioRole;
import com.toolsToHome.PI.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService {

    private UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<UserDTO> findUserByEmail(String email) {
        Optional<Usuario> userOptional = usuarioRepository.findByEmail(email);
        return userOptional.map(UserDTO::fromUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> buscarUsuario = usuarioRepository.findByEmail(username);
        if(buscarUsuario.isPresent()){
            return buscarUsuario.get();

        }else throw new UsernameNotFoundException("No se encontro el usuario");
    }

    public Optional<UserDTO> findUserById(Long id) throws ResourceNotFoundException{
        Optional<Usuario> userOptional = usuarioRepository.findById(id);
        if (userOptional.isPresent()) {
            Usuario user = userOptional.get();
            UserDTO userDTO = UserDTO.fromUser(user);
            return Optional.of(userDTO);
        } else {
            throw  new ResourceNotFoundException("No se encontró al usuario con el ID: " + id);
        }
    }



    public void updateRole(Long id, UsuarioRole newRole) throws ResourceNotFoundException {
        Optional<UserDTO> usuarioRequest = findUserById(id);
        if(usuarioRequest.isPresent()){
            Usuario user = usuarioRepository.findByEmail(usuarioRequest.get().getUsername())
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontró al usuario con el id: " + id));
            user.setUsuarioRole(newRole);
            usuarioRepository.save(user);
        } else {
            throw new ResourceNotFoundException("No se encontró al usuario con el id: " + id);
        }
    }

    public void eliminarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
    public void actualizarUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }
    public List<UserDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(UserDTO::fromUser)
                .collect(Collectors.toList());
    }

}
