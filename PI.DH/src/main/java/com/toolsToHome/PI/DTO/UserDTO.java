package com.toolsToHome.PI.DTO;

import com.toolsToHome.PI.Model.Usuario;
import com.toolsToHome.PI.Model.UsuarioRole;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "Información de un usuario")
public class UserDTO {
    @ApiModelProperty(notes = "ID único del usuario")
    private Long id;
    private String nombre;
    private String apellido;
    @ApiModelProperty(notes = "Correo electrónico del usuario")
    private String username;
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