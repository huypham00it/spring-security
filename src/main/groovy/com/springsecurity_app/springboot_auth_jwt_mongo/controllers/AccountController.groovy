package com.springsecurity_app.springboot_auth_jwt_mongo.controllers

import com.springsecurity_app.springboot_auth_jwt_mongo.constants.BankConstants
import com.springsecurity_app.springboot_auth_jwt_mongo.models.Account
import com.springsecurity_app.springboot_auth_jwt_mongo.models.User
import com.springsecurity_app.springboot_auth_jwt_mongo.payload.request.AccountRequest
import com.springsecurity_app.springboot_auth_jwt_mongo.payload.response.MessageResponse
import com.springsecurity_app.springboot_auth_jwt_mongo.repositories.AccountRepository
import com.springsecurity_app.springboot_auth_jwt_mongo.security.services.AccountService
import com.springsecurity_app.springboot_auth_jwt_mongo.security.services.UserDetailsImpl
import com.springsecurity_app.springboot_auth_jwt_mongo.security.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/bank")
class AccountController {
    @Autowired
    AccountService accountService

    @Autowired
    UserService userService

    @PostMapping("/account")
    @PreAuthorize("hasRole('ROLE_USER')")
    ResponseEntity<?> getAccountDetails(@RequestBody User user) {
        def response
        Account account = accountService.findByUserId(user.getId())
        if (account != null ) {
            response = new MessageResponse(200, "Success to retrieve data for this request", "Success")
            return ResponseEntity.ok().body([response, account])
        }else {
            response = new MessageResponse(400, "Failed to retrieve data for this request", "Failed")
            return ResponseEntity.badRequest().body(response)
        }
    }

    @PostMapping("/account/create")
    @PreAuthorize("hasRole('ROLE_USER')")
    ResponseEntity<?> createAccount(@RequestBody AccountRequest account) {
        def response
        def accountType = account.getAccountType()
        def accountBranchAddress = account.getBranchAddress()

        if (!accountType || !accountBranchAddress) {
            response = new MessageResponse(400, "Account types and Account branch address can not null or blank.", "Failed")
            return ResponseEntity.badRequest().body(response)
        }

        if (!BankConstants.getACCOUNT_TYPES().contains(accountType)) {
            response = new MessageResponse(400, "Please enter valid account type.", "Failed")
            return ResponseEntity.badRequest().body(response)
        }

        Object principal = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal()
        User loggingUser = userService.findById(principal.getId())

        Account newAccount = new Account(loggingUser, account.getAccountType(), account.getBranchAddress())

        def savedAccount = accountService.save(newAccount)

        if (savedAccount == null) {
            response = new MessageResponse(500, "Please enter valid account type.", "Failed")
            return ResponseEntity.status(500).body(response)
        }

        return ResponseEntity.ok().body(savedAccount)
    }
}
