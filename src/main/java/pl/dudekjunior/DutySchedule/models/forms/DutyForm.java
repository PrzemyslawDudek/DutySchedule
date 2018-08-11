package pl.dudekjunior.DutySchedule.models.forms;

import lombok.Data;

@Data
public class DutyForm {
    private int id;
    private String day;
    private int breakId;
    private int placeId;
    private int teacherId;
}
