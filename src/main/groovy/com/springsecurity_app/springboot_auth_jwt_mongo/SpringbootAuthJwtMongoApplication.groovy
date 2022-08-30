package com.springsecurity_app.springboot_auth_jwt_mongo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@SpringBootApplication
//@EnableWebSecurity(debug = true)
class SpringbootAuthJwtMongoApplication {

	static void main(String[] args) {
		SpringApplication.run(SpringbootAuthJwtMongoApplication, args)
	}

}
