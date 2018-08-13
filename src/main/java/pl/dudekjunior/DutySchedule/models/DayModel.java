package pl.dudekjunior.DutySchedule.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DayModel {
    private String day;
    private List<BreakModel> dutyBreaks;

    public DayModel(String day){
        this.day = day;
        dutyBreaks = new ArrayList<>();
    }
}
