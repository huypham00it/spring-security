package com.springsecurity_app.springboot_auth_jwt_mongo.models

import lombok.Data
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Document(collection = "users")
@Data
class User {
    @Id
    private String id

    @NotBlank
    @Size(max = 20)
    private String username

    @NotBlank
    @Size(max = 30)
    @Field(name = "full_name")
    private String fullName

    @NotBlank
    @Size(max = 50)
    @Email
    private String email

    @NotBlank
    @Size(max = 120)
    private String password

    @DBRef
    private Set<Role> roles = new HashSet<>()

    User() {
    }

    User(String username, String email, String fullName, String password) {
        this.username = username
        this.email = email
        this.password = password
        this.fullName = fullName
    }

    String getFullName() {
        return fullName
    }

    void setFullName(String fullName) {
        this.fullName = fullName
    }

    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
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

    Set<Role> getRoles() {
        return roles
    }

    void setRoles(Set<Role> roles) {
        this.roles = roles
    }
}
