package com.opensource.projects.service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String SECRET;
    Logger logger = LoggerFactory.getLogger(JwtService.class);
    public String generateToken(UserDetails user){
        return Jwts.builder()
                .claim("authorities",populateAuthorities(user.getAuthorities()))
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+ 604800000))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private String populateAuthorities(Collection<? extends GrantedAuthority> authorities){
        Set<String> authSet = new HashSet<>();
        for(GrantedAuthority authority : authorities){
            authSet.add(authority.getAuthority());
        }
        return String.join(",",authSet);
    }

    private SecretKey getSigningKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUsername(String token){
        return extractClaims(token,Claims::getSubject);
    }

    public <T> T extractClaims(String token, Function<Claims, T> claimResolver){
        Claims claims = getALlClaims(token);
        return claimResolver.apply(claims);
    }

    public Claims getALlClaims(String token){
        try {
            return Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        }
        catch(JwtException e){
            logger.info("Exception in getAllClaims JWTException" + e.getMessage());
            e.printStackTrace();
            throw e;
        }
        catch (Exception e){
            logger.info("Exception in getAllClaims Exception" + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
