package com.universeofaircraft.Leng.Controllers;

import com.universeofaircraft.Leng.Entites.Set;
import com.universeofaircraft.Leng.Entites.User;
import com.universeofaircraft.Leng.Services.SetService;
import com.universeofaircraft.Leng.Services.TermService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SetController {
    private final SetService setService;
    private final TermService termService;

    public SetController(SetService setService, TermService termService) {
        this.setService = setService;
        this.termService = termService;
    }

    @GetMapping("/createSet")
    public String createSet() {
        return "createSet";
    }

    @GetMapping("/set/{id}")
    public String getSet(@PathVariable int id, Model model) {
        Set set = setService.getSetById(id);
        model.addAttribute("set", set);
        model.addAttribute("terms", termService.getTerms(set));
        return "set";
    }

    @PostMapping(value = "/postSet", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> postSet(@RequestBody Set set, @AuthenticationPrincipal User user) {
        setService.addSet(set, user);
        return new ResponseEntity<>(set.getId(), new HttpHeaders(), 201);
    }

    @PutMapping("/postSet")
    public ResponseEntity<Integer> putSet(@RequestBody Set set, @AuthenticationPrincipal User user) {
        setService.updateSet(set, user);
        return new ResponseEntity<>(set.getId(), new HttpHeaders(), 202);
    }
}
