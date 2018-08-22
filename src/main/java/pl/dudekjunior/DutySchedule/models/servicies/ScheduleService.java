package pl.dudekjunior.DutySchedule.models.servicies;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dudekjunior.DutySchedule.models.*;
import pl.dudekjunior.DutySchedule.models.entities.BreakEntity;
import pl.dudekjunior.DutySchedule.models.entities.PlaceOfGuardEntity;
import pl.dudekjunior.DutySchedule.models.entities.TeacherEntity;

import java.util.ArrayList;
import java.util.Comparator;
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
        List<TeacherEntity> teacherEntities = teacherService.getAllTeachers();
        schedule.setTeacherEntities(teacherEntities);
        schedule.setTeacherModelsWithDutyTime(getTeacherModelsWithDutyTime(teacherEntities));
        schedule.setTeacherWithMaxTime(getTeacherWithMostOfBreakTime(teacherEntities));
        schedule.setTeacherWithMinTime(getTeacherWithLeastBreakTime(teacherEntities));

        for(String day : dayService.getDaysOfWeek()){
            DayModel dayModel = new DayModel(day);
            for(BreakEntity breakEntity : breakService.getAllBreaks()){
                BreakModel breakModel = new BreakModel(breakEntity);
                for(PlaceOfGuardEntity placeOfGuardEntity : placeOfGaurdService.getAllPlaces()){
                    PlaceModel placeModel = new PlaceModel(placeOfGuardEntity);
                    checkPlaceIsAssigned(day, breakEntity, placeOfGuardEntity, placeModel);
                    breakModel.getPlaces().add(placeModel);
                }
                dayModel.getDutyBreaks().add(breakModel);
            }
            schedule.getDays().add(dayModel);
        }
        return schedule;
    }

    private void checkPlaceIsAssigned(String day, BreakEntity breakEntity, PlaceOfGuardEntity placeOfGuardEntity, PlaceModel placeModel) {
        placeModel.setAssigned(dutyService.isDutyPlaceIsAssigned(day, breakEntity.getId(),placeOfGuardEntity.getId()));
        if(placeModel.isAssigned()){
            int teacherId = dutyService.getTeacherIdByDayBreakPlace(day, breakEntity.getId(),placeOfGuardEntity.getId());
            placeModel.setTeacher(teacherService.findById(teacherId).get());
        }
    }

    private List<TeacherModel> getTeacherModelsWithDutyTime(List<TeacherEntity> teacherEntities){

        List<TeacherModel> teacherModels = new ArrayList<>();

        changeIterableToList(teacherEntities, teacherModels);

        teacherModels.sort(Comparator.comparing(TeacherModel::getDutyTime));

        return teacherModels;
    }

    private void changeIterableToList(List<TeacherEntity> teacherEntities, List<TeacherModel> teacherModels) {
        for (TeacherEntity teacherEntity : teacherEntities) {
            TeacherModel teacher = new TeacherModel();
            teacher.setId(teacherEntity.getId());
            teacher.setName(teacherEntity.getName());
            teacher.setSurname(teacherEntity.getSurname());
            teacher.setDutyTime(setTeacherDutyTime(teacherEntity));
            teacherModels.add(teacher);
        }
    }

    private int setTeacherDutyTime(TeacherEntity teacherEntity){
        int maxDutyTime = (int)(120 * teacherEntity.getWorkTime());
        int dutyTime = breakService.teacherDutyTime(dutyService.teacherDuties(teacherEntity.getId()));
        return (dutyTime * 100/maxDutyTime);
    }

    private TeacherModel getTeacherWithLeastBreakTime(List<TeacherEntity> teacherEntities){
        return getTeacherModelsWithDutyTime(teacherEntities).stream().min(Comparator.comparing(TeacherModel::getDutyTime)).get();
    }

    private TeacherModel getTeacherWithMostOfBreakTime(List<TeacherEntity> teacherEntities){
        return getTeacherModelsWithDutyTime(teacherEntities).stream().max(Comparator.comparing(TeacherModel::getDutyTime)).get();
    }
}
