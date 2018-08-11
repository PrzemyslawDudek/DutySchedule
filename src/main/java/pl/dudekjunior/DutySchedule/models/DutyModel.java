package pl.dudekjunior.DutySchedule.models;

import lombok.Data;
import pl.dudekjunior.DutySchedule.models.entities.DutyEntity;

@Data
public class DutyModel {
    private String day;
    private int breakId;
    private int placeId;
    private boolean isAssigned;
    private DutyEntity dutyEntity;

    public DutyModel(String day, int breakId, int placeId){
        this.day = day;
        this.breakId = breakId;
        this.placeId = placeId;
    }
}
