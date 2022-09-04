package com.springsecurity_app.springboot_auth_jwt_mongo.security.services

import com.springsecurity_app.springboot_auth_jwt_mongo.models.Job
import com.springsecurity_app.springboot_auth_jwt_mongo.repositories.JobRepository
import groovyjarjarantlr.collections.List
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service

@Service
class JobService implements JobRepository {
    @Autowired
    MongoTemplate mongoTemplate

    @Override
    java.util.List<Job> findAllJobs() {
        return mongoTemplate.findAll(Job.class)
    }
}