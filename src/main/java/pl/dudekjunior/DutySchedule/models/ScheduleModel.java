package pl.dudekjunior.DutySchedule.models;

import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
public class ScheduleModel {
    private List<DayModel> days = new ArrayList<>();
}
