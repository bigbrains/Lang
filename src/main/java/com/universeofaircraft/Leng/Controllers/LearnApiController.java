package com.universeofaircraft.Leng.Controllers;

import com.universeofaircraft.Leng.Entites.Learn;
import com.universeofaircraft.Leng.Services.LearnModeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LearnApiController {
    private final LearnModeService learnModeService;

    LearnApiController(LearnModeService learnModeService) {
        this.learnModeService = learnModeService;
    }

    @PostMapping("/set/{setId}/learn/{learnId}/update")
    public Learn updateLearn(@PathVariable int setId, @PathVariable int learnId, HttpEntity<String> httpEntity) {
        System.out.println(httpEntity.getBody());

        return new Learn();
    }
}
