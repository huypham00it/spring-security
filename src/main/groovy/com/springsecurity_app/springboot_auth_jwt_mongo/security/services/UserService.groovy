package com.springsecurity_app.springboot_auth_jwt_mongo.security.services

import com.springsecurity_app.springboot_auth_jwt_mongo.models.User
import com.springsecurity_app.springboot_auth_jwt_mongo.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service

@Service
class UserService implements UserRepository{
    @Autowired
    MongoTemplate mongoTemplate

    @Override
    User findByUsername(String username) {
        Query query = new Query()
        query.addCriteria(Criteria.where("username").is(username))
        return mongoTemplate.findOne(query, User.class)
    }

    @Override
    User findByEmail(String email) {
        Query query = new Query()
        query.addCriteria(Criteria.where("email").is(email))
        return mongoTemplate.findOne(query, User.class)
    }

    @Override
    User findById(String id) {
        return mongoTemplate.findById(id, User.class)
    }

    @Override
    Boolean existsByUsername(String username) {
        Query query = new Query()
        query.addCriteria(Criteria.where("username").is(username))
        return mongoTemplate.findOne(query, User.class) != null
    }

    @Override
    Boolean existsByEmail(String email) {
        Query query = new Query()
        query.addCriteria(Criteria.where("email").is(email))
        return mongoTemplate.findOne(query, User.class) != null
    }

    @Override
    void save(User user) {
        mongoTemplate.save(user)
    }
}
