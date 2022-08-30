package com.springsecurity_app.springboot_auth_jwt_mongo.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "cards")
class Card {
    @Id
    private String id

    @Field(name = "customer_id")
    private int customerId

    @Field(name = "card_number")
    private String cardNumber

    @Field(name = "card_type")
    private String cardType

    @Field(name = "total_limit")
    private int totalLimit

    @Field(name = "amount_used")
    private int amountUsed

    @Field(name = "available_amount")
    private int availableAmount

    @Field(name = "create_dt")
    private Date createDt

    int getCardId() {
        return cardId
    }

    void setCardId(int cardId) {
        this.cardId = cardId
    }

    int getCustomerId() {
        return customerId
    }

    void setCustomerId(int customerId) {
        this.customerId = customerId
    }

    String getCardNumber() {
        return cardNumber
    }

    void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber
    }

    String getCardType() {
        return cardType
    }

    void setCardType(String cardType) {
        this.cardType = cardType
    }

    int getTotalLimit() {
        return totalLimit
    }

    void setTotalLimit(int totalLimit) {
        this.totalLimit = totalLimit
    }

    int getAmountUsed() {
        return amountUsed
    }

    void setAmountUsed(int amountUsed) {
        this.amountUsed = amountUsed
    }

    int getAvailableAmount() {
        return availableAmount
    }

    void setAvailableAmount(int availableAmount) {
        this.availableAmount = availableAmount
    }

    Date getCreateDt() {
        return createDt
    }

    void setCreateDt(Date createDt) {
        this.createDt = createDt
    }
}
