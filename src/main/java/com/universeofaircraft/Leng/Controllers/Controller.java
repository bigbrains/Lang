package com.universeofaircraft.Leng.Controllers;

import com.universeofaircraft.Leng.Entites.User;
import com.universeofaircraft.Leng.Services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class Controller {
    private final UserService userService;

    Controller(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(User user) {
        userService.signupUser(user);
        return "redirect:/login";
    }
}
