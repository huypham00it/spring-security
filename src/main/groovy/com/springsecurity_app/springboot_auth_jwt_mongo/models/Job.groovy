package com.springsecurity_app.springboot_auth_jwt_mongo.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "jobs")
class Job {
    @Id
    String Id
    String title
    String organization
    String degree
    String jobType
    String[] locations
    String[] minimumQualifications
    String[] preferredQualifications
    String[] description
    String dateAdded
}
