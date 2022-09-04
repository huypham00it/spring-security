package com.springsecurity_app.springboot_auth_jwt_mongo.models

import lombok.Data
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "roles")
@Data
class Role {
    @Id
    private String id

    private ERole name

    Role() {

    }

    Role(ERole name) {
        this.name = name
    }

    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
    }

    String getName() {
        def returnName = name.toString()
        return returnName
    }

    void setName(ERole name) {
        this.name = name
    }
}
