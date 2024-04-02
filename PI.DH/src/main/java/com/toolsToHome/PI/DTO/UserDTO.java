package com.toolsToHome.PI.DTO;

import com.toolsToHome.PI.Model.Reserva;
import com.toolsToHome.PI.Model.Usuario;
import com.toolsToHome.PI.Model.UsuarioRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String username;
    private UsuarioRole role;
    private Set<Reserva> reserva;


    public static UserDTO fromUser(Usuario user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setNombre(user.getNombre());
        userDTO.setApellido(user.getApellido());
        userDTO.setUsername(user.getUsername());
        userDTO.setRole(user.getUsuarioRole());
        userDTO.setReserva(user.getReserva());
        return userDTO;
    }
}