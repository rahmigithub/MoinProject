package org.innova.moinproject.service;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private final String SECRET_KEY = "asdadlowrefrnfa24313eakdslaknof4xa56423odiasdadlowrefrnfa24313eakdslaknof4xa56423odiasdadlowrefrnfa24313eakdslaknof4xa56423odi";


    public String validateToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY.getBytes())
                .parseClaimsJws(token)
                .getBody()
                .getSubject();  // Token'daki 'subject' kısmını (yani kullanıcı adını) döndürüyoruz
    }



}

