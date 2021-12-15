package com.devsuperior.bds04.dto;

import com.devsuperior.bds04.entities.Role;
import com.devsuperior.bds04.entities.User;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String email;
    private String password;
    private Set<Role> roles = new HashSet<>();

    public UserDto() {
    }

    public UserDto(Long id, String email, String password, Set<Role> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public UserDto(User user) {
        id = user.getId();
        email = user.getEmail();
        password = user.getPassword();
        roles = user.getRoles();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
