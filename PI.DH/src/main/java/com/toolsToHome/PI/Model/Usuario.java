package com.toolsToHome.PI.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Column (name= "nombre")
    private String nombre;
    @Getter
    @Column (name = "apellido")
    private String apellido;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", unique = true)
    private String email;

    @Column
    private String ciudad;

    @Enumerated(EnumType.STRING)
    private UsuarioRole usuarioRole;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioRole.name());
        return Collections.singletonList(grantedAuthority);
    }

    public Long getId() {
        return id;
    }

    public UsuarioRole getUsuarioRole() {
        return usuarioRole;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
