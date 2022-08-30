package com.springsecurity_app.springboot_auth_jwt_mongo.security.services

import com.springsecurity_app.springboot_auth_jwt_mongo.models.ERole
import com.springsecurity_app.springboot_auth_jwt_mongo.models.Role
import com.springsecurity_app.springboot_auth_jwt_mongo.repositories.RoleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service

@Service
class RoleService implements RoleRepository{
    @Autowired
    MongoTemplate mongoTemplate

    void setupRole() {
        List<Role> roles = mongoTemplate.findAll(Role.class)
        if (roles.size() == 0) {
            mongoTemplate.insert(new Role(ERole.ROLE_USER), "roles")
            mongoTemplate.insert(new Role(ERole.ROLE_ADMIN), "roles")
            mongoTemplate.insert(new Role(ERole.ROLE_MODERATOR), "roles")
        }
    }

    @Override
    Role findByName(ERole name) {
        setupRole()
        Query query = new Query()
        query.addCriteria(Criteria.where("name").is(name))
        return mongoTemplate.findOne(query, Role.class)
    }
}
