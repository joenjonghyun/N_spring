package kr.co.patternbot.controllers;

import kr.co.patternbot.domains.User;
import kr.co.patternbot.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;


    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return service.login(user);
    }
    @GetMapping("/logout")
    public String logout() {
        return "";
    }
}
