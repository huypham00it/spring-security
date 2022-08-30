package com.springsecurity_app.springboot_auth_jwt_mongo.payload.request

import javax.validation.constraints.NotBlank

class AccountRequest {
    @NotBlank
    private String accountType

    @NotBlank
    private String branchAddress

    String getAccountType() {
        return accountType
    }

    void setAccountType(String accountType) {
        this.accountType = accountType
    }

    String getBranchAddress() {
        return branchAddress
    }

    void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress
    }
}
