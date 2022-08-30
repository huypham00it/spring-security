package com.springsecurity_app.springboot_auth_jwt_mongo.payload.request

import lombok.Data

import javax.validation.constraints.NotBlank

@Data
class LoginRequest {
    @NotBlank
    private String username

    @NotBlank
    private String password

    String getUsername() {
        return username
    }

    void setUsername(String username) {
        this.username = username
    }

    String getPassword() {
        return password
    }

    void setPassword(String password) {
        this.password = password
    }
}
