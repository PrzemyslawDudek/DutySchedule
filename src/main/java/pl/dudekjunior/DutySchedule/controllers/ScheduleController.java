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

    private final DutyService dutyService;
    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(TeacherService teacherService,
                              DutyService dutyService,
                              ScheduleService scheduleService) {
        this.teacherService = teacherService;
        this.dutyService = dutyService;
        this.scheduleService = scheduleService;
    }

    @GetMapping("/")
    public String schedule(Model model){
        model.addAttribute("dutyForm", new DutyForm());

        model.addAttribute("teachers", teacherService.getAllTeachers());

        model.addAttribute("schedule", scheduleService.createSchedule());
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

    @GetMapping("/deleteDuty/{placeId}/{breakId}/{day}")
    public String deleteDuty(@ModelAttribute("dutyForm") DutyForm dutyForm,
                          @PathVariable("placeId") int placeId,
                          @PathVariable("breakId") int breakId,
                          @PathVariable("day") String day){

        dutyService.deleteDuty(day, breakId, placeId);
        return "redirect:/";
    }
}
