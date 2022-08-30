package com.springsecurity_app.springboot_auth_jwt_mongo.security.jwt

import com.springsecurity_app.springboot_auth_jwt_mongo.constants.SecurityConstants
import com.springsecurity_app.springboot_auth_jwt_mongo.security.services.UserDetailsImpl
import io.jsonwebtoken.impl.TextCodec
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

import org.slf4j.Logger

import java.security.SignatureException
import io.jsonwebtoken.*

@Component
class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class)

    @Value(SecurityConstants.JWT_SECRET)
    private String jwtSecret

    private int jwtExpirationMs = SecurityConstants.JWT_EXPIRATION


    String generateJwtToken(Authentication authentication) {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal()

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.decode(jwtSecret))
                .compact()
    }

    String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject()
    }

    boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken)
            return true
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage())
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage())
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage())
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage())
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage())
        }
        return false
    }
}
