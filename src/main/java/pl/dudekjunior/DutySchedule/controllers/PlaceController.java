package pl.dudekjunior.DutySchedule.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.dudekjunior.DutySchedule.models.forms.PlaceForm;
import pl.dudekjunior.DutySchedule.models.servicies.PlaceOfGaurdService;

@Controller
public class PlaceController {

    private final PlaceOfGaurdService placeOfGaurdService;
    @Autowired
    public PlaceController(PlaceOfGaurdService placeOfGaurdService) {
        this.placeOfGaurdService = placeOfGaurdService;
    }

    @GetMapping("/addPlace")
    public String addPlace(Model model){
        model.addAttribute("placeForm", new PlaceForm());
        return "addplace";
    }

    @PostMapping("/addPlace")
    public String addPlace(@ModelAttribute("placeForm") PlaceForm placeForm){
        if(placeOfGaurdService.addPlace(placeForm)){
            return "redirect:/";
        }
        return "/addPlace";
    }
}
