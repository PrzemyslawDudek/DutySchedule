package pl.dudekjunior.DutySchedule.models;

import lombok.Data;

@Data
public class TeacherModel {
    private int id;
    private String name;
    private String surname;
    private int dutyTime;
}
