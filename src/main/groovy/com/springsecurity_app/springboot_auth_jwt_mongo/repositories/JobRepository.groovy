package com.springsecurity_app.springboot_auth_jwt_mongo.repositories

import com.springsecurity_app.springboot_auth_jwt_mongo.models.Job

interface JobRepository {
    List<Job> findAllJobs()
}