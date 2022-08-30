package com.springsecurity_app.springboot_auth_jwt_mongo.payload.response

class JwtResponse {
    private String token
    private String type = "Bearer"
    private String id
    private String username
    private String email
    private List<String> roles
    private MessageResponse meta

    MessageResponse getMeta() {
        return meta
    }

    void setMeta(MessageResponse meta) {
        this.meta = meta
    }

    JwtResponse(String accessToken, String id, String username, String email, List<String> roles, MessageResponse meta) {
        this.token = accessToken
        this.id = id
        this.username = username
        this.email = email
        this.roles = roles
        this.meta = meta
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
