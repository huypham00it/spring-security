package com.springsecurity_app.springboot_auth_jwt_mongo.repositories

import com.springsecurity_app.springboot_auth_jwt_mongo.models.User

interface UserRepository {
    User findByUsername(String username)

    User findByEmail(String email)

    User findById(String id)

    Boolean existsByUsername(String username)

    Boolean existsByEmail(String email)

    void save(User user)
}
