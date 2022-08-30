package com.springsecurity_app.springboot_auth_jwt_mongo.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "accounts")
class Account {
    @Id
    private String id

    @DBRef
    private User user

    @Field(name = "account_type")
    private String accountType

    @Field(name = "branch_address")
    private String branchAddress

    @Field(name = "create_at")
    private String createAt

//    Account(User user, String accountType, String branchAddress) {
//        this.user = user
//        this.accountType = accountType
//        this.branchAddress = branchAddress
//        this.createAt = new Date().toInstant()
//    }
//
//    String getId() {
//        return id
//    }
//
//    void setId(String id) {
//        this.id = id
//    }
//
//    User getUser() {
//        return user
//    }
//
//    void setUser(User user) {
//        this.user = user
//    }
//
//    String getAccountType() {
//        return accountType
//    }
//
//    void setAccountType(String accountType) {
//        this.accountType = accountType
//    }
//
//    String getBranchAddress() {
//        return branchAddress
//    }
//
//    void setBranchAddress(String branchAddress) {
//        this.branchAddress = branchAddress
//    }
//
//    String getCreateAt() {
//        return createAt
//    }
//
//    void setCreateAt(String createAt) {
//        this.createAt = createAt
//    }
}
