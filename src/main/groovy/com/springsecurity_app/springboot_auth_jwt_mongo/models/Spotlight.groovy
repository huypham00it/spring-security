package com.springsecurity_app.springboot_auth_jwt_mongo.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "spotlights")
class Spotlight {
    @Id
    String id
    String img
    String title
    String description
}
