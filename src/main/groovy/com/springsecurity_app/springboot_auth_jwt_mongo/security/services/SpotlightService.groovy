package com.springsecurity_app.springboot_auth_jwt_mongo.security.services


import com.springsecurity_app.springboot_auth_jwt_mongo.models.Spotlight
import com.springsecurity_app.springboot_auth_jwt_mongo.repositories.SpotlightRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service

@Service
class SpotlightService implements SpotlightRepository {
    @Autowired
    MongoTemplate mongoTemplate

    @Override
    List<Spotlight> findAllSpotlights() {
        return mongoTemplate.findAll(Spotlight.class)
    }
}
