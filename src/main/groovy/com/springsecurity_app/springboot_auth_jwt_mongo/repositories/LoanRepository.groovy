package com.springsecurity_app.springboot_auth_jwt_mongo.repositories

import com.springsecurity_app.springboot_auth_jwt_mongo.models.Loan

interface LoanRepository {
    List<Loan> findByCustomerIdOrderByStartDtDesc(String userId);
}