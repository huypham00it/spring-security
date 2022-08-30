package com.springsecurity_app.springboot_auth_jwt_mongo.repositories

import com.springsecurity_app.springboot_auth_jwt_mongo.models.Card

interface CardRepository {
    List<Card> findByCustomerId(String userId);
}