package com.springsecurity_app.springboot_auth_jwt_mongo.repositories

import com.springsecurity_app.springboot_auth_jwt_mongo.models.Transaction
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepository {
    List<Transaction> findByCustomerIdOrderByTransactionDtDesc(String userId);
}