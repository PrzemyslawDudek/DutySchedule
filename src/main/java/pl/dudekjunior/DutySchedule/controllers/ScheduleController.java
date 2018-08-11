package pl.dudekjunior.DutySchedule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.dudekjunior.DutySchedule.models.forms.DutyForm;
import pl.dudekjunior.DutySchedule.models.servicies.*;

@Controller
public class ScheduleController {

    private final TeacherService teacherService;
    private final BreakService breakService;
    private final PlaceOfGaurdService placeOfGaurdService;
    private final DayService dayService;
    private final DutyService dutyService;

    @Autowired
    public ScheduleController(TeacherService teacherService,
                              BreakService breakService,
                              PlaceOfGaurdService placeOfGaurdService,
                              DayService dayService,
                              DutyService dutyService) {
        this.teacherService = teacherService;
        this.breakService = breakService;
        this.placeOfGaurdService = placeOfGaurdService;
        this.dayService = dayService;
        this.dutyService = dutyService;
    }

    @GetMapping("/")
    public String schedule(Model model){
        model.addAttribute("dutyForm", new DutyForm());
        model.addAttribute("placesOfGuard", placeOfGaurdService.getAllPlaces());
        model.addAttribute("teachers", teacherService.getAllTeachers());
        model.addAttribute("breaks", breakService.getAllBreaks());
        model.addAttribute("days", dayService.getDaysOfWeek());
        return "schedule";
    }

    @PostMapping("/addDuty/{placeId}/{breakId}/{day}")
    public String addDuty(@ModelAttribute("dutyForm") DutyForm dutyForm,
                          @PathVariable("placeId") int placeId,
                          @PathVariable("breakId") int breakId,
                          @PathVariable("day") String day){
        if(dutyForm.getTeacherId() == 0){
            return "redirect:/";
        }
        dutyService.addDuty(dutyForm, placeId, breakId, day);
        return "redirect:/";
    }
}
