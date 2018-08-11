package pl.dudekjunior.DutySchedule.models.servicies;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class DayService {
    private List<String> daysOfWeek = new ArrayList<>();

    public DayService(){
        daysOfWeek.add("Poniedziałek");
        daysOfWeek.add("Wtorek");
        daysOfWeek.add("Środa");
        daysOfWeek.add("Czwartek");
        daysOfWeek.add("Piątek");
    }
}
