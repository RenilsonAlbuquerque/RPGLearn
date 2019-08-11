package com.shakal.rpg.api.security;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class KeyService {
    @Value("${security.jwt.token.secret-key:secret}")
    static String SECRET_KEY = "secret";

    @Value("${security.jwt.token.expire-length:3600000}")
    static long EXPIRATION_TIME = 860_000_000; // 8days
}
