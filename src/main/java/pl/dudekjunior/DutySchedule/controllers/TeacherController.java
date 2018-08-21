package pl.dudekjunior.DutySchedule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.dudekjunior.DutySchedule.models.forms.TeacherForm;
import pl.dudekjunior.DutySchedule.models.servicies.TeacherService;

@Controller
public class TeacherController {

    private final TeacherService teacherService;
    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/addTeacher")
    public String addTeacher(Model model){
        model.addAttribute("teacherForm", new TeacherForm());
        return "addteacher";
    }

    @PostMapping("/addTeacher")
    public String addTeacher(@ModelAttribute("teacherForm") TeacherForm teacherForm){
        teacherService.addTeacher(teacherForm);
        return "redirect:/";
    }
}
