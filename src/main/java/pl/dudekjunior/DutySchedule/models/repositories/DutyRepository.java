package pl.dudekjunior.DutySchedule.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.dudekjunior.DutySchedule.models.entities.DutyEntity;

public interface DutyRepository extends CrudRepository<DutyEntity, Integer> {
    Boolean existsByDayAndBreakIdAndPlaceId(String day, int breakNumber, int placeNumber);
    DutyEntity findByDayAndBreakIdAndPlaceId(String day, int breakId, int placeId);
}
