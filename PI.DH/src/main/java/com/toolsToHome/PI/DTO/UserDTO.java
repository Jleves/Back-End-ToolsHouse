package com.toolsToHome.PI.DTO;

import com.toolsToHome.PI.Model.Usuario;
import com.toolsToHome.PI.Model.UsuarioRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private UsuarioRole role;

    public static UserDTO fromUser(Usuario user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setNombre(user.getNombre());
        userDTO.setApellido(user.getApellido());
        userDTO.setRole(user.getUsuarioRole());
        return userDTO;
    }

}
