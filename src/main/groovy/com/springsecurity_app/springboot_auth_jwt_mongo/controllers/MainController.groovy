package com.springsecurity_app.springboot_auth_jwt_mongo.controllers

import com.springsecurity_app.springboot_auth_jwt_mongo.security.services.JobService
import com.springsecurity_app.springboot_auth_jwt_mongo.security.services.SpotlightService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("/api/v1")
class MainController {
    @Autowired
    SpotlightService spotlightService
    @Autowired
    JobService jobService

    @RequestMapping("/spotlights")
    ResponseEntity<?> getSpotLights() {
        def spotlights = spotlightService.findAllSpotlights()
        return ResponseEntity.status(200).body(spotlights)
    }

    @RequestMapping("/jobs")
    ResponseEntity<?> getJobs() {
        def jobs = jobService.findAllJobs()
        return ResponseEntity.status(200).body(jobs)
    }
}
