package com.springsecurity_app.springboot_auth_jwt_mongo.config


import com.springsecurity_app.springboot_auth_jwt_mongo.security.jwt.AuthTokenFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource

import javax.servlet.http.HttpServletRequest

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
//        securedEnabled = true,//@Secured
//        jsr250Enabled = true,//@RoleAllowed
        prePostEnabled = true)
//@PreAuthorize, @PostAuthorize
class WebSecurityConfig {
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder()
    }

    @Bean
    AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager()
    }

    @Bean
    AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter()
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors().configurationSource(new CorsConfigurationSource() {
            @Override
            CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration config = new CorsConfiguration()
                config.setAllowedOrigins(Collections.singletonList("http://localhost:3000"))
                config.setAllowedMethods(Collections.singletonList("*"))
                config.setAllowCredentials(true)
                config.setAllowedHeaders(Collections.singletonList("*"))
                config.setExposedHeaders(Arrays.asList("Authorization"))
                config.setMaxAge(3600L)
                return config
            }
        }).and()
                .csrf().disable()
                .addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests((auth) -> auth
                        .antMatchers("/api/v1/auth/**").permitAll()
                        .antMatchers("/api/v1/spotlights").permitAll()
                        .antMatchers("/api/v1/jobs").permitAll()
                        .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults())
        return http.build()
    }
}
