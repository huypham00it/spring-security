package com.springsecurity_app.springboot_auth_jwt_mongo.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "transactions")
class Transaction {
    @Id
    private String id

    @DBRef
    private Account account

    @DBRef
    private User user

    @Field(name = "transaction_at")
    private Date transactionAt

    @Field(name = "transaction_summary")
    private String transactionSummary

    @Field(name = "transaction_type")
    private String transactionType

    @Field(name = "transaction_amt")
    private int transactionAmt

    @Field(name = "closing_balance")
    private int closingBalance

    @Field(name = "create_at")
    private String createAt

    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
    }

    Account getAccount() {
        return account
    }

    void setAccount(Account account) {
        this.account = account
    }

    User getUser() {
        return user
    }

    void setUser(User user) {
        this.user = user
    }

    Date getTransactionAt() {
        return transactionAt
    }

    void setTransactionAt(Date transactionAt) {
        this.transactionAt = transactionAt
    }

    String getTransactionSummary() {
        return transactionSummary
    }

    void setTransactionSummary(String transactionSummary) {
        this.transactionSummary = transactionSummary
    }

    String getTransactionType() {
        return transactionType
    }

    void setTransactionType(String transactionType) {
        this.transactionType = transactionType
    }

    int getTransactionAmt() {
        return transactionAmt
    }

    void setTransactionAmt(int transactionAmt) {
        this.transactionAmt = transactionAmt
    }

    int getClosingBalance() {
        return closingBalance
    }

    void setClosingBalance(int closingBalance) {
        this.closingBalance = closingBalance
    }

    String getCreateAt() {
        return createAt
    }

    void setCreateAt(String createAt) {
        this.createAt = createAt
    }
}
