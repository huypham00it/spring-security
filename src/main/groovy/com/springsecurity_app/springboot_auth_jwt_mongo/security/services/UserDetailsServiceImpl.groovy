package com.springsecurity_app.springboot_auth_jwt_mongo.security.services

import com.springsecurity_app.springboot_auth_jwt_mongo.models.User
import com.springsecurity_app.springboot_auth_jwt_mongo.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository

    @Override
    @Transactional
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
        return UserDetailsImpl.build(user)
    }
}
