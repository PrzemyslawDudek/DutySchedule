package pl.dudekjunior.DutySchedule.models.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dudekjunior.DutySchedule.models.entities.BreakEntity;
import pl.dudekjunior.DutySchedule.models.entities.DutyEntity;
import pl.dudekjunior.DutySchedule.models.repositories.BreakRepository;

import java.util.List;

@Service
public class BreakService {
    private final BreakRepository breakRepository;
    @Autowired
    public BreakService(BreakRepository breakRepository) {
        this.breakRepository = breakRepository;
    }

    public Iterable<BreakEntity> getAllBreaks(){
        return breakRepository.findAll();
    }

    public int teacherDutyTime(List<DutyEntity> teacherDuties){
        int sum = 0;
        for (DutyEntity duty: teacherDuties) {
            sum = sum + breakRepository.findById(duty.getBreakId()).get().getBreakLength();
        }
        return sum;
    }
}
