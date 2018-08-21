package pl.dudekjunior.DutySchedule.models.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dudekjunior.DutySchedule.models.entities.BreakEntity;
import pl.dudekjunior.DutySchedule.models.entities.DutyEntity;
import pl.dudekjunior.DutySchedule.models.forms.BreakForm;
import pl.dudekjunior.DutySchedule.models.repositories.BreakRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BreakService {
    private final BreakRepository breakRepository;
    @Autowired
    public BreakService(BreakRepository breakRepository) {
        this.breakRepository = breakRepository;
    }

    List<BreakEntity> getAllBreaks(){
        List<BreakEntity> breakEntities = new ArrayList<>();
        for(BreakEntity breakEntity : breakRepository.findAll()){
            breakEntities.add(breakEntity);
        }
        return breakEntities.stream().sorted(Comparator.comparing(BreakEntity::getBreakNumber)).collect(Collectors.toList());
    }

    int teacherDutyTime(List<DutyEntity> teacherDuties){
        int sum = 0;
        for (DutyEntity duty: teacherDuties) {
            sum = sum + breakRepository.findById(duty.getBreakId()).get().getBreakLength();
        }
        return sum;
    }

    public void addBreak(BreakForm breakForm) {
        breakRepository.save(createBreakEntity(breakForm));
    }

    private BreakEntity createBreakEntity(BreakForm breakForm){
        BreakEntity breakEntity = new BreakEntity();
        breakEntity.setBreakNumber(breakForm.getBreakNumber());
        breakEntity.setBreakLength(breakForm.getBreakLength());
        breakEntity.setBreakTime(breakForm.getBreakTime());

        return breakEntity;
    }
}
