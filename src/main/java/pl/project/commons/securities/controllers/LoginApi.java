package pl.project.commons.securities.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.project.commons.securities.models.User;

@RestController
public class LoginApi {

    @PostMapping("/api/login")
    public String login(@RequestBody User user) {
        return "test";
    }
}
