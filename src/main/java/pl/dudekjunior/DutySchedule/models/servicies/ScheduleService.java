package pl.dudekjunior.DutySchedule.models.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import pl.dudekjunior.DutySchedule.models.DutyModel;
import pl.dudekjunior.DutySchedule.models.entities.BreakEntity;
import pl.dudekjunior.DutySchedule.models.entities.PlaceOfGuardEntity;

import java.util.List;

public class ScheduleService {

    private List<DutyModel> dutyPlaces;

    private final DayService dayService;
    private final BreakService breakService;
    private final PlaceOfGaurdService placeOfGaurdService;
    private final DutyService dutyService;
    private final TeacherService teacherService;

    @Autowired
    public ScheduleService(DayService dayService,
                           BreakService breakService,
                           PlaceOfGaurdService placeOfGaurdService,
                           DutyService dutyService,
                           TeacherService teacherService) {
        this.dayService = dayService;
        this.breakService = breakService;
        this.placeOfGaurdService = placeOfGaurdService;
        this.dutyService = dutyService;
        this.teacherService = teacherService;
    }

    public void createDutyPlaces(){
        List<String> days = dayService.getDaysOfWeek();
        Iterable<BreakEntity> breaks = breakService.getAllBreaks();
        Iterable<PlaceOfGuardEntity> placesOfGuard = placeOfGaurdService.getAllPlaces();
        for(String day : days){
            for(BreakEntity breakDuty : breaks){
                for(PlaceOfGuardEntity place : placesOfGuard){
                    DutyModel duty = new DutyModel(day, breakDuty.getId(), place.getId());
                    if(dutyService.isDutyIsAssigned(day, breakDuty.getId(), place.getId())){
                        duty.setAssigned(true);
                    }
                }
            }
        }
    }
}
