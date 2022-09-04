package com.springsecurity_app.springboot_auth_jwt_mongo.payload.response

class JwtResponse {
    private String token
    private String type = "Bearer"
    private String id
    private String username
    private String email
    private String fullName
    private List<String> roles

    JwtResponse(String accessToken, String id, String username, String email, String fullName, List<String> roles) {
        this.token = accessToken
        this.id = id
        this.username = username
        this.email = email
        this.fullName = fullName
        this.roles = roles
    }

    String getFullName() {
        return fullName
    }

    void setFullName(String fullName) {
        this.fullName = fullName
    }

    String getAccessToken() {
        return token
    }

    void setAccessToken(String accessToken) {
        this.token = accessToken
    }

    String getTokenType() {
        return type
    }

    void setTokenType(String tokenType) {
        this.type = tokenType
    }

    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
    }

    String getEmail() {
        return email
    }

    void setEmail(String email) {
        this.email = email
    }

    String getUsername() {
        return username
    }

    void setUsername(String username) {
        this.username = username
    }

    List<String> getRoles() {
        return roles
    }
}
