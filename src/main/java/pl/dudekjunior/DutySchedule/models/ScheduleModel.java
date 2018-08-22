package pl.dudekjunior.DutySchedule.models;

import lombok.Data;

import pl.dudekjunior.DutySchedule.models.entities.TeacherEntity;


import java.util.ArrayList;
import java.util.List;

@Data
public class ScheduleModel {
    private List<DayModel> days = new ArrayList<>();
    private List<TeacherEntity> teacherEntities;
    private List<TeacherModel> teacherModelsWithDutyTime;
    private TeacherModel teacherWithMaxTime;
    private TeacherModel teacherWithMinTime;
}
