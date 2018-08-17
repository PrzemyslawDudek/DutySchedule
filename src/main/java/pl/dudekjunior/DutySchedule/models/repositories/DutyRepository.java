package pl.dudekjunior.DutySchedule.models.repositories;


import org.springframework.data.repository.CrudRepository;
import pl.dudekjunior.DutySchedule.models.entities.DutyEntity;

import java.util.List;

public interface DutyRepository extends CrudRepository<DutyEntity, Integer> {
    Boolean existsByDayAndBreakIdAndPlaceId(String day, int breakId, int placeId);
    DutyEntity findByDayAndBreakIdAndPlaceId(String day, int breakId, int placeId);

    List<DutyEntity> findByTeacherId(int teacherId);
}
