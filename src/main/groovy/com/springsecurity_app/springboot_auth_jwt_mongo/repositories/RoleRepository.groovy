package com.springsecurity_app.springboot_auth_jwt_mongo.repositories

import com.springsecurity_app.springboot_auth_jwt_mongo.models.ERole
import com.springsecurity_app.springboot_auth_jwt_mongo.models.Role

interface RoleRepository {
    Role findByName(ERole name)
}
