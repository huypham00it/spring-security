package com.springsecurity_app.springboot_auth_jwt_mongo.security.services

import com.fasterxml.jackson.annotation.JsonIgnore
import com.springsecurity_app.springboot_auth_jwt_mongo.models.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

import java.util.stream.Collectors

class UserDetailsImpl implements UserDetails {

    private String id

    private String username

    private String email

    @JsonIgnore
    private String password

    private Collection<? extends GrantedAuthority> authorities

    UserDetailsImpl(String id, String username, String email, String password,
                    Collection<? extends GrantedAuthority> authorities) {
        this.id = id
        this.username = username
        this.email = email
        this.password = password
        this.authorities = authorities
    }

    static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().collect(role -> new SimpleGrantedAuthority(role.getName().name()))

        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authorities)
    }

    @Override
    Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities
    }

    String getId() {
        return id
    }

    String getEmail() {
        return email
    }

    @Override
    String getPassword() {
        return password
    }

    @Override
    String getUsername() {
        return username
    }

    @Override
    boolean isAccountNonExpired() {
        return true
    }

    @Override
    boolean isAccountNonLocked() {
        return true
    }

    @Override
    boolean isCredentialsNonExpired() {
        return true
    }

    @Override
    boolean isEnabled() {
        return true
    }

    @Override
    boolean equals(Object o) {
        if (this == o)
            return true
        if (o == null || getClass() != o.getClass())
            return false
        UserDetailsImpl user = (UserDetailsImpl) o
        return Objects.equals(id, user.id)
    }
}
