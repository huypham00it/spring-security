package com.springsecurity_app.springboot_auth_jwt_mongo.security.services

import com.springsecurity_app.springboot_auth_jwt_mongo.models.Account
import com.springsecurity_app.springboot_auth_jwt_mongo.models.User
import com.springsecurity_app.springboot_auth_jwt_mongo.repositories.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service

@Service
class AccountService implements AccountRepository{
    @Autowired
    MongoTemplate mongoTemplate

    @Override
     Account findByUserId(String userId) {
        User user = mongoTemplate.findById(userId, User.class)
        if (user) {
            Query query = new Query()
            query.addCriteria(Criteria.where("user").is(user))
            return mongoTemplate.findOne(query, Account.class)
        }
        return null
    }

    @Override
    Account save(Account account) {
        def savedAccount = mongoTemplate.save(account)
        return savedAccount
    }
}
