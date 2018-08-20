package pl.dudekjunior.DutySchedule.models.forms;

import lombok.Data;

@Data
public class BreakForm {

    private int breakNumber;
    private int breakLength;
    private String breakTime;
}
