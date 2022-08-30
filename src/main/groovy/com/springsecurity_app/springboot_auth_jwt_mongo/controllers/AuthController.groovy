package com.springsecurity_app.springboot_auth_jwt_mongo.controllers

import com.springsecurity_app.springboot_auth_jwt_mongo.models.ERole
import com.springsecurity_app.springboot_auth_jwt_mongo.models.Role
import com.springsecurity_app.springboot_auth_jwt_mongo.models.User
import com.springsecurity_app.springboot_auth_jwt_mongo.payload.request.LoginRequest
import com.springsecurity_app.springboot_auth_jwt_mongo.payload.request.SignupRequest
import com.springsecurity_app.springboot_auth_jwt_mongo.payload.response.JwtResponse
import com.springsecurity_app.springboot_auth_jwt_mongo.payload.response.MessageResponse
import com.springsecurity_app.springboot_auth_jwt_mongo.security.jwt.JwtUtils
import com.springsecurity_app.springboot_auth_jwt_mongo.security.services.RoleService
import com.springsecurity_app.springboot_auth_jwt_mongo.security.services.UserDetailsImpl
import com.springsecurity_app.springboot_auth_jwt_mongo.security.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.validation.Valid
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/auth")
class AuthController {
    @Autowired
    AuthenticationManager authenticationManager

    @Autowired
    UserService userService

    @Autowired
    RoleService roleService

    @Autowired
    JwtUtils jwtUtils

    @Autowired
    PasswordEncoder encoder

    @PostMapping("/signin")
    ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        def response
        String loginId = loginRequest.getUsername()
        String requestUsername = loginId.contains("@") ? null : loginId
        String requestEmail = requestUsername ? null : loginId
        String password = loginRequest.getPassword()

        //check exist username or password
        if (requestUsername && !userService.existsByUsername(requestUsername)) {
            response = new MessageResponse(400, "Username does not exists!", "Failed")

            return ResponseEntity.status(400).body(response)
        }

        if (requestEmail && !userService.existsByEmail(requestEmail)) {
            response = new MessageResponse(400, "Email does not exists!", "Failed")

            return ResponseEntity.status(400).body(response)
        }

        String username = requestUsername ? requestUsername : userService.findByEmail(requestEmail).getUsername()

        //set authentication
        try {
            def auth = new UsernamePasswordAuthenticationToken(username, password)
            Authentication authentication = authenticationManager.authenticate(auth)

            SecurityContext sc = SecurityContextHolder.getContext()
            sc.setAuthentication(authentication)

            String jwt = jwtUtils.generateJwtToken(authentication)

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal()
            def roles = userDetails.getAuthorities().collect(item -> item.getAuthority())

            response = new JwtResponse(jwt,
                    userDetails.getId(),
                    userDetails.getUsername(),
                    userDetails.getEmail(),
                    roles, new MessageResponse(201, "Login successfully", "Success"))

            return ResponseEntity.status(200).body(response)
        } catch (Exception e) {
            response = new MessageResponse(400, "Password is not correct", "Failed")

            return ResponseEntity.status(400).body(response)
        }

    }

    @PostMapping("/signup")
    ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userService.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(400, "Username is already taken!", "Failed"))
        }

        if (userService.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(400, "Email is already in use!", "Failed"))
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                signUpRequest.getFullName(),
                encoder.encode(signUpRequest.getPassword()))

        Set<String> strRoles = signUpRequest.getRoles()
        Set<Role> roles = new HashSet<>()

        if (strRoles == null) {
            Role userRole = roleService.findByName(ERole.ROLE_USER)
            roles.add(userRole)
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleService.findByName(ERole.ROLE_ADMIN)
                        if (existsByRole(roles, adminRole)) {
                            break
                        }
                        roles.add(adminRole)
                        break
                    case "mod":
                        Role modRole = roleService.findByName(ERole.ROLE_MODERATOR)
                        if (existsByRole(roles, modRole)) {
                            break
                        }
                        roles.add(modRole)
                        break
                    default:
                        Role userRole = roleService.findByName(ERole.ROLE_USER)
                        if (existsByRole(roles, userRole)) {
                            break
                        }
                        roles.add(userRole)
                        break
                }
            })
        }

        user.setRoles(roles)
        userService.save(user)

        return ResponseEntity.status(201).body(new MessageResponse(201, "User registered successfully!", "Success"))
    }

    private static boolean existsByRole(Set<Role> roles, Role role) {
        return roles.contains(role)
    }
}
