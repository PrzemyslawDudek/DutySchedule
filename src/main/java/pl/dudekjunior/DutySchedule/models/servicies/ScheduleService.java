package pl.dudekjunior.DutySchedule.models.servicies;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dudekjunior.DutySchedule.models.*;
import pl.dudekjunior.DutySchedule.models.entities.BreakEntity;
import pl.dudekjunior.DutySchedule.models.entities.PlaceOfGuardEntity;

import java.util.List;

@Service
@Data
public class ScheduleService {


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


    public ScheduleModel createSchedule(){
        ScheduleModel schedule = new ScheduleModel();
        List<String> days = dayService.getDaysOfWeek();
        Iterable<BreakEntity> breaks = breakService.getAllBreaks();
        Iterable<PlaceOfGuardEntity> placesOfGuard = placeOfGaurdService.getAllPlaces();

        for(String day : days){
            DayModel dayModel = new DayModel(day);

            for(BreakEntity breakEntity : breaks){
                BreakModel breakModel = new BreakModel(breakEntity);

                for(PlaceOfGuardEntity placeOfGuardEntity : placesOfGuard){
                    PlaceModel placeModel = new PlaceModel(placeOfGuardEntity);

                    placeModel.setAssigned(dutyService.isDutyPlaceIsAssigned(day, breakEntity.getId(),placeOfGuardEntity.getId()));
                    if(placeModel.isAssigned()){
                        int teacherId = dutyService.getTeacherIdByDayBreakPlace(day, breakEntity.getId(),placeOfGuardEntity.getId());

                        placeModel.setTeacher(teacherService.findById(teacherId).get());
                    }
                    breakModel.getPlaces().add(placeModel);

                }

                dayModel.getDutyBreaks().add(breakModel);
            }

            schedule.getDays().add(dayModel);
        }
        return schedule;
    }
}
