package pl.project.securities.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.project.securities.models.User;

import java.util.Date;

@RestController
public class LoginApi {

    @PostMapping("/api/login")
    public String login(@RequestBody User user) {

        long currentTime = System.currentTimeMillis();
        //todo check in database for user and if exist retur token
        return Jwts.builder()
                .setSubject(user.getLogin())
                .claim("roles", "user")
                .setIssuedAt(new Date(currentTime))
                .setExpiration(new Date(currentTime + 20000))
                .signWith(SignatureAlgorithm.HS512, user.getPassword())
                .compact();

    }
}
