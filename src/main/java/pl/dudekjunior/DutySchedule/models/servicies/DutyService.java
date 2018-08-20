package pl.dudekjunior.DutySchedule.models.servicies;


import org.springframework.stereotype.Service;
import pl.dudekjunior.DutySchedule.models.entities.DutyEntity;
import pl.dudekjunior.DutySchedule.models.forms.DutyForm;
import pl.dudekjunior.DutySchedule.models.repositories.DutyRepository;

import java.util.List;

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

    public boolean isDutyPlaceIsAssigned(String day, int breakId, int placeId){
        return dutyRepository.existsByDayAndBreakIdAndPlaceId(day, breakId, placeId);
    }

    public int getTeacherIdByDayBreakPlace(String day, int breakId, int placeId) {
        DutyEntity dutyEntity = dutyRepository.findByDayAndBreakIdAndPlaceId(day, breakId, placeId);
        return dutyEntity.getTeacherId();
    }

    public void deleteDuty(String day, int breakId, int placeId) {
        DutyEntity dutyEntity = dutyRepository.findByDayAndBreakIdAndPlaceId(day, breakId, placeId);
        dutyRepository.deleteById(dutyEntity.getId());
    }


    public  List<DutyEntity>teacherDuties(int teacherId){
        return dutyRepository.findByTeacherId(teacherId);
    }
}
