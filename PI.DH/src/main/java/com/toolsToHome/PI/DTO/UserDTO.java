package com.toolsToHome.PI.DTO;

import com.toolsToHome.PI.User.Role;
import com.toolsToHome.PI.User.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String username;
    private Role role;

    public static UserDTO fromUser(User user)
    {
        return new UserDTO(
                user.getId(),
                user.getNombre(),
                user.getApellido(),
                user.getUsername(),
                user.getRole()
        );
    }
}
