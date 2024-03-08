package com.toolsToHome.PI.Security;

import com.toolsToHome.PI.Model.Usuario;
import com.toolsToHome.PI.Service.UsuarioService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);//Sacamos la autenticacion del encabezado
        String username= null;
        String jwt = null;

        if(authorizationHeader != null &&  authorizationHeader.startsWith("Bearer")) { //Si la autenticacion Header comienza con Bearer...
            jwt = authorizationHeader.substring(7);//Apartir del orden 7 hasta el final es el token
            username = jwtUtil.extractUserName(jwt);
        }

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails  = this.usuarioService.loadUserByUsername(username);
            if(jwtUtil.validateToken(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken  = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }


}
