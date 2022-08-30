package com.springsecurity_app.springboot_auth_jwt_mongo.payload.request

import lombok.Data
import org.springframework.data.mongodb.core.mapping.Field

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Data
class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username

    @NotBlank
    @Size(max = 50)
    @Email
    private String email

    private Set<String> roles

    @NotBlank
    @Size(min = 6, max = 40)
    private String password

    @NotBlank
    @Size(max = 30)
    private String fullName

    void setRoles(Set<String> roles) {
        this.roles = roles
    }

    String getFullName() {
        return fullName
    }

    void setFullName(String fullName) {
        this.fullName = fullName
    }

    String getUsername() {
        return username
    }

    void setUsername(String username) {
        this.username = username
    }

    String getEmail() {
        return email
    }

    void setEmail(String email) {
        this.email = email
    }

    String getPassword() {
        return password
    }

    void setPassword(String password) {
        this.password = password
    }

    Set<String> getRoles() {
        return this.roles
    }

    void setRole(Set<String> roles) {
        this.roles = roles
    }
}
