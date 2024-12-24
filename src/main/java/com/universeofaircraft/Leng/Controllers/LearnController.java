package com.universeofaircraft.Leng.Controllers;

import com.universeofaircraft.Leng.Mappers.LearnEntityToModelMapper;
import com.universeofaircraft.Leng.Services.LearnModeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LearnController {
    private final LearnModeService learnModeService;

    LearnController(LearnModeService learnModeService) {
        this.learnModeService = learnModeService;
    }

    @GetMapping("/set/{setId}/learn")
    public String startLearn(@PathVariable int setId) {
        int learnId = learnModeService.createOrFetchLearnId(setId);

        return "redirect:/set/" + setId + "/learn/" + learnId;
    }

    @GetMapping("/set/{setId}/learn/{learnId}")
    public String startLearn(@PathVariable int setId, @PathVariable int learnId, Model model) {
        model.addAttribute("learn", LearnEntityToModelMapper.map(learnModeService.getLearn(learnId)));

        return "learn";
    }
}
