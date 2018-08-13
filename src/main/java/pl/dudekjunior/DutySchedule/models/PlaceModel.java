package pl.dudekjunior.DutySchedule.models;

import lombok.Data;
import pl.dudekjunior.DutySchedule.models.entities.PlaceOfGuardEntity;
import pl.dudekjunior.DutySchedule.models.entities.TeacherEntity;

@Data
public class PlaceModel {
    private int id;
    private String name;
    private TeacherEntity teacher;
    private boolean isAssigned;

    public PlaceModel(PlaceOfGuardEntity placeOfGuardEntity){
        this.id = placeOfGuardEntity.getId();
        this.name = placeOfGuardEntity.getName();
    }
}
