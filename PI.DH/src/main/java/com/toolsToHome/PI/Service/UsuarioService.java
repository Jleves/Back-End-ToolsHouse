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

@Service
public class UsuarioService implements UserDetailsService {

    private UsuarioRepository usuarioRepository;
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
    public Optional<UserDTO> buscarPorId(Long id){
        Optional<Usuario>buscarUsuario = usuarioRepository.findById(id);
        if(buscarUsuario.isPresent()){
            return Optional.of(userDto(buscarUsuario.get()));
        }else return Optional.empty();
    }
    public void eliminarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
    public void actualizarUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }
    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

    public void updateRole(Long id, Usuario usuarioRole) throws ResourceNotFoundException {
        Optional<UserDTO> usuarioRequest = buscarPorId(id);
        if(usuarioRequest.isPresent()){
            Usuario user = usuarioRepository.findByEmail(usuarioRequest.get().getUsername())
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontró al usuario con el id: " + id));
            user.setUsuarioRole(usuarioRole.getUsuarioRole());
            usuarioRepository.save(user);
        } else {
            throw new ResourceNotFoundException("No se encontró al usuario con el id: " + id);
        }
    }

    private UserDTO userDto(Usuario usuario){
        UserDTO userDTO = new UserDTO();

        userDTO.setId(usuario.getId());
        userDTO.setNombre(usuario.getNombre());
        userDTO.setApellido(usuario.getApellido());
        userDTO.setUsername(usuario.getUsername());
        userDTO.setRole(usuario.getUsuarioRole());

        return userDTO;
    }

    public Optional<UserDTO> findUserByEmail(String email) {
        Optional<Usuario> userOptional = usuarioRepository.findByEmail(email);
        return userOptional.map(UserDTO::fromUser);
    }





}