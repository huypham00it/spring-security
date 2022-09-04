package com.springsecurity_app.springboot_auth_jwt_mongo.security.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.springsecurity_app.springboot_auth_jwt_mongo.constants.SecurityConstants
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.util.StringUtils

import javax.crypto.spec.SecretKeySpec

import static org.springframework.http.HttpHeaders.AUTHORIZATION
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets

//class RequestValidationBeforeFilter implements Filter {
//    static final String AUTHENTICATION_SCHEME_BEARER = "Bearer"
//
//    @Override
//    void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request
//        HttpServletResponse res = (HttpServletResponse) response
//        String requestHeader = req.getHeader(AUTHORIZATION)
//        if (requestHeader != null) {
//            requestHeader = requestHeader.trim()
//            if (StringUtils.startsWithIgnoreCase(requestHeader, AUTHENTICATION_SCHEME_BEARER)) {
//                def token = requestHeader.substring(7)
//                def chunks = token.split("\\.")
//
//                try {
//                    Base64.Decoder decoder = Base64.getUrlDecoder()
//
//                    String payload = new String(decoder.decode(chunks[1]))
//                    ObjectMapper mapper = new ObjectMapper()
//                    Map<String, String> map = mapper.readValue(payload, Map.class)
//
//                    String username = map.get("sub")
//                    int delim = username.indexOf(" ")
//                    if (delim != -1) {
//                        res.setStatus(HttpServletResponse.SC_BAD_REQUEST)
//                        return
//                    }
//                } catch (IllegalArgumentException e) {
//                    throw new BadCredentialsException("Failed to decode bearer authentication token")
//                }
//            }
//        }
//        chain.doFilter(request, response)
//    }
//}
