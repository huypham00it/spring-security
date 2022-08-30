package com.springsecurity_app.springboot_auth_jwt_mongo.repositories

import com.springsecurity_app.springboot_auth_jwt_mongo.models.Account
import groovyjarjarantlr.collections.List
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository {
    Account findByUserId(String userId)

    Account save(Account account)
}