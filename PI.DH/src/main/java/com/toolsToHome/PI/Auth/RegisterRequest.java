package com.toolsToHome.PI.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
String nombre;
String apellido;
String password;
String email;
}

//Datos para el registro de usuarios que viene desde AuthController
