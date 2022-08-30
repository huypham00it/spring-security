package com.springsecurity_app.springboot_auth_jwt_mongo.controllers

import com.springsecurity_app.springboot_auth_jwt_mongo.models.User
import com.springsecurity_app.springboot_auth_jwt_mongo.security.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/test")
class TestController {
    @Autowired
    MongoTemplate mongoTemplate

    @GetMapping("/all")
    String allAccess() {
        return "Public Content."
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    String userAccess() {
        return "User Content."
    }

    @GetMapping("/user/{id}")
    User getUser(@PathVariable String id) {
        return mongoTemplate.findById(id, User.class)
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    String moderatorAccess() {
        return "Moderator Board."
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    String adminAccess() {
        return "Admin Board."
    }
}
