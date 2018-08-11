package pl.dudekjunior.DutySchedule.models.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dudekjunior.DutySchedule.models.entities.TeacherEntity;
import pl.dudekjunior.DutySchedule.models.repositories.TeacherRepository;


@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Iterable<TeacherEntity> getAllTeachers(){
        return teacherRepository.findAll();
    }
}
