package pl.dudekjunior.DutySchedule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.dudekjunior.DutySchedule.models.forms.BreakForm;
import pl.dudekjunior.DutySchedule.models.servicies.BreakService;

@Controller
public class BreakController {


    private final BreakService breakService;

    @Autowired
    public BreakController(BreakService breakService) {
        this.breakService = breakService;
    }

    @GetMapping("/addBreak")
    public String addBreak(Model model){
        model.addAttribute("breakForm", new BreakForm());
        return "addbreak";
    }

    @PostMapping("/addBreak")
    public String addBreak(@ModelAttribute("breakForm") BreakForm breakForm){
        if(breakService.addBreak(breakForm)){
            return "redirect:/";
        }

        return "/addBreak";
    }
}
