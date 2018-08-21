package pl.dudekjunior.DutySchedule.models.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dudekjunior.DutySchedule.models.entities.TeacherEntity;
import pl.dudekjunior.DutySchedule.models.forms.TeacherForm;
import pl.dudekjunior.DutySchedule.models.repositories.TeacherRepository;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<TeacherEntity> getAllTeachers(){
        List<TeacherEntity> teachers = new ArrayList<>();
        for(TeacherEntity teacher : teacherRepository.findAll()){
            teachers.add(teacher);
        }
        return teachers.stream().sorted(Comparator.comparing(TeacherEntity::getName)).collect(Collectors.toList());
    }

    Optional<TeacherEntity> findById(int teacherId) {
        return teacherRepository.findById(teacherId);
    }


    public void addTeacher(TeacherForm teacherForm) {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setName(teacherForm.getName());
        teacherEntity.setSurname(teacherForm.getSurname());
        teacherRepository.save(teacherEntity);
    }
}
