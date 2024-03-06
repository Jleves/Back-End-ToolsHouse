package com.toolsToHome.PI.Service;

import com.toolsToHome.PI.DTO.UserDTO;
import com.toolsToHome.PI.Repository.UserRepository;
import com.toolsToHome.PI.User.Role;
import com.toolsToHome.PI.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDTO getUserById(Long userId)
    {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new UsernameNotFoundException("No se encontró al usuario con el ID: "+ userId));
        return UserDTO.fromUser(user);
    }

    public UserDTO getUserByUsername(String username)
    {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("No se encontró al usuario con el correo: "+username));
        return UserDTO.fromUser(user);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAllProjectedBy();
    }

    public void updateRole(String username, Role newRole) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No se encontró al usuario con el correo: " + username));

        user.setRole(newRole);
        userRepository.save(user);
    }

    public  void save(User user)
    {
        userRepository.save(user);
    }

}
