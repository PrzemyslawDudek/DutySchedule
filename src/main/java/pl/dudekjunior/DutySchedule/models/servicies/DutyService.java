package pl.dudekjunior.DutySchedule.models.servicies;

import org.springframework.stereotype.Service;
import pl.dudekjunior.DutySchedule.models.entities.DutyEntity;
import pl.dudekjunior.DutySchedule.models.forms.DutyForm;
import pl.dudekjunior.DutySchedule.models.repositories.DutyRepository;

@Service
public class DutyService {

    private final DutyRepository dutyRepository;

    public DutyService(DutyRepository dutyRepository) {
        this.dutyRepository = dutyRepository;
    }


    public void addDuty(DutyForm dutyForm, int placeId, int breakId, String day) {
        dutyRepository.save(createDutyEntity(dutyForm, placeId, breakId, day));
    }

    private DutyEntity createDutyEntity(DutyForm dutyForm, int placeId, int breakId, String day){
        DutyEntity dutyEntity = new DutyEntity();
        dutyEntity.setTeacherId(dutyForm.getTeacherId());
        dutyEntity.setPlaceId(placeId);
        dutyEntity.setBreakId(breakId);
        dutyEntity.setDay(day);
        return dutyEntity;
    }

    public boolean isDutyPlaceIsAssigned(String day, int breakNumber, int placeNumber){
        return dutyRepository.existsByDayAndBreakIdAndPlaceId(day, breakNumber, placeNumber);
    }

    public int getTeacherIdByDayBreakPlace(String day, int breakId, int placeId) {
        DutyEntity dutyEntity = dutyRepository.findByDayAndBreakIdAndPlaceId(day, breakId, placeId);
        return dutyEntity.getTeacherId();
    }

    public void deleteDuty(String day, int breakId, int placeId) {
        DutyEntity dutyEntity = dutyRepository.findByDayAndBreakIdAndPlaceId(day, breakId, placeId);
        dutyRepository.deleteById(dutyEntity.getId());
    }
}
