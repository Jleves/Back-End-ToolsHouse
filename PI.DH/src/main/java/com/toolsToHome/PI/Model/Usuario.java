package com.toolsToHome.PI.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

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


    public Usuario(Long id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }


    @Column
    private String ciudad;

    @Enumerated(EnumType.STRING)
    private UsuarioRole usuarioRole;




    @JsonIgnore
    @OneToMany(mappedBy = "usuarioId", cascade = CascadeType.ALL)
    private Set<Reserva> reserva= new HashSet<>();



    @ManyToMany
    @JoinTable(name = "herramienta_favorita",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "herramientaid"))
    private List<Herramienta> herramientasFavoritas = new ArrayList<>();


    public List<Herramienta> getHerramientasFavoritas() {
        return herramientasFavoritas;
    }

    public void setHerramientasFavoritas(List<Herramienta> herramientasFavoritas) {
        this.herramientasFavoritas = herramientasFavoritas;
    }




    public void setUsuarioRole(UsuarioRole usuarioRole) {
        this.usuarioRole = usuarioRole;
    }


    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario(Long id, String nombre, String apellido, String password, String email, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.email = email;
        this.ciudad = ciudad;
    }

    public Long getId() {
        return id;
    }

    public UsuarioRole getUsuarioRole() {
        return usuarioRole;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioRole.name());
        return Collections.singletonList(grantedAuthority);
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