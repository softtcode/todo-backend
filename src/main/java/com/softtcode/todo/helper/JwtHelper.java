package com.softtcode.todo.helper;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class JwtHelper {

    private final String secretKey="softtcode12321";
    private final Algorithm algorithm=Algorithm.HMAC256(secretKey);
    private final long expTime = 1000*60*60*24;

    public String generateJwt(String email){
        Date expDate = new Date(System.currentTimeMillis()+expTime);
        String jwt = JWT
                .create()
                .withSubject(email)
                .withExpiresAt(expDate)
                .sign(algorithm);
        return jwt;
    }

    public DecodedJWT verifyJwt(String token){
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        return decodedJWT;
    }
    public String getTokenSubject(String token){
        return verifyJwt(token).getSubject();
    }
}
