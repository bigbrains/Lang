package com.universeofaircraft.Leng.Controllers;

import com.universeofaircraft.Leng.Entites.User;
import com.universeofaircraft.Leng.Repository.SetRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryController {
    private final SetRepository setRepository;

    public LibraryController(SetRepository setRepository) {
        this.setRepository = setRepository;
    }


    @GetMapping("/library")
    public String library(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("sets", setRepository.findAllByUser(user));
        return "library";
    }
}
