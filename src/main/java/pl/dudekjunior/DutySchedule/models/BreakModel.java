package pl.dudekjunior.DutySchedule.models;

import lombok.Data;
import pl.dudekjunior.DutySchedule.models.entities.BreakEntity;

import java.util.ArrayList;
import java.util.List;

@Data
public class BreakModel {
    private int id;
    private int breakNumber;
    private int breakLength;
    private String breakTime;
    private List<PlaceModel> places;

    public BreakModel(BreakEntity breakEntity){
        this.id = breakEntity.getId();
        this.breakNumber = breakEntity.getBreakNumber();
        this.breakLength = breakEntity.getBreakLength();
        this.breakTime = breakEntity.getBreakTime();
        places = new ArrayList<>();
    }
}
