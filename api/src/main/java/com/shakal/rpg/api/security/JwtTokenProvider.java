package com.shakal.rpg.api.security;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.service.UserService;

import java.util.*;

@Service
public class JwtTokenProvider {
	

    static String SECRET_KEY = "secret";

    static long EXPIRATION_TIME = 860_000_000; // 8days

    static final String TOKEN_PREFIX = "Bearer";

    static final String HEADER_STRING = "Authorization";

    @Autowired
    private UserService userService;

    @PostConstruct
    protected void init() {
        SECRET_KEY = Base64.getEncoder().encodeToString(SECRET_KEY.getBytes());
    }

    static String addAuthentication(Long id, String username, Collection<? extends GrantedAuthority> autorizations) {

        
        String JWT = Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .claim("id", id)
                .claim("username", username)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();

        
        return  TOKEN_PREFIX + " " + JWT;
    }

    static AuthenticationContext getAuthentication(HttpServletRequest request) throws SignatureException, BadCredentialsException {
        String token = request.getHeader(HEADER_STRING);

        Claims claims = null;
        if(token != null) {
            claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();

            String user = (String) claims.get("username");
            long id = (Integer) claims.get("id");
          
            /*
            ArrayList<String> claimsRoles = (ArrayList<String>) claims.get("roles");
            for (String s : claimsRoles) {
                TypeRole role = TypeRole.valueOf(s);
                roles.add(staticRoleRepository.findAllByType(role));
            }
             */
            if (user != null) {
                return new AuthenticationContext(id,user);
            }
        }
        return null;
    }

}
