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

    public DutyModel(DayModel dayModel, BreakModel breakModel, PlaceModel placeModel){
        this.day = dayModel.getDay();
        this.breakId = breakModel.getId();
        this.placeId = placeModel.getId();
    }
}
