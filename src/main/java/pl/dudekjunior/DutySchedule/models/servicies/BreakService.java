package pl.dudekjunior.DutySchedule.models.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dudekjunior.DutySchedule.models.entities.BreakEntity;
import pl.dudekjunior.DutySchedule.models.repositories.BreakRepository;

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
}
