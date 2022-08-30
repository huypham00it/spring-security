package com.springsecurity_app.springboot_auth_jwt_mongo.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "loans")
class Loan {
    @Id
    private String id

    @Field(name = "customer_id")
    private int customerId

    @Field(name = "start_dt")
    private Date startDt

    @Field(name = "loan_type")
    private String loanType

    @Field(name = "total_loan")
    private int totalLoan

    @Field(name = "amount_paid")
    private int amountPaid

    @Field(name = "outstanding_amount")
    private int outstandingAmount

    @Field(name = "create_dt")
    private String createDt

    int getLoanNumber() {
        return loanNumber
    }

    void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber
    }

    int getCustomerId() {
        return customerId
    }

    void setCustomerId(int customerId) {
        this.customerId = customerId
    }

    Date getStartDt() {
        return startDt
    }

    void setStartDt(Date startDt) {
        this.startDt = startDt
    }

    String getLoanType() {
        return loanType
    }

    void setLoanType(String loanType) {
        this.loanType = loanType
    }

    int getTotalLoan() {
        return totalLoan
    }

    void setTotalLoan(int totalLoan) {
        this.totalLoan = totalLoan
    }

    int getAmountPaid() {
        return amountPaid
    }

    void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid
    }

    int getOutstandingAmount() {
        return outstandingAmount
    }

    void setOutstandingAmount(int outstandingAmount) {
        this.outstandingAmount = outstandingAmount
    }

    String getCreateDt() {
        return createDt
    }

    void setCreateDt(String createDt) {
        this.createDt = createDt
    }
}
