package com.universeofaircraft.Leng.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TermsController {
    @GetMapping("/addTerm")
    public String addTerm(Model model){
        return "addTerm";
    }

    @GetMapping("/postTerm")
    public String postTerm(
            @RequestParam String term,
            @RequestParam String definition){
        System.out.println(term);
        System.out.println(definition);

        return "redirect:/addTerm";
    }
}
