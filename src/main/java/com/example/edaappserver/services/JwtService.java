package com.example.edaappserver.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

// тут блять курсач по ебаному ОИБу блять.
// Лютый негр! Таким неграм надо памятники чугунные на вокзалах ставить, а не руки ремнями вязать и никак уж не в рабство сдавать.
@Service
public class JwtService {
    private static final String SECRET_KEY = ("9c56bbb2442aa20f7d48ce5ba13b75c38000266334fb008387322a8a8ff24944").toUpperCase();

    public String extractUsername(String jwtToken) {
        return extractClaim(jwtToken, Claims::getSubject);// ну тут получается их клейма мы нюхаем юзернейм, те почта
    }
    public <T> T extractClaim (String jwtToken, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(jwtToken);
        return claimsResolver.apply(claims);// клейм какой то, ну по идее это что то этакое, как энтропия, всегда есть и будет, насчет постоянства не знаю, хуйней пахнет
    }
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);// потом че то сделает негр, я хуй знает
    }
    public String generateToken(Map<String, Objects> claims, UserDetails userDetails){
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis())) // когда создан токен
                .setExpiration(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 7))) // время действия (текущее время + (1000 мс * 60 * 60 * 24 * 7)) те 7 дней
                .signWith(getSignInKey(), SignatureAlgorithm.HS256) // подпись токена, хуйня какая то, негр реально смешной, он говорит ЭЙ ЧЕС ТУ ФАЙВ СИКС, забавный короче
                .compact(); // ад закончен, токен создан, наверное... я в ахуе от этих манипуляций. Ну а че, безопасность.
    }
    public boolean isTokenValid(String jwtToken, UserDetails userDetails){
        final String username = extractUsername(jwtToken);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(jwtToken); // тут валидация токена, ну по сути ниче сложно, но вот дальше циганские фокусы
    }

    private boolean isTokenExpired(String jwtToken) {
        return extractExpiration(jwtToken).before(new Date()); // срет методами как черт, экстрактор блять...
    }

    private Date extractExpiration(String jwtToken) {
        return extractClaim(jwtToken, Claims::getExpiration); // че за :: я в душе не ебу, надо узнать
    }

    private Claims extractAllClaims(String jwtToken){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();// тут мы все клеймы кушаем, я так понял клейм это поля запроса, а может и нет. я ебу что ли? я ведь не пушкин
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);// опять оиб попер, ну то дешифровка по ключу
    }
}
